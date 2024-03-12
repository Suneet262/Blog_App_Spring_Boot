package com.example.blog_app.service;

import com.example.blog_app.bean.Post;
import com.example.blog_app.dao.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostDAO postDAO;

    public Post createPost(Post post){
        return  postDAO.save(post);
    }

    public Post getPostById(Long Id){
        return postDAO.findById(Id).orElseThrow(() -> new RuntimeException(Id + ": This id doesn't exist"));
    }

    public List<Post> getAllPost(){
        return postDAO.findAll();
    }

    public void updatePostById(Post post, Long Id){
        if(postDAO.findById(Id).isPresent()){
            Post newPost = new Post();
            newPost.setId(Id);
            newPost.setTitle(post.getTitle());
            newPost.setDescription(post.getDescription());

             postDAO.save(newPost);
        } else{
            throw  new RuntimeException(Id + " -> This Id doesn't exist");
        }
    }

    public void deletePostById(Long Id){
        if(postDAO.findById(Id).isPresent()){
            postDAO.deleteById(Id);
        }else{
            throw new RuntimeException(Id + " -> This Id doesn't exist");
        }
    }
}
