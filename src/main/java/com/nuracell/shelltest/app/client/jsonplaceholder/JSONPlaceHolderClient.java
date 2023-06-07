package com.nuracell.shelltest.app.client.jsonplaceholder;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "jsonplaceholder",
        url = "https://jsonplaceholder.typicode.com/"
)
public interface JSONPlaceHolderClient {
    @GetMapping("posts")
    List<Post> getAllPosts();

    @GetMapping("posts/{id}")
    Post getPostById(@PathVariable("id") Long id);
}
