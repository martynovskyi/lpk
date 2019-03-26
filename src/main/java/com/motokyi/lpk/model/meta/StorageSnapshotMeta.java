package com.motokyi.lpk.model.meta;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.lpk.storage.StorageVersion;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class StorageSnapshotMeta {
    private final UUID id;
    private final StorageVersion version;
    private final LocalDateTime created;

    @JsonCreator
    public StorageSnapshotMeta(
            @JsonProperty("id") UUID id,
            @JsonProperty("version") StorageVersion version,
            @JsonProperty("created") LocalDateTime created) {
        this.id = id;
        this.version = version;
        this.created = created;
    }
}
