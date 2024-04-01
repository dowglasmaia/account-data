package com.maia.accountdata.core.usecase.customer;

import com.maia.accountdata.core.domain.Customer;

public interface InsertUseCase {
    Customer insert(Customer customer, String zipCode);
}
