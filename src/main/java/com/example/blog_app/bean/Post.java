package com.example.blog_app.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="posts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String title;

    @Column
    String description;

    @JsonIgnore
    @OneToMany(mappedBy = "post")
    List<Comment> comments = new ArrayList<>();
}
