package com.back.global.initData;

import com.back.domain.post.post.document.Post;
import com.back.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // 설정 클래스 지정
@Slf4j
@RequiredArgsConstructor
public class BaseInitData {

    private final PostService postService;

    // Bean을 통해 애플리케이션 시작 시 초기화 로직 실행
    @Bean
    public ApplicationRunner baseInitDataRunner (){
        return args->{
            work1();
            work2();
            work3();
            work4();
        };
    }

    private void work1(){
        if (postService.count() == 0){
            log.debug("Post entity 개수: {}", postService.count());
            log.debug("샘플 Post 데이터 생성");
            // Post entity 10개 생성
            for (int i = 1; i <= 10; i++) {
                String title = "Sample Post Title " + i;
                String content = "This is the content of sample post number " + i + ".";
                String author = "Author " + i;
                Post post = postService.create(title, content, author);
                log.debug("Created Post: {}", post);
            }
        }
    }

    private void work2(){
        log.debug("기존 Post 전체 조회");
        for (Post post : postService.findAll()) {
            log.debug("Existing Post: {}", post);
        }
    }

    private void work3(){
        log.debug("Post 단건 조회");
        for (Post post : postService.findAll()) {
            Post fetchedPost = postService.findById(post.getId());
            log.debug("조회된 Post: {}", fetchedPost);
        }
    }

    private void work4(){
        log.debug("Post 단건 수정");
        for (Post post : postService.findAll()) {
            String newTitle = post.getTitle() + " [Updated]";
            String newContent = post.getContent() + " This content has been updated.";
            Post updatedPost = postService.update(post.getId(), newTitle, newContent);
            log.debug("Updated Post: {}", updatedPost);
        }
    }

//    public void work3_1(){
//        log.debug("Post 조회 예외처리 예시");
//        postService.findById("NotFoundException sample id");
//    }
}