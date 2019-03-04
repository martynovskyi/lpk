package com.motokyi.lpk.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class CredentialStorageMeta {
    private UUID credsId;
    private UUID credsVersion;
    private LocalDateTime created;
    private LocalDateTime updated;
}
