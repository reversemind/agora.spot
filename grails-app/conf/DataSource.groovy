dataSource {
    pooled = true
    driverClassName = "org.postgresql.Driver"
    username = "test"
    password = "test"
    logSql = true
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    development {
        dataSource {
//            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
            dbCreate = "create-drop"
            url = "jdbc:postgresql://localhost:5432/_test_vacuum"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:postgresql://localhost:5432/_test_vacuum"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:postgresql://localhost:5432/_test_vacuum"
        }
    }
}
