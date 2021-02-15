package com.sapient.XYZecommmarket.services;

import com.sapient.XYZecommmarket.cache.ProductCache;
import com.sapient.XYZecommmarket.domain.Supplier;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {


    private ProductCache productCache;

    public void addSupplier(Supplier supplier) {
        //refresh products by seller cache
        productCache.evictSingleCacheValue("productCountBySeller","supplierId");
        //TODO add supplier code
    }

}
