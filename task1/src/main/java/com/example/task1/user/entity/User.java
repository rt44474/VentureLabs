package com.example.task1.user.entity;

import com.example.task1.blog.entity.Blog;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @NonNull
    private String username;

    @NonNull
    private String password;

    @NonNull
    private String permission;

    @NonNull
    private String readonly;

    @OneToMany(mappedBy = "user")
    private List<Blog> blogs;
}
