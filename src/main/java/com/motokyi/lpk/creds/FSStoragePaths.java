package com.motokyi.lpk.creds;

import com.motokyi.lpk.config.LpkProperties;
import com.motokyi.lpk.model.meta.StorageMeta;
import com.motokyi.lpk.model.meta.StorageSnapshotMeta;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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
    public Path getStorage(@NonNull StorageSnapshotMeta storageItem) {
        final Path stotagePath = storageRoot().resolve(storageItem.getId().toString());
        createDirectory(stotagePath);
        return stotagePath;
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
