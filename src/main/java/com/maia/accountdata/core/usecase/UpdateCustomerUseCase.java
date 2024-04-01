package com.maia.accountdata.core.usecase;

import com.maia.accountdata.core.domain.Customer;

public interface UpdateCustomerUseCase {

    Customer insert(Customer customer, String zipCode);
}
