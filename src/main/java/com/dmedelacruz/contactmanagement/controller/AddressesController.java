package com.dmedelacruz.contactmanagement.controller;

import com.dmedelacruz.contactmanagement.model.dto.AddressDto;
import com.dmedelacruz.contactmanagement.model.entity.Address;
import com.dmedelacruz.contactmanagement.service.ServiceFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AddressesController {

    private final ServiceFactory serviceFactory;

    @PutMapping("/{id}")
    public AddressDto updateAddressInfo(@PathVariable("id") String id, @RequestBody AddressDto addressDto) {
        return (AddressDto) serviceFactory.getService(Address.class).updateRecord(id, addressDto);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable("id") String id) {
        serviceFactory.getService(Address.class).deleteRecord(id);
    }

}
