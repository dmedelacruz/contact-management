package com.dmedelacruz.contactmanagement.service;

import com.dmedelacruz.contactmanagement.mapper.CommunicationMapper;
import com.dmedelacruz.contactmanagement.model.dto.CommunicationDto;
import com.dmedelacruz.contactmanagement.model.entity.Communication;
import com.dmedelacruz.contactmanagement.model.entity.Person;
import com.dmedelacruz.contactmanagement.repository.CommunicationRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class CommunicationService implements ContactManagementService<Communication, CommunicationDto>{

    private static final String COMMUNICATION_NOT_FOUND = "Communication Record with the given ID not found";

    private final CommunicationRepository communicationRepository;
    private final CommunicationMapper communicationMapper;


    @Override
    public Communication addRecord(Person person, CommunicationDto record) {
        val communication = communicationMapper.map(record);
        communication.setPerson(person);
        return communicationRepository.save(communication);
    }

    @Override
    public CommunicationDto updateRecord(String id, CommunicationDto updateCommunication) {
        var communication = communicationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(COMMUNICATION_NOT_FOUND));

        if(!StringUtils.isBlank(updateCommunication.getType()) && updateCommunication.getType().equals(communication.getType())) {
            communication.setType(updateCommunication.getType());
        }

        if(!StringUtils.isBlank(updateCommunication.getValue()) && !updateCommunication.getValue().equals(communication.getValue())) {
            communication.setValue(updateCommunication.getValue());
        }

        if(updateCommunication.getPreferred() != null && !updateCommunication.getPreferred().equals(communication.getPreferred())) {
            communication.setPreferred(updateCommunication.getPreferred());
        }

        val updatedCommunication = communicationRepository.save(communication);
        return communicationMapper.map(updatedCommunication);
    }

    @Override
    public void deleteRecord(String id) {
        communicationRepository.findById(id).ifPresentOrElse(
                (communication) -> communicationRepository.delete(communication),
                () -> { throw new IllegalArgumentException(COMMUNICATION_NOT_FOUND); }
        );
    }
}
