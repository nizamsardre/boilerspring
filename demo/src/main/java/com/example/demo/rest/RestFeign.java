package com.example.demo.rest;

import com.example.demo.modules.user.dto.response.PostResponse;
import com.example.demo.modules.user.dto.response.SmsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "jplaceholder", url = "http://sms.sslwireless.com")
public interface RestFeign {
    @RequestMapping(method = RequestMethod.GET, value = "posts")
    List<PostResponse> getPosts();

    @PostMapping(value = "sms={message}&msisdn=8801912821380&csmsid=123456789")
    String smsSend(@PathVariable("message") String  message);

//    @RequestMapping(method = RequestMethod.GET, value = "/posts/{postId}", produces = "application/json")
//    Post getPostById(@PathVariable("postId") Long postId);
}

