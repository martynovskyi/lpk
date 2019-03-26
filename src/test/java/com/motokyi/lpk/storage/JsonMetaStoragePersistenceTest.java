package com.motokyi.lpk.storage;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.motokyi.lpk.config.LpkProperties;
import com.motokyi.lpk.model.meta.StorageMeta;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JsonMetaStoragePersistenceTest extends FSTest {
    @Spy
    private static ObjectMapper mapper = new ObjectMapper();
    @Mock
    private LpkProperties props;
    @InjectMocks
    private JsonMetaStoragePersistence persistence;


    @BeforeAll
    static void before() {
        mapper.registerModule(new JavaTimeModule());
    }

    @Test
    void load() throws IOException, URISyntaxException {
        final Path metaPath = STORAGE_ROOT.resolve("test.meta");
        final Path testMetaFile = Paths.get(this.getClass().getResource("/filesystem/test.meta").toURI());
        when(props.getStorageMeta()).thenReturn(metaPath);

        assertTrue(Files.exists(testMetaFile));
        Files.copy(testMetaFile, metaPath);
        assertTrue(Files.exists(metaPath));

        final Optional<StorageMeta> result = persistence.load();
        assertAll(() -> {
            assertNotNull(result);
            assertTrue(result.isPresent());
        });

    }

    @Test
    void loadNoMetaOnFS() {
        when(props.getStorageMeta()).thenReturn(STORAGE_ROOT.resolve("fail-test.meta"));

        final Optional<StorageMeta> result = persistence.load();
        assertAll(() -> {
            assertNotNull(result);
            assertFalse(result.isPresent());
        });

    }

    @Test
    void save() {
        final Path metaFile = STORAGE_ROOT.resolve("saved-test.meta");
        when(props.getStorageMeta()).thenReturn(metaFile);

        final StorageMeta meta = StorageMeta.builder()
                .build();
        persistence.save(meta);

        assertTrue(Files.exists(metaFile));
    }
}