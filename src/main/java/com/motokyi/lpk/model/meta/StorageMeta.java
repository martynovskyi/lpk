package com.motokyi.lpk.model.meta;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.lpk.storage.StorageVersion;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.*;

import static java.util.Objects.isNull;

@Getter
@Builder
public class StorageMeta {
    private final UUID id;
    private final StorageVersion version;
    private final LocalDateTime created;
    @Setter
    private LocalDateTime updated;
    @JsonIgnore
    private LocalDateTime opened;
    @JsonIgnore
    private LocalDateTime closed;
    @JsonIgnore
    private StorageAction currentAction;
    private Set<StorageSnapshotMeta> items = new HashSet<>();
    private List<StorageAction> actions = new ArrayList<>();

    @JsonCreator
    public static StorageMeta creator(@JsonProperty("id") UUID id,
                                      @JsonProperty("version") StorageVersion version,
                                      @JsonProperty("created") LocalDateTime created,
                                      @JsonProperty("updated") LocalDateTime updated,
                                      @JsonProperty("items") Set<StorageSnapshotMeta> items,
                                      @JsonProperty("actions") List<StorageAction> actions) {

        final var storage = StorageMeta.builder()
                .id(id)
                .version(version)
                .updated(updated)
                .created(created)
                .opened(LocalDateTime.now());

        if (isNull(items)) {
            storage.items(new HashSet<>());
        } else {
            storage.items(items);
        }

        if (isNull(actions)) {
            storage.actions(new ArrayList<>());
        } else {
            storage.actions(actions);
        }

        return storage.build();
    }

    public LocalDateTime opened() {
        if (isNull(this.opened)) {
            this.opened = LocalDateTime.now();
        }
        return this.opened;
    }

    public LocalDateTime closed() {
        if (isNull(this.closed)) {
            this.closed = LocalDateTime.now();
            this.actions.add(new StorageAction(opened, closed));
        }
        return this.closed;
    }

}
