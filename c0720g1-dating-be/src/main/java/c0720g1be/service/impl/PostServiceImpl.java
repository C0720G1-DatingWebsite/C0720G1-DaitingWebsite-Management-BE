package c0720g1be.service.impl;

import c0720g1be.entity.Post;
import c0720g1be.repository.PostRepository;
import c0720g1be.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository postRepository;
    @Override
    public List<Post> getAllPost(Integer idAccount) {
        return postRepository.findAllPost(idAccount);
    }

    @Override
    public void editPost(Post post) {
        postRepository.save(post);
    }

    @Override
    public void increaseLike(int id) {
        postRepository.increaseLike(id);
    }

    @Override
    public void reductionLike(int id) {
        postRepository.reductionLike(id);
    }

    @Override
    public Post findById(int id) {
        return postRepository.getByIdPost(id);
    }

    @Override
    public List<Post> findPostOneAccount(int idAccount) {
        return postRepository.findByAccount(idAccount);
    }
}
