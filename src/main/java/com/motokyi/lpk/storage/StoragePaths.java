package com.motokyi.lpk.storage;

import com.motokyi.lpk.model.meta.StorageSnapshotMeta;

import java.nio.file.Path;

public interface StoragePaths {
    Path storageRoot();

    Path latestCredsStorage();

    Path getStorage(StorageSnapshotMeta item);
}
