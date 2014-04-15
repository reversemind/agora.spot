package ru.agora.spot.model.sale

import ru.agora.spot.model.common.Base
import ru.agora.spot.model.customer.User

class Sale extends Base{

    User author
    String title
    Date start
    Date stop
    Set<SaleItem> saleItems

    static hasMany = [saleItems: SaleItem]

    static mapping = {
        table 'sale'
    }

    static constraints = {
        id generator: 'uuid2', length: 36
        author nullable: false
        title nullable: false, length: 256
        start nullable: false
        stop nullable: false
        saleItems nullable: true
    }

    public Sale() {
        this.author = null;
        this.title = null
        this.start = null
        this.stop = null
        this.saleItems = new HashSet<SaleItem>();
    }

    public Sale(User author, String title, Date start, Date stop, Set<SaleItem> saleItems) {
        this.author = author
        this.title = title
        this.start = start
        this.stop = stop
        this.saleItems = saleItems
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof Sale)) return false
        if (!super.equals(o)) return false

        Sale sale = (Sale) o

        if (id != sale.id) return false
        if (title != sale.title) return false

        return true
    }

    int hashCode() {
        int result = super.hashCode()
        result = 31 * result + title.hashCode()
        return result
    }

    @Override
    public String toString() {
        return "Sale{" +
                " author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", start=" + start +
                ", stop=" + stop +
                ", saleItems=" + saleItems +
                '}';
    }
}
