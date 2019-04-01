package com.motokyi.lpk.creds;

import com.motokyi.lpk.model.CredentialsEntry;

import java.util.List;
import java.util.UUID;

public interface CredService {
    boolean add(CredentialsEntry cred);

    List<CredentialsEntry> find(String keyword);

    boolean update(CredentialsEntry cred);

    boolean remove(UUID id);

    boolean isValid(CredentialsEntry cred);


}
