package com.dmedelacruz.contactmanagement.service;

import com.dmedelacruz.contactmanagement.exception.ErrorMessage;
import com.dmedelacruz.contactmanagement.exception.PersonNotFoundException;
import com.dmedelacruz.contactmanagement.model.dto.AddressDto;
import com.dmedelacruz.contactmanagement.model.dto.CommunicationDto;
import com.dmedelacruz.contactmanagement.model.dto.Identification;
import com.dmedelacruz.contactmanagement.model.dto.PersonDto;
import com.dmedelacruz.contactmanagement.mapper.PersonMapper;
import com.dmedelacruz.contactmanagement.model.entity.Address;
import com.dmedelacruz.contactmanagement.model.entity.Communication;
import com.dmedelacruz.contactmanagement.model.entity.Gender;
import com.dmedelacruz.contactmanagement.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService  {

    private static final String PERSON_NOT_FOUND = "Person with the given ID not found";

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    private final ServiceFactory serviceFactory;

    public String savePerson(PersonDto personDto) {
        final val person = personMapper.map(personDto);
        return personRepository.save(person).getId();
    }

    public List<PersonDto> getAllPersons() {
        final val personList = personRepository.findAll();
        return personMapper.mapPersonList(personList);
    }

    public PersonDto findPersonById(String id) {
        val person = personRepository.findById(id).orElse(null);
        return personMapper.map(person);
    }

    public PersonDto updatePersonIdentification(String id, Identification identification) {

        var person = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(new ErrorMessage(new Date(), PERSON_NOT_FOUND)));

        if(!StringUtils.isBlank(identification.getFirstName()) && !person.getFirstName().equals(identification.getFirstName())){
            person.setFirstName(identification.getFirstName());
        }

        if(!StringUtils.isBlank(identification.getLastName()) && !person.getLastName().equals(identification.getLastName())) {
            person.setLastName(identification.getLastName());
        }

        if(!StringUtils.isBlank(identification.getGender()) && !person.getGender().equals(identification.getGender())) {
            person.setGender(Gender.valueOf(identification.getGender()));
        }

        if(!StringUtils.isBlank(identification.getTitle()) && !person.getTitle().equals(identification.getTitle())) {
            person.setTitle(identification.getTitle());
        }

        final val updatedPerson = personRepository.save(person);
        return personMapper.map(updatedPerson);

    }

    public void deletePerson(String id) {
        personRepository.findById(id).ifPresentOrElse(
                (person) -> personRepository.delete(person),
                () -> { throw new IllegalArgumentException(PERSON_NOT_FOUND); }
        );
    }

    public PersonDto addAddress(String personId, AddressDto addressDto) {
        val person = personRepository.findById(personId).orElseThrow(() -> new IllegalArgumentException(PERSON_NOT_FOUND));

        final val addressService = serviceFactory.getService(Address.class);
        final val address = addressService.addRecord(person, addressDto);

        return personMapper.map(((Address) address).getPerson());
    }

    public PersonDto addCommunication(String personId, CommunicationDto communicationDto) {
        val person = personRepository.findById(personId).orElseThrow(() -> new IllegalArgumentException(PERSON_NOT_FOUND));

        final val communicationService = serviceFactory.getService(Communication.class);
        final val communication = communicationService.addRecord(person, communicationDto);

        return personMapper.map(((Communication) communication).getPerson());
    }

}
