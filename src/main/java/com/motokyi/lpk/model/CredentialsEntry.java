package com.motokyi.lpk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
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

    @JsonCreator
    public CredentialsEntry creator(
            @JsonProperty("id") UUID id,
            @JsonProperty("name") String name,
            @JsonProperty("url") String url,
            @JsonProperty("login") String login,
            @JsonProperty("password") String password,
            @JsonProperty("comment") String comment,
            @JsonProperty("created") LocalDateTime created,
            @JsonProperty("updated") LocalDateTime updated) {
        final CredentialsEntry cred = new CredentialsEntry();
        this.id = id;
        this.name = name;
        this.url = url;
        this.login = login;
        this.password = password;
        this.comment = comment;
        this.created = created;
        this.updated = updated;
        return cred;
    }

    public static class DefaultValues {
        private UUID id = UUID.randomUUID();
        private LocalDateTime created = LocalDateTime.now();

    }

}
