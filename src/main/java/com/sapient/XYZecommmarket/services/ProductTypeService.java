package com.sapient.XYZecommmarket.services;

import com.sapient.XYZecommmarket.cache.ProductCache;
import com.sapient.XYZecommmarket.domain.ProductType;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeService {



    private ProductCache productCache;

    public void addSupplier(ProductType productType) {
        //refresh products by seller cache
        productCache.evictSingleCacheValue("products","color");
        productCache.evictSingleCacheValue("products","size");
        //TODO add productType code
    }

}
