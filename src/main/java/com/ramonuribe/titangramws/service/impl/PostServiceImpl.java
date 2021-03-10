package com.ramonuribe.titangramws.service.impl;

import com.ramonuribe.titangramws.io.entity.PostEntity;
import com.ramonuribe.titangramws.io.entity.UserEntity;
import com.ramonuribe.titangramws.io.repository.PostRepository;
import com.ramonuribe.titangramws.io.repository.UserRepository;
import com.ramonuribe.titangramws.service.PostService;
import com.ramonuribe.titangramws.shared.dto.PostDto;
import com.ramonuribe.titangramws.shared.dto.UserDto;
import com.ramonuribe.titangramws.shared.utils.IdGeneratorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final ModelMapper modelMapper;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final IdGeneratorUtil idGenerator;

    @Autowired
    public PostServiceImpl(ModelMapper modelMapper, PostRepository postRepository, UserRepository userRepository, IdGeneratorUtil idGenerator) {
        this.modelMapper = modelMapper;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.idGenerator = idGenerator;
    }

    @Override
    public PostDto createPost(PostDto postDto, String userId) {
        UserEntity userEntity = userRepository.findByUserId(userId);
        if (userEntity == null) throw new RuntimeException("User not found.");

        UserDto userDto = modelMapper.map(userEntity, UserDto.class);
        postDto.setUserDetails(userDto);
        postDto.setPostId(idGenerator.generateAlphaNumericId(30));

        PostEntity postEntity = modelMapper.map(postDto, PostEntity.class);
        PostEntity createdPost = postRepository.save(postEntity);

        PostDto returnValue = modelMapper.map(createdPost, PostDto.class);

        return returnValue;
    }

    @Override
    public List<PostDto> getPosts() {
        List<PostEntity> posts = postRepository.findAll();

        List<PostDto> returnValue = posts.stream().map(temp -> {
            return modelMapper.map(temp, PostDto.class);
        }).collect(Collectors.toList());

        return returnValue;
    }

    @Override
    public void deletePost(String userId, String postId) {
        UserEntity userEntity = userRepository.findByUserId(userId);
        if (userEntity == null) throw new RuntimeException("User not found.");
        PostEntity postEntity = postRepository.findByPostId(postId);
        if (postEntity == null) throw new RuntimeException("Post not found.");

        postRepository.delete(postEntity);
    }

    @Override
    public PostDto getByPostId(String userId, String postId) {
        UserEntity userEntity = userRepository.findByUserId(userId);
        if (userEntity == null) throw new RuntimeException("User not found.");
        PostEntity postEntity = postRepository.findByPostId(postId);
        if (postEntity == null) throw new RuntimeException("Post not found.");

        PostDto returnValue = modelMapper.map(postEntity, PostDto.class);

        return returnValue;
    }
}
