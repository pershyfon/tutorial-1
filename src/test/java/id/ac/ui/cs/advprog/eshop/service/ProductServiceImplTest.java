package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testCreateProduct() {
        Product product = new Product();
        when(productRepository.create(product)).thenReturn(product);

        Product createdProduct = productService.create(product);
        assertEquals(product, createdProduct);
    }

    @Test
    void testFindAllProducts() {
        Product product = new Product();
        when(productRepository.create(product)).thenReturn(product);
        productService.create(product);

        when(productRepository.findAll()).thenReturn(List.of(product).iterator());
        Iterator<Product> foundProducts = productService.findAll().iterator();

        assertTrue(foundProducts.hasNext());
        Product savedProduct = foundProducts.next();
        assertEquals(product, savedProduct);
    }

    @Test
    void testFindProductById() {
        Product product = new Product();
        String productId = product.getProductId();
        when(productRepository.findById(productId)).thenReturn(product);

        Product foundProduct = productService.findById(productId);
        assertEquals(product, foundProduct);
    }

    @Test
    void testEditProduct() {
        Product product = new Product();
        when(productRepository.edit(product)).thenReturn(product);

        Product editedProduct = productService.editProduct(product);
        assertEquals(product, editedProduct);
    }

    @Test
    void testDeleteProduct() {
        Product product = new Product();
        when(productRepository.delete(product)).thenReturn(product);

        Product deletedProduct = productService.deleteProduct(product);
        assertEquals(product, deletedProduct);
    }
}