package com.ramonuribe.titangramws.service;

import com.ramonuribe.titangramws.shared.dto.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto, String userId);
    List<PostDto> getPosts();
    void deletePost(String userId, String postId);
    PostDto getByPostId(String userId, String postId);
}
