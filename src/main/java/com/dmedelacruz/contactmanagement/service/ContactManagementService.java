package com.dmedelacruz.contactmanagement.service;

import com.dmedelacruz.contactmanagement.model.dto.BaseDto;
import com.dmedelacruz.contactmanagement.model.entity.BaseEntity;
import com.dmedelacruz.contactmanagement.model.entity.Person;

public interface ContactManagementService<T extends BaseEntity, D extends BaseDto> {

    T addRecord(Person person, D record);
    D updateRecord(String id, D record);
    void deleteRecord(String id);

}
