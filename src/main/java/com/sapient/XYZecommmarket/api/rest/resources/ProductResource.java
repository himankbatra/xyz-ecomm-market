package com.sapient.XYZecommmarket.api.rest.resources;

import com.sapient.XYZecommmarket.domain.Product;
import com.sapient.XYZecommmarket.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class ProductResource {

    @Autowired
    private ProductService productService;

    /**
     * Api for fetching all products with details
     *
     * @return List of products
     */
    @GetMapping(params = "page")
    public ResponseEntity<Page<Product>> getAllProducts(@RequestParam(value = "page") int page) {
        return ResponseEntity.ok(productService.getAllProducts(page));
    }

    /**
     * Api for fetching products details by brand
     *
     * @return List of products
     */
    @GetMapping(value = "/brand/{brand}",params = "page")
    public ResponseEntity<Page<Product>> getProductsByBrand(@PathVariable("brand") String brand, @RequestParam(value = "page") int page) {
        return ResponseEntity.ok(productService.getProductsByBrand(brand, page));
    }

    /**
     * Api for fetching products details by price range
     *
     * @return List of products
     */
    @GetMapping(params = {"min_price","max_price","page"})
    public ResponseEntity<Page<Product>> getProductsByPriceRange(@RequestParam("min_price") Double minPrice, @RequestParam("max_price") Double maxPrice, @RequestParam(value = "page") int page) {
        return ResponseEntity.ok(productService.getProductsByPriceRange(minPrice, maxPrice, page));
    }

    /**
     * Api for fetching product details by SKU
     *
     * @return List of products
     */
    @GetMapping(value = "/{sku}")
    public ResponseEntity<Product> getProductBySKU(@PathVariable("sku") Long productId) {
        return productService.getProductBySKU(productId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Api for fetching product count by seller
     *
     * @return List of products
     */
    @GetMapping(value = "/seller/{sellerId}")
    public ResponseEntity<Integer> getProductCountBySeller(@PathVariable("sellerId") Long sellerId) {
        return ResponseEntity.ok(productService.getProductCountBySeller(sellerId));
    }

    /**
     * Api for fetching products details by type and size
     *
     * @return List of products
     */
    @GetMapping(value = "/type/{type}",params = {"size","page"})
    public ResponseEntity<Page<Product>> getProductsByTypeAndSize(@PathVariable("type") Long productType, @RequestParam("size") Integer size, @RequestParam(value = "page") int page) {
        return ResponseEntity.ok(productService.getProductsByTypeAndSize(productType, size, page));
    }

    /**
     * Api for fetching products details by type and color
     *
     * @return List of products
     */
    @GetMapping(value = "/type/{type}",params = {"color","page"})
    public ResponseEntity<Page<Product>> getProductsByTypeAndColor(@PathVariable("type") Long productType, @RequestParam("color") String color, @RequestParam(value = "page") int page) {
        return ResponseEntity.ok(productService.getProductsByTypeAndColor(productType, color, page));
    }

    //TODO other related apis to be exposed as per needs

}
