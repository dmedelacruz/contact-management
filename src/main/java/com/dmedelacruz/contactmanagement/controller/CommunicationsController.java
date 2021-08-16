package com.dmedelacruz.contactmanagement.controller;

import com.dmedelacruz.contactmanagement.model.dto.CommunicationDto;
import com.dmedelacruz.contactmanagement.model.entity.Communication;
import com.dmedelacruz.contactmanagement.service.ServiceFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/communications")
@RequiredArgsConstructor
public class CommunicationsController {

    private final ServiceFactory serviceFactory;

    @PutMapping("/{id}")
    public CommunicationDto updateCommunicationInfo(@PathVariable("id") String id, @RequestBody CommunicationDto communicationDto) {
        return (CommunicationDto) serviceFactory.getService(Communication.class).updateRecord(id, communicationDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCommunication(@PathVariable("id") String id) {
        serviceFactory.getService(Communication.class).deleteRecord(id);
    }

}
