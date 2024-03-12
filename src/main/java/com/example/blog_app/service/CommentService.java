package com.example.blog_app.service;

import com.example.blog_app.bean.Comment;
import com.example.blog_app.bean.Post;
import com.example.blog_app.dao.CommentDAO;
import com.example.blog_app.dao.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    //addComment
    //getCommentByCommentId()
    //getCommentByPostId()
    //updateComment()
    //deleteComment()

    @Autowired
    private PostDAO postDAO;

    @Autowired
    private CommentDAO commentDAO;

    //addComment
    public Comment addComment(Comment comment, Long post_Id){
        Post post = postDAO.findById(post_Id)
                .orElseThrow(() -> new RuntimeException(post_Id + "-> This Post ID doen't exist"));
        comment.setPost(post);
        return commentDAO.save(comment);
    }


    //getCommentByCommentId()

    public Comment getCommentById( Long id){
        return commentDAO.findById(id)
                .orElseThrow(()-> new RuntimeException(id + "-> This Id doesnt exist"));
    }


    //getCommentByPostId()
    public List<Comment> getCommentByPostId(Long post_Id){
        return commentDAO.findByPostId(post_Id);
    }

    //updateComment()
    public void updateCommentById(Long commentId, Long post_Id, Comment comment){
        Post post = postDAO.findById(post_Id)
                .orElseThrow(() -> new RuntimeException(post_Id + "-> This Post ID doen't exist"));
        comment.setId(commentId);
        comment.setPost(post);

        commentDAO.save(comment);
    }

    //deleteCommentById()
    public void deleteCommentById(Long id){
        if(commentDAO.findById(id).isPresent()){
            commentDAO.deleteById(id);
        }else{
            throw new RuntimeException(id + " -> This Id doesn't exist");
        }
    }
}
