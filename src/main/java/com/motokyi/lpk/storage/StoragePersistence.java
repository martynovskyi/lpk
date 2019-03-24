package com.motokyi.lpk.storage;

import java.util.Optional;

public interface StoragePersistence<T> {
    Optional<T> load();

    void save(final T meta);
}
