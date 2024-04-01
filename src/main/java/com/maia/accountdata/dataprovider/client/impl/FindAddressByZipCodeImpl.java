package com.maia.accountdata.dataprovider.client.impl;

import com.maia.accountdata.core.dataprovider.FindAddressByZipCode;
import com.maia.accountdata.core.domain.Address;
import com.maia.accountdata.dataprovider.client.FindAddressByZipCodeClient;
import com.maia.accountdata.dataprovider.client.mapper.AddressResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindAddressByZipCodeImpl implements FindAddressByZipCode {
    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Optional<Address> find(String zipCode) {
        var addressResponse = findAddressByZipCodeClient.find(zipCode);
        return Optional.of(addressResponseMapper.toAddress(addressResponse));
    }
}

