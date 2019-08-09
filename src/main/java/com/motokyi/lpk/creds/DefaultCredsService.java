package com.motokyi.lpk.creds;

import com.motokyi.lpk.model.CredentialStorage;
import com.motokyi.lpk.model.CredentialsEntry;
import com.motokyi.lpk.storage.StoragePersistence;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static java.util.Objects.nonNull;

@Slf4j
@Service
@RequiredArgsConstructor
public class DefaultCredsService implements CredService {
    private final CredentialStorage storage;
    private final StoragePersistence<CredentialStorage> persistence;

    @Override
    public boolean add(CredentialsEntry cred) {
        return storage.add(cred) && persistence.save(storage);
    }

    @Override
    public List<CredentialsEntry> find(String keyword) {
        return null;
    }

    @Override
    public boolean update(CredentialsEntry cred) {
        return false;
    }

    @Override
    public boolean remove(UUID id) {
        return false;
    }

    @Override
    public boolean isValid(CredentialsEntry cred) {
        return nonNull(cred)
                && nonNull(cred.getId())
                && CredsValidator.isValid(CredsType.URL, cred.getUrl())
                && CredsValidator.isValid(CredsType.NAME, cred.getName())
                && CredsValidator.isValid(CredsType.LOGIN, cred.getLogin())
                && CredsValidator.isValid(CredsType.PASSWORD, cred.getPassword())
                && nonNull(cred.getCreated());
    }
}
