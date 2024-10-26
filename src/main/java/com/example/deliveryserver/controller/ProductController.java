package com.example.deliveryserver.controller;

import com.example.deliveryserver.dto.ApiResponse;
import com.example.deliveryserver.dto.ProductDTO;
import com.example.deliveryserver.dto.ProductStoreDTO;
import com.example.deliveryserver.entity.Product;
import com.example.deliveryserver.enums.Status;
import com.example.deliveryserver.mapper.ProductMapper;
import com.example.deliveryserver.service.product.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/admin")
    public ApiResponse<Boolean> saveProduct(@RequestBody ProductDTO productRequest) {

        Product product = ProductMapper.productDTOToProduct(productRequest);
        Boolean result = productService.createProduct(product, productRequest.getPrice()) != null;

        return ApiResponse.<Boolean>builder()
                .time(new Date())
                .data(result)
                .message("Thêm sản phẩm thành công")
                .build();
    }

    @GetMapping("/admin/get-list-product-by-store")
    public ApiResponse<List<ProductDTO>> getListProductByStore() {

        return ApiResponse.<List<ProductDTO>>builder()
                .data(productService.getListByStore())
                .message(String.valueOf(Status.SUCCESS))
                .time(new Date())
                .build();
    }

    @GetMapping("/public/get-list-product-by-category/{id}")
    public ApiResponse<List<ProductDTO>> getListProductByCategory(@PathVariable UUID id) {
        return ApiResponse.<List<ProductDTO>>builder()
                .data(productService.getListProductByCategory(id))
                .time(new Date())
                .message(String.valueOf(Status.SUCCESS))
                .build();
    }

    @GetMapping("/admin/get-product-by-id/{id}")
    public ApiResponse<ProductStoreDTO> getProductById(@PathVariable UUID id) {
        return ApiResponse.<ProductStoreDTO>builder()
                .data(productService.getProductById(id))
                .message(String.valueOf(Status.SUCCESS))
                .time(new Date())
                .build();
    }

    @DeleteMapping("/admin/delete-product-by-id/{id}")
    public ApiResponse<Boolean> deleteProductById(@PathVariable UUID id) {
        this.productService.deleteById(id);
        return ApiResponse.<Boolean>builder()
                .data(true)
                .message(String.valueOf(Status.SUCCESS))
                .time(new Date())
                .build();
    }
}
