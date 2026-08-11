package com.example.instagram.service;

import com.example.instagram.entity.Like;
import com.example.instagram.entity.Post;
import com.example.instagram.entity.User;
import com.example.instagram.repository.LikeRepository;
import com.example.instagram.repository.PostRepository;
import com.example.instagram.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public LikeService(
            LikeRepository likeRepository,
            UserRepository userRepository,
            PostRepository postRepository) {

        this.likeRepository = likeRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public String likePost(Long userId, Long postId) {

        if (likeRepository.existsByUserIdAndPostId(userId, postId)) {
            return "Already liked";
        }

        User user = userRepository.findById(userId).orElse(null);
        Post post = postRepository.findById(postId).orElse(null);

        if (user == null || post == null) {
            return "User or Post not found";
        }

        Like like = new Like();

        like.setUser(user);
        like.setPost(post);

        likeRepository.save(like);

        return "Post liked";
    }

    public String unlikePost(Long userId, Long postId) {

        likeRepository.deleteByUserIdAndPostId(userId, postId);

        return "Post unliked";
    }

    public int getLikeCount(Long postId) {

        return likeRepository.findByPostId(postId).size();
    }
}