package com.maia.accountdata.core.usecase.customer;

import com.maia.accountdata.core.domain.Customer;

public interface UpdateUseCase {

    Customer update(Customer customer, String zipCode, String id);
}
