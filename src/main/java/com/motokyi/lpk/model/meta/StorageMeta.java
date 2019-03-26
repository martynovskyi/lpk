package com.motokyi.lpk.model.meta;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.lpk.storage.StorageVersion;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.*;

import static java.util.Objects.isNull;
import static java.util.Objects.requireNonNullElse;

@Getter
@Builder()
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
    @Getter(AccessLevel.NONE)
    private Set<StorageSnapshotMeta> snapshotsMeta;
    @Getter(AccessLevel.NONE)
    private List<StorageAction> actions;

    @JsonCreator
    public static StorageMeta creator(@JsonProperty("id") UUID id,
                                      @JsonProperty("version") StorageVersion version,
                                      @JsonProperty("created") LocalDateTime created,
                                      @JsonProperty("updated") LocalDateTime updated,
                                      @JsonProperty("snapshotsMeta") Set<StorageSnapshotMeta> items,
                                      @JsonProperty("actions") List<StorageAction> actions) {

        final var storageMetaBuilder = StorageMeta.builder()
                .id(id)
                .version(version)
                .updated(updated)
                .created(created)
                .opened(LocalDateTime.now());

        if (isNull(items)) {
            storageMetaBuilder.snapshotsMeta(new HashSet<>());
        } else {
            storageMetaBuilder.snapshotsMeta(items);
        }

        if (isNull(actions)) {
            storageMetaBuilder.actions(new ArrayList<>());
        } else {
            storageMetaBuilder.actions(actions);
        }

        return storageMetaBuilder.build();
    }

    public boolean add(StorageSnapshotMeta snapshot) {
        this.updated = LocalDateTime.now();
        return this.snapshotsMeta.add(snapshot);
    }

    @JsonProperty("snapshotsMeta")
    public Set<StorageSnapshotMeta> getUnmodSnapshots() {
        return Collections.unmodifiableSet(requireNonNullElse(snapshotsMeta, new HashSet<>()));
    }

    @JsonProperty("actions")
    public List<StorageAction> getUnmodActions() {
        return Collections.unmodifiableList(requireNonNullElse(actions, new ArrayList<>()));

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
            if (isNull(this.actions)) {
                this.actions = new ArrayList<>();
            }
            this.actions.add(new StorageAction(opened, closed));
        }
        return this.closed;
    }


}
