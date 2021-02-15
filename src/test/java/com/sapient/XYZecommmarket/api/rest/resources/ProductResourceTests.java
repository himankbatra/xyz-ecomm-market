package com.sapient.XYZecommmarket.api.rest.resources;

import com.sapient.XYZecommmarket.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext
public class ProductResourceTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testGetProductBySkuApi() throws Exception {

        mockMvc.perform(get("/products/2")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id", is(2)))
                .andExpect(jsonPath("$.name", is("Nike Cap-1")))
                .andExpect(jsonPath("$.brand.name", is("Nike")))
                .andExpect(jsonPath("$.type.name", is("Cap")))
                .andExpect(jsonPath("$.supplier.name", is("AniruddhaRetail")))
                .andExpect(jsonPath("$.price", is(200.25)))
                .andExpect(jsonPath("$.size", is(36)))
                .andExpect(jsonPath("$.color", is("Yellow")));
    }


    @Test
    public void testGetAllProducts() throws Exception {
        mockMvc.perform(get("/products").param("page","0")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.numberOfElements", is(4)));
    }


    @Test
    public void testGetAllProductsByBrand() throws Exception {
        mockMvc.perform(get("/products/brand/Nike").param("page","0")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.numberOfElements", is(1)));
    }

    //TODO other similar integration tests of the exposed apis
}
