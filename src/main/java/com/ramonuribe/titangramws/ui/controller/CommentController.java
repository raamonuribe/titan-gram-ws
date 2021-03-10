package com.ramonuribe.titangramws.ui.controller;

import com.ramonuribe.titangramws.ui.model.request.CommentDetailsRequestModel;
import com.ramonuribe.titangramws.ui.model.response.CommentRest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users/{userId}/posts/{postId}/comments")
public class CommentController {

    @PostMapping
    public CommentRest createComment(@PathVariable String userId, @PathVariable String postId,
                                     @RequestBody CommentDetailsRequestModel commentDetails) {
        return null;
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable String userId, @PathVariable String postId,
                              @PathVariable String commentId) {
        return;
    }
}
