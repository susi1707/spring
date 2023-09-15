package com.rb.Postservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {

    @GetMapping(value = "/{postid}")
    public Post getPost(@PathVariable("postid") String id){
        Post post1 = new Post(id,"Post Description for: "+ id);
        return post1;
    }
}
