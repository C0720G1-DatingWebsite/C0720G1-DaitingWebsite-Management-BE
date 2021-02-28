package c0720g1be.service.impl;

import c0720g1be.entity.Post;
import c0720g1be.repository.CreatePostRepository;
import c0720g1be.service.ICreatePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatePostServiceImpl implements ICreatePostService {
    @Autowired
    CreatePostRepository createPostRepository;


    /**
     * Võ Thành Tín: Create New Post
     */
    @Override
    public Boolean createPost(Post post) {
        try {
            createPostRepository.createPost(post.getContent(), post.getPostTime(), post.getAccount().getId(), post.getPolicy().getId());
        } catch (Exception e){
            return false;
        }
        return true;
    }
}

