package com.dmedelacruz.contactmanagement.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonDto extends BaseDto {

    @JsonProperty("Identification")
    private Identification identification;

    @JsonProperty("Address")
    private List<AddressDto> addressList;

    @JsonProperty("Communication")
    private List<CommunicationDto> communicationList;

}
