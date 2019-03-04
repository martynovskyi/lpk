package com.motokyi.lpk.storage;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.motokyi.lpk.config.LpkProperties;
import com.motokyi.lpk.creds.CredentialsStorage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class JsonCredStorage implements CredentialsStorage {
    private final ObjectMapper mapper;
    private final LpkProperties props;

    @Override
    public void load() {
    }

    @Override
    public void save() {

    }
}
