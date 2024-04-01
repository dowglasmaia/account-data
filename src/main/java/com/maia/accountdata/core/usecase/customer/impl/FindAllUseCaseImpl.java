package com.maia.accountdata.core.usecase.customer.impl;

import com.maia.accountdata.core.dataprovider.customer.FindAllCustomer;
import com.maia.accountdata.core.domain.Customer;
import com.maia.accountdata.core.usecase.customer.FindAllUseCase;

import java.util.Set;

public class FindAllUseCaseImpl implements FindAllUseCase {

    private final FindAllCustomer findAllCustomer;

    public FindAllUseCaseImpl(FindAllCustomer findAllCustomer) {
        this.findAllCustomer = findAllCustomer;
    }

    @Override
    public Set<Customer> find() {
        return findAllCustomer.find();
    }
}
