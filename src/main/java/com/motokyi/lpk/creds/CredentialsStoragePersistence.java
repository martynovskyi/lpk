package com.motokyi.lpk.creds;

import com.motokyi.lpk.model.meta.StorageMeta;

import java.util.Optional;

public interface CredentialsStoragePersistence {
    Optional<StorageMeta> loadMeta();

    void save(final StorageMeta meta);
}
