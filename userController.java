package com.rb.Userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class userController {
@Autowired
private RestTemplate restTemplate;

    @GetMapping(value="/{id}")
    public User ggetUser(@PathVariable("id") String userId ){
        User user1 = new User(userId,"User Name: " + userId,
                "xxxxxx: "+userId);
        Post posts = restTemplate.getForObject(
                "http://POST-SERVICE/post/1",Post.class);
        user1.setPost(posts);
        Notification notifications = restTemplate.getForObject(
                "http://notification-service:8083/notification/1",Notification.class);
        user1.setNotification(notifications);
        return user1;
    }

}
