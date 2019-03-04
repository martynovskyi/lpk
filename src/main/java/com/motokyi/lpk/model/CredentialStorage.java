package com.motokyi.lpk.model;

import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class CredentialStorage {
    private UUID id;
    private String version;
    private Set<CredentialsEntry> credentials;

}
