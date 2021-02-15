package com.sapient.XYZecommmarket.services;

import com.sapient.XYZecommmarket.cache.ProductCache;
import com.sapient.XYZecommmarket.domain.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {

    @Autowired
    private ProductCache productCache;

    public void addBrand(Brand brand) {
        //refresh products by brand cache
        productCache.evictSingleCacheValue("products", "brandName");
        //TODO add brand code
    }


}
