package c0720g1be.service;

import c0720g1be.dto.CreatePostDTO;
import c0720g1be.entity.Post;

public interface ICreatePostService {
    /**
     * Võ Thành Tín: Create New Post
     */
    Boolean createPost(String content, Integer accountId, Integer policyId, String image);

    Boolean createPostGroup(CreatePostDTO createPostDTO);
}

