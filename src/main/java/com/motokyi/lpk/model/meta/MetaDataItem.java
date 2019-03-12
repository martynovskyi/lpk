package com.motokyi.lpk.model.meta;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class MetaDataItem {
    private UUID credsId;
    private UUID credsVersion;
    private LocalDateTime created;
}
