package com.dmedelacruz.contactmanagement.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public abstract class BaseDto {

    @JsonProperty("id")
    private String id;

}
