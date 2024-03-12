package com.example.blog_app.controller;

import com.example.blog_app.bean.Post;
import com.example.blog_app.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/createPost")
    public ResponseEntity<String> createPost(@RequestBody Post post){
        Post response = postService.createPost(post);

        return new ResponseEntity<>("Post Created Successfully, Id -> " + response.getId(), HttpStatus.CREATED);
    }

    @GetMapping("/getPost/{Id}")
    public ResponseEntity<Post> getpostById(@PathVariable Long Id){
        Post response = postService.getPostById(Id);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/getPosts")
    public List<Post> getAllPost(){
        return postService.getAllPost();
    }

    @PutMapping("/updatePost/{Id}")
    public ResponseEntity<String> updatePost(@RequestBody Post post, @PathVariable Long Id){
        postService.updatePostById(post,Id);
        return new ResponseEntity<>("Post Updated Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/deletePost/{Id}")
    public ResponseEntity<String> deletePost(@PathVariable Long Id){
        postService.deletePostById(Id);
        return new ResponseEntity<>("Post deleted successfully", HttpStatus.OK);
    }

}
