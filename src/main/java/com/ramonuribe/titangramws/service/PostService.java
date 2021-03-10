package com.ramonuribe.titangramws.service;

import com.ramonuribe.titangramws.shared.dto.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto, String userId);
}
