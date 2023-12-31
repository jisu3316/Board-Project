package com.example.projectboard.post;

import com.example.projectboard.BaseEntity;
import com.example.projectboard.member.Member;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "likes")
@EntityListeners(AuditingEntityListener.class)
public class Like extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    protected Like() {}

    public Like(Member member, Post post) {
        this.member = member;
        this.post = post;
    }

    public boolean isSameMember(Member member) {
        return this.member.equals(member);
    }

    public boolean isSamePost(Post post) {
        return this.post.equals(post);
    }

    public Long getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }

    public Post getPost() {
        return post;
    }

    public static LikeBuilder builder() {
        return new LikeBuilder();
    }

    public static class LikeBuilder {
        private Member member;
        private Post post;

        public LikeBuilder() {}

        public LikeBuilder member(Member member) {
            this.member = member;
            return this;
        }

        public LikeBuilder post(Post post) {
            this.post = post;
            return this;
        }

        public Like build() {
            return new Like(member, post);
        }
    }
}
