package com.example.backend.user.dto;

import com.example.backend.user.User;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class GetIdDto {
    private String title;
    private String content;
    private String createdAt;

    public GetIdDto(User user) {
        this.title = user.getTitle();
        this.content = user.getContent();
        this.createdAt = user.getCreatedAt();
    }
}

