package com.motokyi.lpk.creds;

import com.motokyi.lpk.model.meta.StorageSnapshotMeta;

import java.nio.file.Path;

public interface StoragePaths {
    Path storageRoot();

    Path getStorage(StorageSnapshotMeta item);
}
