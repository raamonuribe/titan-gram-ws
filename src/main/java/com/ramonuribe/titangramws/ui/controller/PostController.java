package com.ramonuribe.titangramws.ui.controller;

import com.ramonuribe.titangramws.service.PostService;
import com.ramonuribe.titangramws.shared.dto.PostDto;
import com.ramonuribe.titangramws.ui.model.request.PostDetailsRequestModel;
import com.ramonuribe.titangramws.ui.model.response.PostRest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

        return returnValue;
    }

    @GetMapping
    public List<PostRest> getPosts() {
        List<PostDto> posts = postService.getPosts();

        List<PostRest> returnValue = posts.stream().map(temp -> {
            return modelMapper.map(temp, PostRest.class);
        }).collect(Collectors.toList());

        return returnValue;
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable String userId, @PathVariable String postId) {
        postService.deletePost(userId, postId);
    }

    @GetMapping("/{postId}")
    public PostRest getByPostId(@PathVariable String userId, @PathVariable String postId) {
        PostDto postDto = postService.getByPostId(userId, postId);

        PostRest returnValue = modelMapper.map(postDto, PostRest.class);

        return returnValue;
    }
}
