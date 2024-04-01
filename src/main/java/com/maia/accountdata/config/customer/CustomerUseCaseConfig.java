package com.maia.accountdata.config.customer;

import com.maia.accountdata.core.dataprovider.FindAddressByZipCode;
import com.maia.accountdata.core.dataprovider.customer.*;
import com.maia.accountdata.core.usecase.customer.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerUseCaseConfig {

    @Bean
    public InsertUseCaseImpl insertCustomerUseCase(
            FindAddressByZipCode findAddressByZipCode,
            InsertCustomer insertCustomer
    ) {
        return new InsertUseCaseImpl(findAddressByZipCode, insertCustomer);
    }

    @Bean
    public UpdateUseCaseImpl updateUseCase(
            FindAddressByZipCode findAddressByZipCode,
            UpdateCustomer updateCustomer
    ) {
        return new UpdateUseCaseImpl(findAddressByZipCode, updateCustomer);
    }

    @Bean
    public FindByIdUseCaseImpl findCustomerByIdUseCase(
            FindByIdCustomer findByIdCustomer
    ) {
        return new FindByIdUseCaseImpl(findByIdCustomer);
    }

    @Bean
    public FindAllUseCaseImpl findAllUseCase(
            FindAllCustomer findAllCustomer
    ) {
        return new FindAllUseCaseImpl(findAllCustomer);
    }

    @Bean
    public DeleteUseCaseImpl deleteUseCase(
            DeleteCustomer deleteCustomer
    ) {
        return new DeleteUseCaseImpl(deleteCustomer);
    }

}
