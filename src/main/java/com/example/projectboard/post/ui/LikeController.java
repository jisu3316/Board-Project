package com.example.projectboard.post.ui;

import com.example.projectboard.member.application.dto.MemberDto;
import com.example.projectboard.post.appllication.LikeService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/likes")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/{postId}")
    public void like(
            @PathVariable Long postId,
            @AuthenticationPrincipal MemberDto memberDto
    ) {
        likeService.increase(postId, memberDto);
    }
}