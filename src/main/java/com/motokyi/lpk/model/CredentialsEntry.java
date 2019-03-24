package com.motokyi.lpk.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class CredentialsEntry {
    private UUID id;
    private String name;
    private String URL;
    private String username;
    private String password;
    private String comment;
    private LocalDateTime created;
    private LocalDateTime updated;

}
