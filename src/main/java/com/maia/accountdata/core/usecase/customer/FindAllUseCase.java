package com.maia.accountdata.core.usecase.customer;

import com.maia.accountdata.core.domain.Customer;

import java.util.Set;

public interface FindAllUseCase {

    Set<Customer> find();
}
