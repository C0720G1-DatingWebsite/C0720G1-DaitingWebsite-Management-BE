package c0720g1be.service;

import c0720g1be.entity.Post;

import java.util.List;

/**
 */
public interface PostService {
    List<Post> getAllPost(Integer idAccount);
    void editPost(Post post);
    void increaseLike(int id);
    void reductionLike(int id);
    Post findById(int id);
    List<Post> findPostOneAccount(int idAccount);
}
