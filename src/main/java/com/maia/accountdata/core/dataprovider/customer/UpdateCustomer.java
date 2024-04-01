package com.maia.accountdata.core.dataprovider.customer;

import com.maia.accountdata.core.domain.Customer;

public interface UpdateCustomer {

    Customer update(Customer customer,String id);
}
