package com.example.controler;

import com.example.dto.APIResponse;
import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/get")
    private APIResponse<List<Product>> getProducts() {
        List<Product> allProducts = productService.findAllProducts();
        return new APIResponse<>(allProducts.size(), allProducts);
    }

    @GetMapping("/{field}")
    private APIResponse<List<Product>> getProductsWithSort(@PathVariable String field) {
        List<Product> allProducts = productService.findProductsWithSorting(field);
        return new APIResponse<>(allProducts.size(), allProducts);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    private APIResponse<Page<Product>> getProductsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        Page<Product> productsWithPagination = (Page<Product>) productService.findProductsWithPagination(offset, pageSize);
        return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
    }

    @GetMapping("/paginationAndSort")
    private APIResponse<Page<Product>> getProductsWithPaginationAndSort(@RequestParam("offset") int offset, @RequestParam("pagesize") int pageSize) {
        String field = "id";
        Page<Product> productsWithPagination = (Page<Product>) productService.findProductsWithPaginationAndSorting(offset, pageSize, field);
        return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
    }

}
