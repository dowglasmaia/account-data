package com.maia.accountdata.core.usecase;

import com.maia.accountdata.core.domain.Customer;

public interface FindCustomerByIdUseCase {

    Customer find(final String Id);
}
