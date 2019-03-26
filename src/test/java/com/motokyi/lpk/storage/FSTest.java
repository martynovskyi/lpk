package com.motokyi.lpk.storage;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.UUID;

public class FSTest {
    protected static final Path STORAGE_ROOT = Path.of(System.getProperty("java.io.tmpdir"), "lpk-test");
    protected static final UUID STORAGE_ID = UUID.randomUUID();
    protected static final Path STORAGE_PATH = STORAGE_ROOT.resolve(STORAGE_ID.toString());


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
}
