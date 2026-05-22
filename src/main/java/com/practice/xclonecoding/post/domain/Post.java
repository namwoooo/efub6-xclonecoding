package com.practice.xclonecoding.post.domain;

import com.practice.xclonecoding.account.domain.Account;
import com.practice.xclonecoding.global.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer", nullable = false)
    private Account writer;

    @Column(nullable = false)
    private String content;

    @Column
    private String image;

    @Builder
    public Post (Account writer, String content, String image) {
        this.writer = writer;
        this.content = content;
        this.image = image;
    }
}
