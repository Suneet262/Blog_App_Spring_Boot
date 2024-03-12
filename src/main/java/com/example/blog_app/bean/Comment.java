package com.example.blog_app.bean;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="comments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Comment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String comment;

    @ManyToOne
    @JoinColumn(name = "post_Id")
    private Post post;
}
