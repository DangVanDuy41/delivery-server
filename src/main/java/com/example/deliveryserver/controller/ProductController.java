package com.example.deliveryserver.controller;

import com.example.deliveryserver.dto.ApiResponse;
import com.example.deliveryserver.dto.ProductDTO;
import com.example.deliveryserver.entity.Product;
import com.example.deliveryserver.mapper.ProductMapper;
import com.example.deliveryserver.service.product.ProductService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/products")
public class ProductController {


    private static final Log log = LogFactory.getLog(ProductController.class);
    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/admin")
    public ApiResponse<Boolean> saveProduct(@RequestBody ProductDTO productRequest){

        Product product = ProductMapper.productDTOToProduct(productRequest);
        Boolean result = productService.createProduct(product,productRequest.getPrice()) != null ;

        return ApiResponse.<Boolean>builder()
                .time(new Date())
                .data(result)
                .message("Thêm sản phẩm thành công")
                .build();
    }

    @GetMapping("/admin/getListProductByStore")
    public ApiResponse<List<ProductDTO>> getListProductByStore(){

        return  ApiResponse.<List<ProductDTO>>builder()
                .data(productService.getListByStore())
                .message("Success")
                .time(new Date())
                .build();
    }

    @GetMapping("/public/getListProductByCategory/{id}")
    public ApiResponse<List<ProductDTO>> getListProductByCategory(@PathVariable UUID id){
        return  ApiResponse.<List<ProductDTO>>builder()
                .data(productService.getListProductByCategory(id))
                .time(new Date())
                .message("Success")
                .build();
    }
}
