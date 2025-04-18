package com.enjoy.ds.ratelimiter;

import com.enjoy.ds.ratelimiter.annotation.LoggableApi;
import com.enjoy.ds.ratelimiter.annotation.RateLimit;
import com.enjoy.ds.ratelimiter.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/posts")
public class PostController {
  private final PostRepository postRepository;

  @Autowired
  public PostController(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  @LoggableApi(number = 42, apiName = "post-get")
  @RateLimit(apiName = "post_a_post")
  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<ResponseEntity<Post>> getPost(@PathVariable String id) {
    return postRepository
        .findPost(id)
        .map(post -> ResponseEntity.ok(post))
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }
}
