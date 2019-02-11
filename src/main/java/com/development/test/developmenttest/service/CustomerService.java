package com.development.test.developmenttest.service;

import com.development.test.developmenttest.domain.Customer;
import com.development.test.developmenttest.enums.RiscType;
import com.development.test.developmenttest.repository.CustomerRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Random;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public void save(String id, Customer customer) {

        if(StringUtils.isEmpty(id)){
            Random random = new Random();
            id = String.valueOf(random.nextInt(1000));
        }

        customer.setId(id);
        this.rateChange(customer);

        customerRepository.save(customer);
    }

    public Iterable<Customer> list(){
        return customerRepository.findAll();
    }

    public Optional<Customer> get(final String id){
        return customerRepository.findById(id);
    }

    private void rateChange(Customer customer){

        if(RiscType.A.name().equalsIgnoreCase(customer.getRisc())){
            customer.setRate(0);
        } else if (RiscType.B.name().equalsIgnoreCase(customer.getRisc())){
            customer.setRate(10);
        } else {
            customer.setRate(20);
        }

    }


}
