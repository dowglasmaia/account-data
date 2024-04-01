package com.maia.accountdata.core.usecase.customer;

import com.maia.accountdata.core.domain.Customer;

public interface FindByIdUseCase {

    Customer find(final String Id);
}
