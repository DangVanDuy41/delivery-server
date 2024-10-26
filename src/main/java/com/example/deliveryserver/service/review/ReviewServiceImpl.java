package com.example.deliveryserver.service.review;



import com.example.deliveryserver.dto.ReviewDTO;
import com.example.deliveryserver.entity.Review;
import com.example.deliveryserver.repository.ReviewRepository;
import com.example.deliveryserver.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReviewServiceImpl extends BaseService<Review, ReviewRepository> implements ReviewService {

    public ReviewServiceImpl(ReviewRepository repo) {
        super(repo);
    }

    @Override
    public List<ReviewDTO> findByStoreIdAndProductId(UUID storeId, UUID productId) {
        return repo.findByStoreIdAndProductId(storeId, productId);
    }
}
