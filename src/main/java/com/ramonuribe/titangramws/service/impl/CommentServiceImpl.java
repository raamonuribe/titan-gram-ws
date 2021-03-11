package com.ramonuribe.titangramws.service.impl;

import com.ramonuribe.titangramws.io.entity.CommentEntity;
import com.ramonuribe.titangramws.io.entity.PostEntity;
import com.ramonuribe.titangramws.io.entity.UserEntity;
import com.ramonuribe.titangramws.io.repository.CommentRepository;
import com.ramonuribe.titangramws.io.repository.PostRepository;
import com.ramonuribe.titangramws.io.repository.UserRepository;
import com.ramonuribe.titangramws.service.CommentService;
import com.ramonuribe.titangramws.shared.dto.CommentDto;
import com.ramonuribe.titangramws.shared.dto.PostDto;
import com.ramonuribe.titangramws.shared.dto.UserDto;
import com.ramonuribe.titangramws.shared.utils.IdGeneratorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final IdGeneratorUtil idGenerator;
    private final ModelMapper modelMapper;

    @Autowired
    public CommentServiceImpl(UserRepository userRepository, PostRepository postRepository, CommentRepository commentRepository, IdGeneratorUtil idGenerator, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.idGenerator = idGenerator;
        this.modelMapper = modelMapper;
    }


    @Override
    public CommentDto createComment(String userId, String postId, CommentDto commentDto) {
        UserEntity userEntity = userRepository.findByUserId(userId);
        if (userEntity == null) throw new RuntimeException("User not found.");
        PostEntity postEntity = postRepository.findByPostId(postId);
        if (postEntity == null) throw new RuntimeException("Post not found.");

        UserDto userDto = modelMapper.map(userEntity, UserDto.class);
        PostDto postDto = modelMapper.map(postEntity, PostDto.class);

        commentDto.setCommentId(idGenerator.generateAlphaNumericId(30));
        commentDto.setUserDetails(userDto);
        commentDto.setPostDetails(postDto);

        CommentEntity commentEntity = modelMapper.map(commentDto, CommentEntity.class);
        CommentEntity createdComment = commentRepository.save(commentEntity);

        CommentDto returnValue = modelMapper.map(createdComment, CommentDto.class);

        return returnValue;
    }

    @Override
    public void deleteComment(String userId, String postId, String commentId) {
        UserEntity userEntity = userRepository.findByUserId(userId);
        if (userEntity == null) throw new RuntimeException("User not found.");
        PostEntity postEntity = postRepository.findByPostId(postId);
        if (postEntity == null) throw new RuntimeException("Post not found.");
        CommentEntity commentEntity = commentRepository.findByCommentId(commentId);
        if (commentEntity == null) throw new RuntimeException("Comment not found");

        commentRepository.delete(commentEntity);
    }
}
