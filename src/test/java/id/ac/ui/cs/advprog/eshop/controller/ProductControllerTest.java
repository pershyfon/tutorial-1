package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    private ProductService productService;

    @Mock
    private Model model;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testCreateProductPage() {
        String expectedViewName = "createProduct";
        String actualViewName = productController.createProductPage(model);
        assertEquals(expectedViewName, actualViewName);
    }

    @Test
    void testCreateProductPost() {
        Product product = new Product();
        String expectedViewName = "redirect:list";
        String actualViewName = productController.createProductPost(product, model);
        assertEquals(expectedViewName, actualViewName);
    }

    @Test
    void testProductListPage() {
        List<Product> productList = new ArrayList<>();
        when(productService.findAll()).thenReturn(productList);

        String expectedViewName = "productList";
        String actualViewName = productController.productListPage(model);
        assertEquals(expectedViewName, actualViewName);
    }

    @Test
    void testDeleteProduct() {
        Product product = new Product();
        String productId = product.getProductId();
        String expectedViewName = "redirect:../list";
        String actualViewName = productController.deleteProduct(productId, model);
        assertEquals(expectedViewName, actualViewName);
    }

    @Test
    void testEditProductPage() {
        Product product = new Product();
        String productId = product.getProductId();
        when(productService.findById(productId)).thenReturn(product);

        String expectedViewName = "EditProduct";
        String actualViewName = productController.editProductPage(productId, model);
        assertEquals(expectedViewName, actualViewName);
    }

    @Test
    void testEditProductList() {
        Product product = new Product();
        String productId = product.getProductId();
        String expectedViewName = "redirect:../list";
        String actualViewName = productController.editProductList(productId, product, model);
        assertEquals(expectedViewName, actualViewName);
    }
}