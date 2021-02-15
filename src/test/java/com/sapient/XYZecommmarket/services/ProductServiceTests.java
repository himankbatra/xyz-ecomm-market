package com.sapient.XYZecommmarket.services;

import com.sapient.XYZecommmarket.domain.Brand;
import com.sapient.XYZecommmarket.domain.Product;
import com.sapient.XYZecommmarket.domain.ProductType;
import com.sapient.XYZecommmarket.domain.Supplier;
import com.sapient.XYZecommmarket.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ProductServiceTests {

    //for checking products catalogue in DB

    //for mocking dao
    @Mock
    ProductRepository dataServiceMock;

    @InjectMocks
    ProductService productService;

    private static List<Product> prodList;

    @BeforeAll
    private static void setupTestData() {
        prodList = new ArrayList<>();
        Product prod1 = new Product();
        prod1.setId(1L);
        prod1.setName("Avengers T-shirt");
        prod1.setBrand(new Brand(1L, "brand1"));
        prod1.setType(new ProductType(1L, "shirt"));
        prod1.setPrice(200.50);
        prod1.setColor("blue");
        prod1.setSize(42);
        prod1.setAvailableCount(500);
        prod1.setSupplier(new Supplier(1L, "Marvel"));

        Product prod2 = new Product();
        prod2.setId(2L);
        prod2.setName("Justice League T-shirt");
        prod2.setBrand(new Brand(2L, "brand2"));
        prod2.setType(new ProductType(2L, "shirt2"));
        prod2.setPrice(240.50);
        prod2.setColor("white");
        prod2.setSize(40);
        prod2.setAvailableCount(900);
        prod2.setSupplier(new Supplier(2L, "DC"));

        prodList.add(prod1);
        prodList.add(prod2);
    }

    /**
     * DB data test
     */
    @Test
    public void testProductsListNotEmpty() {
        when(dataServiceMock.findAll(any(PageRequest.class))).thenReturn(new PageImpl<>(prodList));
        Page<Product> allProducts = productService.getAllProducts(1);
        assertTrue(allProducts.hasContent());
    }


    /**
     * business layer test with mock DB data
     */
    @Test
    public void testGetAllProductsMock() {
        when(dataServiceMock.findAll(any(PageRequest.class))).thenReturn(new PageImpl<>(prodList));
        assertEquals(2, productService.getAllProducts(1).getTotalElements());
    }

    /**
     * business layer test with mock DB data
     */
    @Test
    public void testGetProductsByBrand() {
        List<Product> prodListForBrand = new ArrayList<Product>();
        Product prod1 = new Product();
        prod1.setId(3L);
        prod1.setName("Black Cap");
        prod1.setBrand(new Brand(3L, "Nike"));
        prod1.setType(new ProductType(3L, "cap"));
        prod1.setPrice(500.0);
        prod1.setColor("black");
        prod1.setSize(16);
        prod1.setAvailableCount(600);
        prod1.setSupplier(new Supplier(3L, "AbcRetail"));
        prodListForBrand.add(prod1);
        when(dataServiceMock.findAllByBrandName(anyString(), any(PageRequest.class))).thenReturn(new PageImpl<>(prodListForBrand));
        assertTrue(productService.getProductsByBrand("Nike", 1).hasContent());
        assertEquals(1, productService.getProductsByBrand("Nike", 1).getTotalElements());
        assertEquals("Black Cap", productService.getProductsByBrand("Nike", 1).getContent().get(0).getName());
    }

    /**
     * business layer test with mock DB data
     */
    @Test
    public void testGetProductBySku() {
        Product prod1 = new Product();
        prod1.setId(4L);
        prod1.setName("Nike shoe");
        prod1.setBrand(new Brand(4L, "Nike"));
        prod1.setType(new ProductType(4L, "shoe"));
        prod1.setPrice(655.0);
        prod1.setColor("black");
        prod1.setSize(16);
        prod1.setAvailableCount(600);
        prod1.setSupplier(new Supplier(4L, "ABB retail"));
        when(dataServiceMock.findById(4L)).thenReturn(Optional.of(prod1));
        assertTrue(productService.getProductBySKU(4L).isPresent());
        assertEquals("Nike shoe", productService.getProductBySKU(4L).get().getName());
        assertEquals("Nike", productService.getProductBySKU(4L).get().getBrand().getName());
        assertEquals("shoe", productService.getProductBySKU(4L).get().getType().getName());
        assertEquals("655.0", String.valueOf(productService.getProductBySKU(4L).get().getPrice()));
    }


    @Test
    public void testGetProductsByTypeAndColor() {
        //TODO similar logic as above
    }

    //TODO other business layer methods tests

}
