package com.motokyi.lpk.storage;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StorageVersion {
    V_0_1("0.1");

    private String ver;

    StorageVersion(String version) {
        this.ver = version;
    }

    @JsonValue
    @Override
    public String toString() {
        return ver;
    }


}
