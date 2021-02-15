package com.sapient.XYZecommmarket.repositories;

import com.sapient.XYZecommmarket.domain.Product;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Cacheable(value="products")
    Page<Product> findAll(Pageable pageable);

    @Cacheable(value="products", key="#brandName")
    Page<Product> findAllByBrandName(String brandName, Pageable pageable);

    @Cacheable(value="products", key="#maxPrice")
    Page<Product> findAllByPriceBetween(Double minPrice, Double maxPrice, Pageable pageable);

    @Cacheable(value="products", key="#productId")
    Optional<Product> findById(Long productId);

    @Cacheable(value="productCountBySeller", key="#supplierId")
    List<Product> findAllBySupplierId(Long supplierId);

    @Cacheable(value="products", key="#size")
    Page<Product> findAllByTypeIdAndSize(Long productType, Integer size, Pageable pageable);

    @Cacheable(value="products", key="#color")
    Page<Product> findAllByTypeIdAndColor(Long typeId, String color, Pageable pageable);

}
