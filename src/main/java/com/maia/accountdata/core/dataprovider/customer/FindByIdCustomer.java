package com.maia.accountdata.core.dataprovider.customer;

import com.maia.accountdata.core.domain.Customer;

import java.util.Optional;

public interface FindByIdCustomer {
    Optional<Customer> find(final String id);
}
