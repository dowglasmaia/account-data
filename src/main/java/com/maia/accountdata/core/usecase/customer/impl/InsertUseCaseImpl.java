package com.maia.accountdata.core.usecase.customer.impl;

import com.maia.accountdata.core.dataprovider.FindAddressByZipCode;
import com.maia.accountdata.core.dataprovider.customer.InsertCustomer;
import com.maia.accountdata.core.dataprovider.customer.SendCpfForValidation;
import com.maia.accountdata.core.domain.Customer;
import com.maia.accountdata.core.usecase.customer.InsertUseCase;

public class InsertUseCaseImpl implements InsertUseCase {

    private final FindAddressByZipCode findAddressByZipCode;
    private final InsertCustomer insertCustomer;
    private final SendCpfForValidation sendCpfForValidation;

    public InsertUseCaseImpl(
            FindAddressByZipCode findAddressByZipCode,
            InsertCustomer insertCustomer,
            SendCpfForValidation sendCpfForValidation) {
        this.findAddressByZipCode = findAddressByZipCode;
        this.insertCustomer = insertCustomer;
        this.sendCpfForValidation = sendCpfForValidation;
    }

    @Override
    public Customer insert(Customer customer, String zipCode) {
        var address = findAddressByZipCode.find(zipCode).orElseThrow(
                () -> new RuntimeException("Address not found.")
        );

        customer.setAddress(address);
        var customerInserted = insertCustomer.insert(customer);
        sendCpfForValidation.send(customer.getCpf());

        return customerInserted;
    }

}
