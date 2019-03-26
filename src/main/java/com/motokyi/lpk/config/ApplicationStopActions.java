package com.motokyi.lpk.config;

import com.motokyi.lpk.model.CredentialStorage;
import com.motokyi.lpk.model.meta.StorageMeta;
import com.motokyi.lpk.storage.StoragePersistence;
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
    private final CredentialStorage creds;
    private final StoragePersistence<CredentialStorage> credsPersistence;
    private final StoragePersistence<StorageMeta> metaPersistence;

    @Override
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
        //todo motokyi 2019-03-24: handle issues
        credsPersistence.save(creds);
        metaPersistence.save(meta);
    }
}
