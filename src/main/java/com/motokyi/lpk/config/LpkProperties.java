package com.motokyi.lpk.config;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Slf4j
@Setter
@Component
@EnableConfigurationProperties
@ConfigurationProperties(value = "lpk")
public class LpkProperties {
    private static final Path DEFAULT_LPK_HOME = Path.of(System.getProperty("user.home"), ".lpk");
    private static final String CONFIG_SUBDIR = "config";
    private static final String STORAGE_SUBDIR = "storage";
    private static final String META_FILE = STORAGE_SUBDIR + ".meta";
    private static Path homePath;
    private static Path storagePath;
    private static Path configPath;
    private String home;

    public Path getHome() {
        if (isNull(homePath)) {
            initHome();
        }
        return homePath;
    }

    public Path getStorage() {
        if (isNull(storagePath)) {
            initStorage();
        }
        return homePath;
    }

    public Path getConfig() {
        if (isNull(configPath)) {
            initConfig();
        }
        return configPath;
    }

    public Path getStorageMeta() {
        return getStorage().resolve(META_FILE);
    }

    @PostConstruct
    public void init() {
        initHome();
        log.info("HOME: " + homePath);
        initConfig();
        log.info("CONFIG: " + configPath);
        initStorage();
        log.info("STORAGE: " + storagePath);

    }

    private void initHome() {
        if (nonNull(home)) {
            final Path customHome = Path.of(home);
            if (!Files.exists(customHome)) {
                final String message = "Home directory: " + home + " dont exist";
                log.error(message);
                throw new RuntimeException(message);
            }
            homePath = customHome;
        } else {
            homePath = DEFAULT_LPK_HOME;
        }

        if (!Files.exists(homePath)) {
            try {
                Files.createDirectory(homePath);
            } catch (IOException e) {
                final String message = "Cannot create homePath directory: " + homePath.toString();
                log.error(message, e);
                throw new RuntimeException(message, e);
            }
        }
    }

    private void initConfig() {
        if (nonNull(configPath)) {
            return;
        }
        if (isNull(home)) {
            initHome();
        }
        configPath = homePath.resolve(CONFIG_SUBDIR);

        if (!Files.exists(configPath)) {
            try {
                Files.createDirectory(configPath);
            } catch (IOException e) {
                final String message = "Cannot create configPath directory: " + configPath.toString();
                log.error(message, e);
                throw new RuntimeException(message, e);
            }
        }
    }

    private void initStorage() {
        if (nonNull(storagePath)) {
            return;
        }
        if (isNull(home)) {
            initHome();
        }
        storagePath = homePath.resolve(STORAGE_SUBDIR);

        if (!Files.exists(storagePath)) {
            try {
                Files.createDirectory(storagePath);
            } catch (IOException e) {
                final String message = "Cannot create storagePath directory: " + storagePath.toString();
                log.error(message, e);
                throw new RuntimeException(message, e);
            }
        }

    }
}
