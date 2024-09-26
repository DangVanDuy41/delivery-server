package com.example.deliveryserver.service.product;

import com.example.deliveryserver.dto.ProductDTO;
import com.example.deliveryserver.entity.Product;
import com.example.deliveryserver.entity.StoreProducts;
import com.example.deliveryserver.entity.User;
import com.example.deliveryserver.repository.ProductRepository;
import com.example.deliveryserver.repository.StoreProductRepository;
import com.example.deliveryserver.repository.UserRepository;
import com.example.deliveryserver.service.BaseService;
import com.example.deliveryserver.utils.UserInfo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
public class ProductServiceImpl extends BaseService<Product, ProductRepository> implements ProductService {

    private final   StoreProductRepository storeProductRepository;

    private final UserRepository userRepository;

    public ProductServiceImpl(ProductRepository repo, StoreProductRepository storeProductRepository, UserRepository userRepository) {
        super(repo);
        this.storeProductRepository = storeProductRepository;
        this.userRepository = userRepository;

    }


    @Transactional
    public Product createProduct(Product entity,Double price) {

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
        return this.repo.getListProductByCategory(user,id);
    }


}
