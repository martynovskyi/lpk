package com.motokyi.lpk.model.meta;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class StorageAction {
    private final LocalDateTime opened;
    private final LocalDateTime closed;


    @JsonCreator
    public StorageAction(@JsonProperty("opened") LocalDateTime opened,
                         @JsonProperty("closed") LocalDateTime closed) {
        this.opened = opened;
        this.closed = closed;
    }
}
