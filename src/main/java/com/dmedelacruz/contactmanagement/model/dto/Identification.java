package com.dmedelacruz.contactmanagement.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Identification {

    @JsonProperty("FirstName")
    private String firstName;

    @JsonProperty("LastName")
    private String lastName;

    @JsonProperty("DOB")
    private String birthDate;

    @JsonProperty("Gender")
    private String gender;

    @JsonProperty("Title")
    private String title;
}
