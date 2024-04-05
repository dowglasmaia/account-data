package com.maia.accountdata.config.customer;

import com.maia.accountdata.core.dataprovider.FindAddressByZipCode;
import com.maia.accountdata.core.dataprovider.customer.*;
import com.maia.accountdata.core.usecase.customer.impl.*;
import com.maia.accountdata.dataprovider.client.impl.FindAddressByZipCodeImpl;
import com.maia.accountdata.dataprovider.customer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerUseCaseConfig {

    @Bean
    public InsertUseCaseImpl insertCustomerUseCase(
            FindAddressByZipCodeImpl findAddressByZipCode,
            InsertCustomerImpl insertCustomer,
            SendCpfForValidation sendCpfForValidation
    ) {
        return new InsertUseCaseImpl(findAddressByZipCode, insertCustomer,sendCpfForValidation);
    }

    @Bean
    public UpdateUseCaseImpl updateUseCase(
            FindAddressByZipCodeImpl findAddressByZipCode,
            UpdateCustomerImpl updateCustomer
    ) {
        return new UpdateUseCaseImpl(findAddressByZipCode, updateCustomer);
    }

    @Bean
    public FindByIdUseCaseImpl findCustomerByIdUseCase(
            FindByIdCustomerImpl findByIdCustomer
    ) {
        return new FindByIdUseCaseImpl(findByIdCustomer);
    }

    @Bean
    public FindAllUseCaseImpl findAllUseCase(
            FindAllCustomerImpl findAllCustomer
    ) {
        return new FindAllUseCaseImpl(findAllCustomer);
    }

    @Bean
    public DeleteUseCaseImpl deleteUseCase(
            DeleteCustomerImpl deleteCustomer
    ) {
        return new DeleteUseCaseImpl(deleteCustomer);
    }

}
