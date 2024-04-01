package com.maia.accountdata.core.usecase.customer.impl;

import com.maia.accountdata.core.dataprovider.FindAddressByZipCode;
import com.maia.accountdata.core.dataprovider.customer.UpdateCustomer;
import com.maia.accountdata.core.domain.Customer;
import com.maia.accountdata.core.usecase.customer.UpdateUseCase;

public class UpdateUseCaseImpl implements UpdateUseCase {

    private final FindAddressByZipCode findAddressByZipCode;
    private final UpdateCustomer updateCustomer;

    public UpdateUseCaseImpl(FindAddressByZipCode findAddressByZipCode, UpdateCustomer updateCustomer) {
        this.findAddressByZipCode = findAddressByZipCode;
        this.updateCustomer = updateCustomer;
    }

    @Override
    public Customer update(Customer customer, String zipCode, String id) {
        var address = findAddressByZipCode.find(zipCode).orElseThrow(
                ()-> new RuntimeException("Address not found.")
        );

        customer.setAddress(address);
        return updateCustomer.update(customer, id);
    }
}
