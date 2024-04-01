package com.maia.accountdata.core.usecase.customer.impl;

import com.maia.accountdata.core.dataprovider.customer.DeleteCustomer;
import com.maia.accountdata.core.usecase.customer.DeleteUseCase;

public class DeleteUseCaseImpl implements DeleteUseCase {

    private final DeleteCustomer deleteCustomer;

    public DeleteUseCaseImpl(DeleteCustomer deleteCustomer) {
        this.deleteCustomer = deleteCustomer;
    }

    @Override
    public void delete(String id) {
        deleteCustomer.delete(id);
    }
}
