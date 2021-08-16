package com.dmedelacruz.contactmanagement.mapper;

import com.dmedelacruz.contactmanagement.model.dto.CommunicationDto;
import com.dmedelacruz.contactmanagement.model.entity.Communication;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommunicationMapper {

    CommunicationDto map(Communication communication);

    List<CommunicationDto> mapCommunicationList(List<Communication> communicationList);

    @Mapping(source = "preferred", target = "preferred", defaultValue = "false")
    Communication map(CommunicationDto communicationDto);

    List<Communication> mapCommunicationListDto(List<CommunicationDto> communicationDtoList);

}
