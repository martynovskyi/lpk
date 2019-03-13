package com.motokyi.lpk.storage;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.motokyi.lpk.config.LpkProperties;
import com.motokyi.lpk.creds.CredentialsStoragePersistence;
import com.motokyi.lpk.model.meta.StorageMeta;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class JsonCredStorage implements CredentialsStoragePersistence {
    private final ObjectMapper mapper;
    private final LpkProperties props;

    @Override
    public Optional<StorageMeta> loadMeta() {
        if (Files.exists(props.getStorageMeta())) {
            try {
                final StorageMeta meta = mapper.readerFor(StorageMeta.class)
                        .readValue(props.getStorageMeta().toFile());
                final LocalDateTime opened = meta.opened();
                log.info("Storage opened at: " + opened);
                return Optional.of(meta);
            } catch (Exception e) {
                log.error("Storage meta loading error", e);
                //todo motokyi 2019-03-12: add preventing overwritten
                throw new RuntimeException("Stop the app storage meta corrupted", e);
            }
        }
        return Optional.empty();

    }

    @Override
    public void save(final StorageMeta meta) {
        try {
            final LocalDateTime closed = meta.closed();
            log.info("Storage closed at: " + closed);
            //todo motokyi 2019-03-12: add checks for overwritten
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(props.getStorageMeta().toFile(), meta);
        } catch (IOException e) {
            //todo motokyi 2019-03-12: handle exception
            log.error("Storage meta-data saving error", e);
        }
    }
}
