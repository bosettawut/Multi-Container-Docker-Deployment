package com.example.backend.user.dto;

import com.example.backend.user.User;
import lombok.Data;

@Data
public class AddDto {
    private long id;

    public AddDto(User user) {
        this.id = user.getId();
    }
}
