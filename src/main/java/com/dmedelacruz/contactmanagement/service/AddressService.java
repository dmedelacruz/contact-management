package com.dmedelacruz.contactmanagement.service;

import com.dmedelacruz.contactmanagement.mapper.AddressMapper;
import com.dmedelacruz.contactmanagement.model.dto.AddressDto;
import com.dmedelacruz.contactmanagement.model.entity.Address;
import com.dmedelacruz.contactmanagement.model.entity.Person;
import com.dmedelacruz.contactmanagement.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class AddressService implements ContactManagementService<Address, AddressDto> {

    private static final String ADDRESS_NOT_FOUND = "Address Record with the given ID not found";

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Override
    public Address addRecord(Person person, AddressDto record) {
        val address = addressMapper.map(record);
        address.setPerson(person);
        return addressRepository.save(address);
    }

    @Override
    public AddressDto updateRecord(String id, AddressDto updateAddress) {

        var address = addressRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(ADDRESS_NOT_FOUND));

        if(!StringUtils.isBlank(updateAddress.getType()) && !updateAddress.getType().equals(address.getType())) {
            address.setType(updateAddress.getType());
        }

        if(updateAddress.getNumber() != null && !updateAddress.getNumber().equals(address.getNumber())) {
            address.setNumber(updateAddress.getNumber());
        }

        if(!StringUtils.isBlank(updateAddress.getStreet()) && !updateAddress.getStreet().equals(address.getStreet())) {
            address.setStreet(updateAddress.getStreet());
        }

        if(!StringUtils.isBlank(updateAddress.getUnit()) && !updateAddress.getUnit().equals(address.getUnit())) {
            address.setUnit(updateAddress.getUnit());
        }

        if(!StringUtils.isBlank(updateAddress.getCity()) && !updateAddress.getCity().equals(address.getCity())) {
            address.setCity(updateAddress.getCity());
        }

        if(!StringUtils.isBlank(updateAddress.getState()) && !updateAddress.getState().equals(address.getState())) {
            address.setState(updateAddress.getState());
        }

        if(updateAddress.getZipCode() != null && !updateAddress.getZipCode().equals(address.getZipCode())) {
            address.setZipCode(updateAddress.getZipCode());
        }

        val updatedAddress = addressRepository.save(address);
        return addressMapper.map(updatedAddress);

    }

    @Override
    public void deleteRecord(String id) {
        addressRepository.findById(id).ifPresentOrElse(
                (address) -> addressRepository.delete(address),
                () -> { throw new IllegalArgumentException(ADDRESS_NOT_FOUND); }
        );
    }
}
