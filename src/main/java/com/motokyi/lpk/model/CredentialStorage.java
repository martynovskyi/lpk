package com.motokyi.lpk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.lpk.storage.StorageVersion;
import lombok.Value;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static java.util.Objects.requireNonNullElse;

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

    public boolean add(CredentialsEntry creds) {
        return credentials.add(creds);

    }

    @JsonProperty("credentials")
    public Set<CredentialsEntry> getUnmodCredentials() {
        return Collections.unmodifiableSet(requireNonNullElse(credentials, new HashSet<>()));
    }
}
