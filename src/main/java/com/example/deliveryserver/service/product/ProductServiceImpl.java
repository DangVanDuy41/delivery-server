package com.example.deliveryserver.service.product;

import com.example.deliveryserver.dto.ProductDTO;
import com.example.deliveryserver.dto.ProductStoreDTO;
import com.example.deliveryserver.dto.ReviewDTO;
import com.example.deliveryserver.entity.Product;
import com.example.deliveryserver.entity.Review;
import com.example.deliveryserver.entity.StoreProducts;
import com.example.deliveryserver.entity.User;
import com.example.deliveryserver.mapper.Mapper;
import com.example.deliveryserver.repository.ProductRepository;
import com.example.deliveryserver.repository.ReviewRepository;
import com.example.deliveryserver.repository.StoreProductRepository;
import com.example.deliveryserver.repository.UserRepository;
import com.example.deliveryserver.service.BaseService;
import com.example.deliveryserver.service.review.ReviewService;
import com.example.deliveryserver.utils.UserInfo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
public class ProductServiceImpl extends BaseService<Product, ProductRepository> implements ProductService {

    private final StoreProductRepository storeProductRepository;

    private final UserRepository userRepository;

    private final ReviewService reviewService;
    public ProductServiceImpl(ProductRepository repo, StoreProductRepository storeProductRepository, UserRepository userRepository,ReviewService reviewService) {
        super(repo);
        this.storeProductRepository = storeProductRepository;
        this.userRepository = userRepository;
        this.reviewService = reviewService;
    }

    @Transactional
    public Product createProduct(Product entity, Double price) {

        Product product = this.repo.save(entity);

        User user = userRepository.findByEmail(UserInfo.getUsername()).orElseThrow();

        StoreProducts storeProduct = StoreProducts.builder()
                .productId(product.getId())
                .storeId(user.getStore().getId())
                .price(price)
                .rating(0.0)
                .createdAt(new Date())
                .build();
        storeProductRepository.save(storeProduct);
        return super.saveOrUpdate(entity);
    }

    @Override
    public List<ProductDTO> getListByStore() {
        User user = userRepository.findByEmail(UserInfo.getUsername()).orElseThrow();
        return this.repo.getAllByStore(user);
    }

    @Override
    public List<ProductDTO> getListProductByCategory(UUID id) {
        User user = userRepository.findByEmail(UserInfo.getUsername()).orElseThrow();
        return this.repo.getListProductByCategory(user, id);
    }

    @Override
    public ProductStoreDTO getProductById(UUID id) {
        ProductStoreDTO productStoreDTO = this.repo.getProductById(id);
        List<ReviewDTO> reviewDTOS = this.reviewService.findByStoreIdAndProductId(productStoreDTO.getStore().getId(),productStoreDTO.getId());
        productStoreDTO.setReviews(reviewDTOS);
        return productStoreDTO;
    }

    @Override
    public void deleteById(UUID id) {
        User user = userRepository.findByEmail(UserInfo.getUsername()).orElseThrow();
        StoreProducts storeProducts = storeProductRepository.findAll().stream()
                .filter(sp ->
                        sp.getProductId().equals(id) && sp.getStoreId().equals(user.getStore().getId())
                ).findFirst().orElseThrow();

        storeProductRepository.deleteById(storeProducts.getId());
    }
}
