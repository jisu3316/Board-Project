package com.example.projectboard.post.appllication.dto.v1.response;

import com.example.projectboard.member.application.dto.v1.response.MemberResponse;
import com.example.projectboard.post.appllication.dto.PostDto;

import java.util.List;

public record PostResponse(Long id, MemberResponse memberResponse, String title, String content, int likeCount) {

    public static PostResponse from(PostDto postDto) {
        return new PostResponse(postDto.id(), MemberResponse.from(postDto.memberDto()), postDto.title(), postDto.content(), postDto.likeCount());
    }

}
