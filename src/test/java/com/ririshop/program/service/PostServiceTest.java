package com.ririshop.program.service;

import com.ririshop.program.domain.posts.Posts;
import com.ririshop.program.domain.posts.PostsRepository;
import com.ririshop.program.dto.PostsSaveRequestDto;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTest {
    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void Dto데이가_posts테이블에_저장된다() {
        //given
        PostsSaveRequestDto postsSaveRequestDto = PostsSaveRequestDto.builder()
                .title("테스트 타이틀").content("테스트").author("funch").build();
        //when
        postsService.save(postsSaveRequestDto);
        //then
        Posts posts = postsRepository.findAll().get(0);
        Assert.assertEquals(posts.getTitle(), "테스트 타이틀");
    }
}
