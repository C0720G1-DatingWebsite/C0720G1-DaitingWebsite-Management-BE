package c0720g1be.service.impl;

import c0720g1be.entity.Post;
import c0720g1be.repository.CreatePostRepository;
import c0720g1be.service.ICreatePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CreatePostServiceImpl implements ICreatePostService {
    @Autowired
    CreatePostRepository createPostRepository;


    /**
     * Võ Thành Tín: Create New Post
     */
    @Override
    public Boolean createPost(String content, Integer accountId, Integer policyId, String image) {
        try {
            createPostRepository.createPost(content, LocalDateTime.now().toString(), accountId, policyId, image);
        } catch (Exception e){
            return false;
        }
        return true;
    }
}

