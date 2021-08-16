package com.dmedelacruz.contactmanagement.service;

import com.dmedelacruz.contactmanagement.model.entity.Address;
import com.dmedelacruz.contactmanagement.model.entity.BaseEntity;
import com.dmedelacruz.contactmanagement.model.entity.Communication;
import com.dmedelacruz.contactmanagement.model.entity.Person;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ServiceFactory {

    private final AddressService addressService;
    private final CommunicationService communicationService;

    @PostConstruct
    void init() {
        serviceMap.put(Address.class, addressService);
        serviceMap.put(Communication.class, communicationService);
    }

    private Map<Class, ContactManagementService> serviceMap = new HashMap<>();

    public <T extends BaseEntity> ContactManagementService getService(Class<T> entityClass) {
        final val contactManagementService = serviceMap.get(entityClass);
        if(contactManagementService == null) {
            throw new IllegalArgumentException("No Service for the given class found");
        } else {
            return contactManagementService;
        }
    }

}
