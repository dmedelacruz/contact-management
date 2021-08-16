package com.dmedelacruz.contactmanagement.mapper;

import com.dmedelacruz.contactmanagement.model.dto.PersonDto;
import com.dmedelacruz.contactmanagement.model.entity.Person;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AddressMapper.class, CommunicationMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PersonMapper {

    @Mapping(source = "firstName", target = "identification.firstName")
    @Mapping(source = "lastName", target = "identification.lastName")
    @Mapping(source = "birthDate", target = "identification.birthDate", dateFormat = "MM/dd/yyyy")
    @Mapping(source = "gender", target = "identification.gender")
    @Mapping(source = "title", target = "identification.title")
    @Mapping(source = "addresses", target = "addressList")
    @Mapping(source = "communications", target = "communicationList")
    PersonDto map(Person person);

    @Mapping(target = "firstName", source = "identification.firstName")
    @Mapping(target = "lastName", source = "identification.lastName")
    @Mapping(target = "birthDate", source = "identification.birthDate", dateFormat = "MM/dd/yyyy")
    @Mapping(target = "gender", source = "identification.gender")
    @Mapping(target = "title", source = "identification.title")
    @Mapping(target = "addresses", source = "addressList")
    @Mapping(target = "communications", source = "communicationList")
    Person map(PersonDto personDto);

    List<PersonDto> mapPersonList(List<Person> personList);

    @AfterMapping
    default void afterToEntity(@MappingTarget Person person) {
        person.getAddresses().stream().forEach(address -> address.setPerson(person));
        person.getCommunications().stream().forEach(communication -> communication.setPerson(person));
    }
}
