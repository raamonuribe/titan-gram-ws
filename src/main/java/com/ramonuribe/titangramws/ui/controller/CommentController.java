package com.ramonuribe.titangramws.ui.controller;

import com.ramonuribe.titangramws.service.CommentService;
import com.ramonuribe.titangramws.shared.dto.CommentDto;
import com.ramonuribe.titangramws.ui.model.request.CommentDetailsRequestModel;
import com.ramonuribe.titangramws.ui.model.response.CommentRest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users/{userId}/posts/{postId}/comments")
public class CommentController {

    private final ModelMapper modelMapper;
    private final CommentService commentService;

    @Autowired
    public CommentController(ModelMapper modelMapper, CommentService commentService) {
        this.modelMapper = modelMapper;
        this.commentService = commentService;
    }

    @PostMapping
    public CommentRest createComment(@PathVariable String userId, @PathVariable String postId,
                                     @RequestBody CommentDetailsRequestModel commentDetails) {
        CommentDto commentDto = modelMapper.map(commentDetails, CommentDto.class);
        CommentDto createdComment = commentService.createComment(userId, postId, commentDto);

        CommentRest returnValue = modelMapper.map(createdComment, CommentRest.class);

        return returnValue;
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable String userId, @PathVariable String postId,
                              @PathVariable String commentId) {
        return;
    }
}
