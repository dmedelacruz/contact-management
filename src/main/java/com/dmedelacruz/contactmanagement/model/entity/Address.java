package com.dmedelacruz.contactmanagement.model.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "Address")
@Entity(name = "Address")
@Data
public class Address extends BaseEntity {

    @Column(name = "type")
    private String type;

    @Column(name = "number")
    private Integer number;

    @Column(name = "street")
    private String street;

    @Column(name = "unit")
    private String unit;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip_code")
    private Integer zipCode;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, optional = false)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

}
