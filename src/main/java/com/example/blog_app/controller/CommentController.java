package com.example.blog_app.controller;

import com.example.blog_app.bean.Comment;
import com.example.blog_app.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/post/{Id}/addComment")
    public ResponseEntity<String> addComment(@RequestBody Comment comment,@PathVariable Long Id){
        Comment response  = commentService.addComment(comment, Id);

        return new ResponseEntity<>("Comment created successfully for Id ->" + response.getId(), HttpStatus.CREATED);
    }

    @GetMapping("/comment/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long id){
        Comment comment  = commentService.getCommentById(id);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @GetMapping("/post/{Id}/getComments")
    public List<Comment> getCommentByPostId(@PathVariable Long Id){
        return commentService.getCommentByPostId(Id);
    }

    @PutMapping("/post/{Id}/comment/{id}")
    public  ResponseEntity<String> updateCommentById(@PathVariable Long Id, @PathVariable Long id, @RequestBody Comment comment){
        commentService.updateCommentById(id, Id, comment);
        return new ResponseEntity<>("Comment Updated Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/deleteComment/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable Long id){
        commentService.deleteCommentById(id);
        return new ResponseEntity<>("Comment deleted successfully", HttpStatus.OK);
    }
}
