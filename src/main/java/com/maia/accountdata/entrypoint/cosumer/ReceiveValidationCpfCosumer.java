package com.maia.accountdata.entrypoint.cosumer;

import com.maia.accountdata.core.usecase.customer.UpdateUseCase;
import com.maia.accountdata.entrypoint.cosumer.mapper.CustomerMessageMapper;
import com.maia.accountdata.entrypoint.cosumer.message.CustomerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidationCpfCosumer {

    @Autowired
    private UpdateUseCase updateUseCase;

    @Autowired
    private CustomerMessageMapper mapper;

    @KafkaListener(topics = "tp-cpf-validated",groupId = "maia")
    public void receive(CustomerMessage customerMessage){
        var customer = mapper.toCustomer(customerMessage);
        updateUseCase.update(customer,customer.getAddress().getZip(),customer.getId());

    }
}
