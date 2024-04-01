package com.maia.accountdata.core.usecase.impl;

import com.maia.accountdata.core.dataprovider.FindAddressByZipCode;
import com.maia.accountdata.core.dataprovider.UpdateCustomer;
import com.maia.accountdata.core.domain.Customer;
import com.maia.accountdata.core.usecase.UpdateCustomerUseCase;

public class UpdateCustomerUseCaseImpl implements UpdateCustomerUseCase {

    private final FindAddressByZipCode findAddressByZipCode;
    private final UpdateCustomer updateCustomer;

    public UpdateCustomerUseCaseImpl(FindAddressByZipCode findAddressByZipCode, UpdateCustomer updateCustomer) {
        this.findAddressByZipCode = findAddressByZipCode;
        this.updateCustomer = updateCustomer;
    }

    @Override
    public Customer insert(Customer customer, String zipCode) {
        var address = findAddressByZipCode.find(zipCode);

        customer.setAddress(address);
        return updateCustomer.update(customer);
    }
}
