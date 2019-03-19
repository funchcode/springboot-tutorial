package com.ririshop.program.controller;

import com.ririshop.program.domain.posts.PostsRepository;
import com.ririshop.program.dto.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {
    private PostsRepository postsRepository;

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }
    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto) {
        postsRepository.save(dto.toEntity());
    }
}