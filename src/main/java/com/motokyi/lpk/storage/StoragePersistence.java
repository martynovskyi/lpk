package com.motokyi.lpk.storage;

import java.util.Optional;

public interface StoragePersistence<T> {

    Optional<T> load();

    boolean save(final T entity);
}
