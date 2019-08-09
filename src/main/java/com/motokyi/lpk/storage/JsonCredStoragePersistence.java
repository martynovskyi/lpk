package com.motokyi.lpk.storage;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.motokyi.lpk.model.CredentialStorage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class JsonCredStoragePersistence implements StoragePersistence<CredentialStorage> {
    public static final String CRD_LPK = "crd.lpk";
    private final ObjectMapper mapper;
    private final StoragePaths storagePaths;

    @Override
    public Optional<CredentialStorage> load() {
        final Path storage = storagePaths.latestCredsStorage().resolve(CRD_LPK);
        log.info("Attempt to load CredentialStorage from FS path: {}", storage);
        if (Files.exists(storage)) {
            try {
                final CredentialStorage meta = mapper.readerFor(CredentialStorage.class)
                        .readValue(storage.toFile());
                return Optional.of(meta);
            } catch (Exception e) {
                log.error("CredentialStorage loading error", e);
                //todo motokyi 2019-03-12: add preventing overwritten
                throw new RuntimeException("Stop the app storage meta corrupted", e);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean save(CredentialStorage creds) {
        final Path storage = storagePaths.latestCredsStorage().resolve(CRD_LPK);
        log.info("Saving CredentialStorage to FS path: {}", storage);
        final Optional<CredentialStorage> storageFromFile = load();

        if (storageFromFile.isPresent()) {
            if (hasDiff(storageFromFile.get(), creds)) {
                try {
                    mapper.writerWithDefaultPrettyPrinter()
                            .writeValue(storage.toFile(), creds);
                } catch (Exception e) {
                    log.error("Exception during writing storage", e);
                    return false;
                }
                log.info("Credentials changed. Storage overwritten.");
            } else {
                log.info("Credentials not changed. No actions.");
            }
            return true;
        } else {
            try {
                mapper.writerWithDefaultPrettyPrinter()
                        .writeValue(storage.toFile(), creds);
            } catch (Exception e) {
                log.error("Exception during writing new storage", e);
                return false;
            }
            log.info("CredentialStorage not found. Saved new.");
            return true;
        }
    }

    private boolean hasDiff(CredentialStorage c, CredentialStorage creds) {
        return !c.equals(creds);
    }
}
