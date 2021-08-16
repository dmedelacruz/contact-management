package com.dmedelacruz.contactmanagement.mapper;

import com.dmedelacruz.contactmanagement.model.dto.AddressDto;
import com.dmedelacruz.contactmanagement.model.entity.Address;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressDto map(Address address);

    List<AddressDto> mapAddressList(List<Address> addressList);

    Address map(AddressDto addressDto);

    List<Address> mapAddressListDto(List<AddressDto> addressDtoList);

}
