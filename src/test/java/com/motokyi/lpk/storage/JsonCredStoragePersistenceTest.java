package com.motokyi.lpk.storage;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.motokyi.lpk.model.CredentialStorage;
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
import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JsonCredStoragePersistenceTest extends FSTest {
    @Spy
    private static ObjectMapper mapper = new ObjectMapper();
    @Mock
    private StoragePaths storagePaths;
    @InjectMocks
    private JsonCredStoragePersistence persistence;


    @BeforeAll
    static void before() throws IOException {
        Files.createDirectory(STORAGE_PATH);
        mapper.registerModule(new JavaTimeModule());
    }

    @Test
    void load() throws IOException, URISyntaxException {
        final Path credPath = STORAGE_PATH.resolve(JsonCredStoragePersistence.CRD_LPK);
        final Path testCredFile = Paths.get(this.getClass().getResource("/filesystem/crd.lpk").toURI());
        when(storagePaths.latestCredsStorage()).thenReturn(STORAGE_PATH);

        assertTrue(Files.exists(testCredFile));
        Files.copy(testCredFile, credPath);
        assertTrue(Files.exists(credPath));

        final Optional<CredentialStorage> result = persistence.load();
        assertAll(() -> {
            assertNotNull(result);
            assertTrue(result.isPresent());
        });

    }

    @Test
    void loadNoCredOnFS() {
        when(storagePaths.latestCredsStorage()).thenReturn(STORAGE_PATH);

        final Optional<CredentialStorage> result = persistence.load();
        assertAll(() -> {
            assertNotNull(result);
            assertFalse(result.isPresent());
        });
    }

    @Test
    void save() {
        final Path credFile = STORAGE_PATH.resolve(JsonCredStoragePersistence.CRD_LPK);
        when(storagePaths.latestCredsStorage()).thenReturn(STORAGE_PATH);

        final CredentialStorage meta = new CredentialStorage(STORAGE_ID, StorageVersion.CURRENT, new HashSet<>());
        persistence.save(meta);

        assertTrue(Files.exists(credFile));
    }
}