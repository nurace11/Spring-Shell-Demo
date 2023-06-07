package com.nuracell.shelltest.app.client.jsonplaceholder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private Long userId;
    private Long id;
    private String title;
    private String body;
}
