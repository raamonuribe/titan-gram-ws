package com.ramonuribe.titangramws.service;

import com.ramonuribe.titangramws.shared.dto.CommentDto;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto);
    void deleteComment(String userId, String postId, String commentId);
}
