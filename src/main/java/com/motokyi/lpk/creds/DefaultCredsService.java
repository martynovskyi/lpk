package com.motokyi.lpk.creds;

import com.motokyi.lpk.model.CredentialsEntry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class DefaultCredsService implements CredService {


    @Override
    public void add(CredentialsEntry cred) {

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
        return false;
    }
}
