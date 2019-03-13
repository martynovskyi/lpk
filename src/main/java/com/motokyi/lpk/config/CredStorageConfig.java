package com.motokyi.lpk.config;

import com.motokyi.lpk.creds.CredentialsStoragePersistence;
import com.motokyi.lpk.creds.StorageVersion;
import com.motokyi.lpk.model.meta.StorageMeta;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class CredStorageConfig {
    private final CredentialsStoragePersistence storage;

    @Bean
    public StorageMeta storageMeta() {
        final Optional<StorageMeta> storageMeta = storage.loadMeta();
        return storageMeta.orElseGet(CredStorageConfig::initNewStorage);
    }

    private static StorageMeta initNewStorage() {
        log.warn("Creating new storage");
        return StorageMeta.builder()
                .id(UUID.randomUUID())
                .version(StorageVersion.V_0_1)
                .created(LocalDateTime.now())
                .items(new HashSet<>())
                .actions(new ArrayList<>())
                .build();
    }
}
