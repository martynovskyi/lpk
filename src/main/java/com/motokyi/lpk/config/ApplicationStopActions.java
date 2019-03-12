package com.motokyi.lpk.config;

import com.motokyi.lpk.creds.CredentialsStoragePersistence;
import com.motokyi.lpk.model.meta.StorageMeta;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ApplicationStopActions implements ApplicationListener<ContextClosedEvent> {
    private final StorageMeta meta;
    private final CredentialsStoragePersistence persistence;

    @Override
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {

        persistence.save(meta);
    }
}
