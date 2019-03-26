package com.motokyi.lpk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.lpk.storage.StorageVersion;
import lombok.Value;

import java.util.Set;
import java.util.UUID;

@Value
public class CredentialStorage {
    private final UUID id;
    private final StorageVersion version;
    private final Set<CredentialsEntry> credentials;

    @JsonCreator
    public CredentialStorage(
            @JsonProperty("id") UUID id,
            @JsonProperty("version") StorageVersion version,
            @JsonProperty("credentials") Set<CredentialsEntry> credentials) {
        this.id = id;
        this.version = version;
        this.credentials = credentials;
    }
}
