package com.maia.accountdata.core.usecase;

import com.maia.accountdata.core.domain.Customer;

public interface InsertCustomerUseCase {
    void insert(Customer customer, String zipCode);
}
