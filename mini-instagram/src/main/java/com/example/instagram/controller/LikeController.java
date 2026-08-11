package com.example.instagram.controller;

import com.example.instagram.service.LikeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes")
@CrossOrigin
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/{userId}/{postId}")
    public String likePost(
            @PathVariable Long userId,
            @PathVariable Long postId) {

        return likeService.likePost(userId, postId);
    }

    @DeleteMapping("/{userId}/{postId}")
    public String unlikePost(
            @PathVariable Long userId,
            @PathVariable Long postId) {

        return likeService.unlikePost(userId, postId);
    }

    @GetMapping("/count/{postId}")
    public int getLikeCount(@PathVariable Long postId) {

        return likeService.getLikeCount(postId);
    }
}