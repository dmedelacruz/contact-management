package com.dmedelacruz.contactmanagement.controller;

import com.dmedelacruz.contactmanagement.model.dto.AddressDto;
import com.dmedelacruz.contactmanagement.model.dto.CommunicationDto;
import com.dmedelacruz.contactmanagement.model.dto.Identification;
import com.dmedelacruz.contactmanagement.model.dto.PersonDto;
import com.dmedelacruz.contactmanagement.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonsController {

    private final PersonService personService;

    @GetMapping
    public List<PersonDto> getPeople() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public PersonDto findPersonById(@PathVariable("id") String id) {
        return personService.findPersonById(id);
    }

    @PostMapping
    public String savePerson(@RequestBody PersonDto personDto) {
        return personService.savePerson(personDto);
    }

    @PostMapping("/{id}/address")
    public PersonDto addPersonAddress(@PathVariable("id") String personId, @RequestBody AddressDto addressDto) {
        return personService.addAddress(personId, addressDto);
    }

    @PostMapping("/{id}/communications")
    public PersonDto addPersonCommunicationm(@PathVariable("id") String personId, @RequestBody CommunicationDto communicationDto) {
        return personService.addCommunication(personId, communicationDto);
    }

    @PutMapping("/{id}/identification")
    public PersonDto updatePersonIdentification(@PathVariable("id") String id, @RequestBody Identification identification) {
        return personService.updatePersonIdentification(id, identification);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable("id") String id) {
        personService.deletePerson(id);
    }

}
