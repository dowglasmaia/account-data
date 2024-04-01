package com.maia.accountdata.core.dataprovider;

import com.maia.accountdata.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerById {
    Optional<Customer> find(final String id);
}
