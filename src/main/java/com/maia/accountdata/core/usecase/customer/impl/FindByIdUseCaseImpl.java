package com.maia.accountdata.core.usecase.customer.impl;

import com.maia.accountdata.core.dataprovider.customer.FindByIdCustomer;
import com.maia.accountdata.core.domain.Customer;
import com.maia.accountdata.core.exception.NotFoundException;
import com.maia.accountdata.core.usecase.customer.FindByIdUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestClientException;

public class FindByIdUseCaseImpl implements FindByIdUseCase {

    private final FindByIdCustomer findByIdCustomer;

    public FindByIdUseCaseImpl(FindByIdCustomer findByIdCustomer) {
        this.findByIdCustomer = findByIdCustomer;
    }

    @Override
    public Customer find(String id) {
        return findByIdCustomer.find(id).orElseThrow(()-> new NotFoundException("Customer not found!", HttpStatus.FOUND));
    }
}
