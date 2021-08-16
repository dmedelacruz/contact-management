package com.dmedelacruz.contactmanagement.model.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "Communication")
@Entity(name = "Communication")
@Data
public class Communication extends BaseEntity {

    @Column(name = "type")
    private String type;

    @Column(name = "value")
    private String value;

    @Column(name = "preferred")
    private Boolean preferred;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, optional = false)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;
}
