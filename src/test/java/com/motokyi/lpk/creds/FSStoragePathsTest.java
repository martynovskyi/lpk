package com.motokyi.lpk.creds;


import com.motokyi.lpk.config.LpkProperties;
import com.motokyi.lpk.model.meta.StorageMeta;
import com.motokyi.lpk.model.meta.StorageSnapshotMeta;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FSStoragePathsTest {

    private static final Path STORAGE_ROOT = Path.of(System.getProperty("java.io.tmpdir"), "lpk-test");
    private static final UUID STORAGE_ID = UUID.randomUUID();
    private static final Path STORAGE_PATH = STORAGE_ROOT.resolve(STORAGE_ID.toString());

    @Mock
    private LpkProperties props;

    @Mock
    private StorageMeta meta;

    @InjectMocks
    private FSStoragePaths storage;

    @BeforeAll
    static void beforeAll() throws IOException {
        if (!Files.exists(STORAGE_ROOT)) {
            Files.createDirectory(STORAGE_ROOT);
        }
    }

    @AfterAll
    static void afrerAll() throws IOException {
        Files.walk(STORAGE_ROOT)
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(File::delete);
    }

    @BeforeEach
    void setUp() {
        when(props.getStorage()).thenReturn(STORAGE_ROOT);
        when(meta.getId()).thenReturn(STORAGE_ID);
    }

    @Test
    void storageRoot() {
        final Path result = storage.storageRoot();

        assertAll(() -> {
            assertNotNull(result);
            assertEquals(STORAGE_PATH, result);
            assertEquals(STORAGE_PATH.toString(), result.toString());
            assertTrue(Files.exists(result));
            assertTrue(Files.isDirectory(result));
        });
    }

    @Test
    void getStorage() {
        final var storageSnapshot = new StorageSnapshotMeta(UUID.randomUUID(), "v-1", LocalDateTime.now());
        final Path expected = STORAGE_PATH.resolve(storageSnapshot.getId().toString());
        final Path result = this.storage.getStorage(storageSnapshot);

        assertAll(() -> {
            assertNotNull(result);
            assertEquals(expected, result);
            assertEquals(expected.toString(), result.toString());
            assertTrue(Files.exists(result));
            assertTrue(Files.isDirectory(result));
        });
    }
}