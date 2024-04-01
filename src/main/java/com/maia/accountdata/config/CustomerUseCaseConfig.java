package com.maia.accountdata.config;

import com.maia.accountdata.core.dataprovider.FindAddressByZipCode;
import com.maia.accountdata.core.dataprovider.FindCustomerById;
import com.maia.accountdata.core.dataprovider.InsertCustomer;
import com.maia.accountdata.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import com.maia.accountdata.core.usecase.impl.InsertCustomerUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerUseCaseConfig {

    @Bean
    public InsertCustomerUseCaseImpl insertCustomerUseCase(
            FindAddressByZipCode findAddressByZipCode,
            InsertCustomer insertCustomer
    ) {
        return new InsertCustomerUseCaseImpl(findAddressByZipCode, insertCustomer);
    }

    @Bean
    public FindCustomerByIdUseCaseImpl findCustomerByIdUseCase(
            FindCustomerById findCustomerById
    ) {
        return new FindCustomerByIdUseCaseImpl(findCustomerById);
    }

}
