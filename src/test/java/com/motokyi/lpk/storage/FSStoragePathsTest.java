package com.motokyi.lpk.storage;


import com.motokyi.lpk.config.LpkProperties;
import com.motokyi.lpk.model.meta.StorageMeta;
import com.motokyi.lpk.model.meta.StorageSnapshotMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
class FSStoragePathsTest extends FSTest {

    @Mock
    private LpkProperties props;

    @Mock
    private StorageMeta meta;

    @InjectMocks
    private FSStoragePaths storage;

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
        final var storageSnapshot = new StorageSnapshotMeta(UUID.randomUUID(), StorageVersion.CURRENT, LocalDateTime.now());
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

    @Test
    void latestCredsStorage() {
        final var storageSnapshot1 = new StorageSnapshotMeta(UUID.randomUUID(), StorageVersion.CURRENT, LocalDateTime.now());
        final var storageSnapshot2 = new StorageSnapshotMeta(UUID.randomUUID(), StorageVersion.CURRENT, LocalDateTime.now().minusDays(1));
        when(meta.getUnmodSnapshots()).thenReturn(Set.of(storageSnapshot1, storageSnapshot2));
        final Path result = this.storage.latestCredsStorage();

        assertAll(() -> {
            assertNotNull(result);
            assertTrue(result.endsWith(storageSnapshot1.getId().toString()));
            assertTrue(result.getParent().endsWith(STORAGE_ID.toString()));
            assertTrue(Files.exists(result));
            assertTrue(Files.isDirectory(result));
        });
    }

    @Test
    void latestCredsStorageNoItems() {
        final Path result = this.storage.latestCredsStorage();

        verify(meta, times(1)).add(any(StorageSnapshotMeta.class));

        assertAll(() -> {
            assertNotNull(result);
            assertTrue(Files.exists(result));
            assertTrue(result.getParent().endsWith(STORAGE_ID.toString()));
            assertTrue(Files.isDirectory(result));
        });
    }
}