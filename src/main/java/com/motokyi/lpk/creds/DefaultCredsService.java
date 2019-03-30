package com.motokyi.lpk.creds;

import com.motokyi.lpk.model.CredentialsEntry;
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


    @Override
    public void add(CredentialsEntry cred) {
        log.info(cred.toString());
    }

    @Override
    public List<CredentialsEntry> find(String keyword) {
        return null;
    }

    @Override
    public void update(CredentialsEntry cred) {

    }

    @Override
    public void remove(UUID id) {

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
