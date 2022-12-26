package com.example.api.repository;

import com.example.api.domain.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
@DisplayName("Tests for Customer Repository")
class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    @DisplayName("Save persists Customer when successful")
    void save_PersistCustomer_WhenSuccessful(){
        Customer customerToBeSaved = createCustomer();
        Customer customerSaved = this.customerRepository.save(customerToBeSaved);
        Assertions.assertThat(customerSaved).isNotNull();
        Assertions.assertThat(customerSaved.getId()).isNotNull();
        Assertions.assertThat(customerSaved.getName()).isEqualTo(customerToBeSaved.getName());
    }

    @Test
    @DisplayName("Save updates Customer when successful")
    void save_UpdateCustomer_WhenSuccessful(){
        Customer customerToBeSaved = createCustomer();
        Customer customerSaved = this.customerRepository.save(customerToBeSaved);
        customerSaved.setName("Emily Xavier");
        Customer customerUpdated = this.customerRepository.save(customerSaved);
        Assertions.assertThat(customerUpdated).isNotNull();
        Assertions.assertThat(customerUpdated.getId()).isNotNull();
        Assertions.assertThat(customerUpdated.getName()).isEqualTo(customerSaved.getName());
    }

    @Test
    @DisplayName("Delete removes Customer when successful")
    void delete_RemovesCustomer_WhenSuccessful(){
        Customer customerToBeSaved = createCustomer();
        Customer customerSaved = this.customerRepository.save(customerToBeSaved);
        this.customerRepository.delete(customerSaved);
        Optional<Customer> customerOptional = this.customerRepository.findById(customerSaved.getId());
        Assertions.assertThat(customerOptional.isPresent()).isFalse();

    }

    private Customer createCustomer(){
        return Customer.builder()
                .name("Emily")
                .email("emily@gmail.com")
                .build();
    }

}