package com.ramonuribe.titangramws.ui.controller;

import com.ramonuribe.titangramws.service.PostService;
import com.ramonuribe.titangramws.shared.dto.PostDto;
import com.ramonuribe.titangramws.ui.model.request.PostDetailsRequestModel;
import com.ramonuribe.titangramws.ui.model.response.PostRest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users/{userId}/posts")
public class PostController {

    private final ModelMapper modelMapper;
    private final PostService postService;

    @Autowired
    public PostController(ModelMapper modelMapper, PostService postService) {
        this.modelMapper = modelMapper;
        this.postService = postService;
    }

    @PostMapping
    public PostRest createPost(@RequestBody PostDetailsRequestModel postDetails, @PathVariable String userId) {

        PostDto postDto = modelMapper.map(postDetails, PostDto.class);
        PostDto createdPost = postService.createPost(postDto, userId);

        PostRest returnValue = modelMapper.map(createdPost, PostRest.class);
        returnValue.setUserId(userId);

        return returnValue;
    }
}
