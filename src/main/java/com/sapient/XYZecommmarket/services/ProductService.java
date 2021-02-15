package com.sapient.XYZecommmarket.services;

import com.sapient.XYZecommmarket.cache.ProductCache;
import com.sapient.XYZecommmarket.domain.Product;
import com.sapient.XYZecommmarket.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCache productCache;

    public Page<Product> getAllProducts(int page) {
        return productRepository.findAll(PageRequest.of(page,10));
    }

    public Page<Product> getProductsByBrand(String brandName, int page) {
        return productRepository.findAllByBrandName(brandName, PageRequest.of(page,10));
    }

    public Page<Product> getProductsByPriceRange(Double minPrice, Double maxPrice, int page) {
        return productRepository.findAllByPriceBetween(minPrice, maxPrice, PageRequest.of(page,10));
    }

    public Optional<Product> getProductBySKU(Long productId) {
        return productRepository.findById(productId);
    }

    public Integer getProductCountBySeller(Long supplierId) {
        return productRepository.findAllBySupplierId(supplierId).size();
    }

    public Page<Product> getProductsByTypeAndSize(Long productType, Integer size, int page) {
        return productRepository.findAllByTypeIdAndSize(productType, size, PageRequest.of(page,10));
    }

    public Page<Product> getProductsByTypeAndColor(Long typeId, String color,  int page) {
        return productRepository.findAllByTypeIdAndColor(typeId, color, PageRequest.of(page,10));
    }


    public void addProduct(Product product) {
        //refresh all products cache
        productCache.evictAllCacheValues("products");
        //TODO add product code
    }

}
