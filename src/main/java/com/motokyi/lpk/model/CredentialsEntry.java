package com.motokyi.lpk.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CredentialsEntry {
    private String name;
    private String URL;
    private String username;
    private String password;
    private String comment;
    private LocalDateTime created;
    private LocalDateTime updated;

}
