package com.nuracell.shelltest.app.command;

import com.nuracell.shelltest.app.client.jsonplaceholder.JSONPlaceHolderClient;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.command.annotation.Command;

@Command(command = "jsonplaceholder", group = "Json Place Holder API")
@RequiredArgsConstructor
public class JsonPlaceHolderCommands {

    private final JSONPlaceHolderClient jsonPlaceHolderClient;

    @Command(command = "get-posts-count")
    public int getPostsCount() {
        return jsonPlaceHolderClient.getAllPosts().size();
    }

    @Command(command = "get-post")
    public String getPostById(long id) {
        return jsonPlaceHolderClient.getPostById(id).toString();
    }

}
