package com.motokyi.lpk.config;

import com.motokyi.lpk.model.meta.StorageMeta;
import com.motokyi.lpk.storage.StoragePersistence;
import com.motokyi.lpk.storage.StorageVersion;
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
    private final StoragePersistence<StorageMeta> storage;

    @Bean
    public StorageMeta storageMeta() {
        final Optional<StorageMeta> storageMeta = storage.load();
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
