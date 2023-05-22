package com.example.demo.rest;

import com.example.demo.modules.user.dto.response.PostResponse;
import com.example.demo.modules.user.dto.response.SmsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "jplaceholder", url = "http://sms.sslwireless.com")
public interface RestFeign {
    @RequestMapping(method = RequestMethod.GET, value = "posts")
    List<PostResponse> getPosts();

    @PostMapping(value = "/pushapi/dynamic/server.php?user=metlifeapi&pass=c=78V022&sid=metlifeapi&sms=hello niz&msisdn=8801912821380&csmsid=123456789")
    String smsSend();

//    @RequestMapping(method = RequestMethod.GET, value = "/posts/{postId}", produces = "application/json")
//    Post getPostById(@PathVariable("postId") Long postId);
}

