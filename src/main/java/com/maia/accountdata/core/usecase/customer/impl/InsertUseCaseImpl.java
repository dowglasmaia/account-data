package com.maia.accountdata.core.usecase.customer.impl;

import com.maia.accountdata.core.dataprovider.FindAddressByZipCode;
import com.maia.accountdata.core.dataprovider.customer.InsertCustomer;
import com.maia.accountdata.core.domain.Customer;
import com.maia.accountdata.core.usecase.customer.InsertUseCase;

public class InsertUseCaseImpl implements InsertUseCase {

    private final FindAddressByZipCode findAddressByZipCode;
    private final InsertCustomer insertCustomer;

    public InsertUseCaseImpl(
            FindAddressByZipCode findAddressByZipCode,
            InsertCustomer insertCustomer) {
        this.findAddressByZipCode = findAddressByZipCode;
        this.insertCustomer = insertCustomer;
    }

    @Override
    public Customer insert(Customer customer, String zipCode) {
        var address = findAddressByZipCode.find(zipCode).orElseThrow(
                ()-> new RuntimeException("Address not found.")
        );

        customer.setAddress(address);
       return insertCustomer.insert(customer);
    }

}
