package com.dmedelacruz.contactmanagement.model.dto;

import com.dmedelacruz.contactmanagement.mapper.valueFilter.PreferredFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommunicationDto extends BaseDto {

    @JsonProperty("type")
    private String type;

    @JsonProperty("value")
    private String value;

    @JsonProperty("preferred")
    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = PreferredFilter.class)
    private Boolean preferred;

}
