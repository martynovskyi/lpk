package com.motokyi.lpk.creds;

import com.motokyi.lpk.model.CredentialsEntry;

import java.util.List;
import java.util.UUID;

public interface CredService {
    void add(CredentialsEntry cred);

    List<CredentialsEntry> find(String keyword);

    void update(CredentialsEntry cred);

    void remove(UUID id);

    boolean isValid(CredentialsEntry cred);


}
