package com.motokyi.lpk.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder(builderClassName = "DefaultValues")
public class CredentialsEntry {
    private UUID id;
    private String name;
    private String url;
    private String login;
    private String password;
    private String comment;
    private LocalDateTime created;
    private LocalDateTime updated;

    public static class DefaultValues {
        private UUID id = UUID.randomUUID();
        private LocalDateTime created = LocalDateTime.now();

    }

}
