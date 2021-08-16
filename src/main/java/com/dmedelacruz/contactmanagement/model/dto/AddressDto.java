package com.dmedelacruz.contactmanagement.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDto extends BaseDto {

    @JsonProperty("type")
    private String type;

    @JsonProperty("number")
    private Integer number;

    @JsonProperty("street")
    private String street;

    @JsonProperty("Unit")
    private String unit;

    @JsonProperty("City")
    private String city;

    @JsonProperty("State")
    private String state;

    @JsonProperty("zipcode")
    private Integer zipCode;

}
