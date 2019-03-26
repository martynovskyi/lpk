package com.motokyi.lpk.config;

import com.motokyi.lpk.model.CredentialStorage;
import com.motokyi.lpk.model.meta.StorageMeta;
import com.motokyi.lpk.storage.StoragePersistence;
import com.motokyi.lpk.storage.StorageVersion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Configuration
public class FSStorageLoader {

    private static StorageMeta initNewMetaStorage() {
        log.warn("Current meta not found. Creating new storage meta.");
        return StorageMeta.builder()
                .id(UUID.randomUUID())
                .version(StorageVersion.CURRENT)
                .created(LocalDateTime.now())
                .snapshotsMeta(new HashSet<>())
                .actions(new ArrayList<>())
                .build();
    }

    private static CredentialStorage initNewCredStorage(StorageMeta meta) {
        log.warn("Credentials Storage not found. Creating new credential storage.");
        //todo motokyi 2019-03-24:
        return new CredentialStorage(meta.getId(), StorageVersion.CURRENT, new HashSet<>());
    }

    @Bean
    public StorageMeta storageMeta(final StoragePersistence<StorageMeta> metaPersistence) {
        final Optional<StorageMeta> storageMeta = metaPersistence.load();
        return storageMeta.orElseGet(FSStorageLoader::initNewMetaStorage);
    }

    @Bean
    public CredentialStorage storage(StoragePersistence<CredentialStorage> credsPersistence, StorageMeta meta) {
        final Optional<CredentialStorage> credentialStorage = credsPersistence.load();
        return credentialStorage.orElseGet(() -> initNewCredStorage(meta));
    }

}
