package com.motokyi.lpk.creds;

import com.motokyi.lpk.model.CredentialsEntry;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(MockitoExtension.class)
class DefaultCredsServiceTest {

    @InjectMocks
    private DefaultCredsService credsService;

    static Stream<CredentialsEntry> invalidCreds() {
        return Stream.of(CredentialsEntry.builder().build(),
                CredentialsEntry.builder()
                        .name("      ")
                        .url("     ")
                        .login("   ")
                        .password("  ")
                        .build(),
                CredentialsEntry.builder()
                        .name("Superhero")
                        .build(),
                CredentialsEntry.builder()
                        .url("https://secure.com/")
                        .build(),
                CredentialsEntry.builder()
                        .login("batman_777")
                        .build(),
                CredentialsEntry.builder()
                        .password("bruce_hero")
                        .build(),
                CredentialsEntry.builder()
                        .login("batman_777")
                        .password("bruce_hero")
                        .build(),
                CredentialsEntry.builder()
                        .name("Superhero")
                        .url("secure.com")
                        .login("batman_777")
                        .password("bruce_hero")
                        .build()
        );
    }

    @Test
    void add() {
    }

    @Test
    void find() {
    }

    @Test
    void update() {
    }

    @Test
    void remove() {
    }

    @Test
    void isValid() {
        assertTrue(credsService.isValid(CredentialsEntry.builder()
                .name("Superhero")
                .url("https://secure.com/")
                .login("batman_777")
                .password("bruce_hero")
                .comment("Superman not a hero!")
                .build())
        );
    }

    @ParameterizedTest
    @NullSource
    @MethodSource("invalidCreds")
    void isValidFalse(CredentialsEntry creds) {
        assertFalse(credsService.isValid(creds));
    }
}