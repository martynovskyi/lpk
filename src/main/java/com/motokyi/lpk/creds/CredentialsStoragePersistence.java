package com.motokyi.lpk.creds;

import com.motokyi.lpk.model.meta.StorageMeta;

import java.util.Optional;

public interface CredentialsStoragePersistence {
    Optional<StorageMeta> load();

    void save(final StorageMeta meta);
}
