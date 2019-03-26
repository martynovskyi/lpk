package com.motokyi.lpk.storage;

import com.motokyi.lpk.config.LpkProperties;
import com.motokyi.lpk.model.meta.StorageMeta;
import com.motokyi.lpk.model.meta.StorageSnapshotMeta;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class FSStoragePaths implements StoragePaths {
    private final LpkProperties props;
    private final StorageMeta meta;

    @Override
    public Path storageRoot() {
        final Path storageRoot = props.getStorage().resolve(meta.getId().toString());
        createDirectory(storageRoot);
        return storageRoot;

    }

    @Override
    public Path latestCredsStorage() {
        final Optional<StorageSnapshotMeta> max = meta.getUnmodSnapshots()
                .stream().max(Comparator.comparing(StorageSnapshotMeta::getCreated));
        final var snapshotMeta = max.orElseGet(this::newSnapshot);
        return getStorage(snapshotMeta);
    }

    @Override
    public Path getStorage(StorageSnapshotMeta storageItem) {
        final Path storagePath = storageRoot().resolve(storageItem.getId().toString());
        createDirectory(storagePath);
        return storagePath;
    }

    private StorageSnapshotMeta newSnapshot() {
        var snapshotMeta = new StorageSnapshotMeta(UUID.randomUUID(), StorageVersion.CURRENT, LocalDateTime.now());
        meta.add(snapshotMeta);
        return snapshotMeta;
    }

    private void createDirectory(Path storageRoot) {
        if (!Files.exists(storageRoot)) {
            try {
                Files.createDirectory(storageRoot);
            } catch (IOException e) {
                //todo motokyi 2019-03-13: handle problems with file system
                log.error("Resolving FS Path issue", e);
            }
        }
    }
}
