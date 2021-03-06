package ru.agora.spot.model.sale

import ru.agora.spot.model.Stuff
import ru.agora.spot.model.common.Base

class SaleItem extends Base{

    Sale sale
    Stuff stuff
    Integer count

    static hasOne = [sale: Sale]

    static mapping = {
        table 'sale_item'
    }

    static constraints = {
        id generator: 'uuid2', length: 36
        sale nullable: false
        stuff nullable: false
        count nullable: false
    }

    public SaleItem() {
        this.stuff = null
        this.count = 0
    }

    public SaleItem(Stuff stuff, Integer count) {
        this.stuff = stuff
        this.count = count
    }

    public SaleItem(UUID id, Stuff stuff, Integer count) {
        super(id)
        this.stuff = stuff
        this.count = count
    }

    Integer getCount() {
        return count
    }

    void setCount(Integer count) {
        this.count = count
    }

    @Override
    public String toString() {
        return "SaleItem{" +
                " id=" + id +
                ", stuff=" + stuff +
                ", count=" + count +
                '}';
    }
}
