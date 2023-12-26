package com.unirent.service;

import com.unirent.entity.Customer;
import com.unirent.entity.Interest;
import com.unirent.entity.LodgerInterest;
import com.unirent.repository.CustomerRepository;
import com.unirent.repository.InterestRepository;
import com.unirent.repository.LodgerInterestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTest {

    @MockBean
    private CustomerRepository customerRepository;

    @MockBean
    private LodgerInterestRepository lodgerInterestRepository;

    @MockBean
    private InterestRepository interestRepository;

    @Autowired
    private CustomerService customerService;

    @Test
    void findAllLodgerAndInterestsTest() {
        Customer lodger1 = new Customer();
        lodger1.setId(1L);
        lodger1.setRole("lodger");

        Customer lodger2 = new Customer();
        lodger2.setId(2L);
        lodger2.setRole("lodger");

        Interest interest1 = new Interest();
        interest1.setDescription("comedy");

        Interest interest2 = new Interest();
        interest2.setDescription("fantasy");

        LodgerInterest lodgerInterest1 = new LodgerInterest();
        lodgerInterest1.setId(1L);
        lodgerInterest1.setLodger(lodger1);
        lodgerInterest1.setInterest(interest1);

        LodgerInterest lodgerInterest2 = new LodgerInterest();
        lodgerInterest2.setId(2L);
        lodgerInterest2.setLodger(lodger1);
        lodgerInterest2.setInterest(interest2);

        when(customerRepository.findByRole("lodger")).thenReturn(Arrays.asList(lodger1, lodger2));
        when(lodgerInterestRepository.findAllByLodger_Id(lodger1.getId())).thenReturn(Arrays.asList(lodgerInterest1, lodgerInterest2));
        when(interestRepository.findById(lodgerInterest1.getId())).thenReturn(java.util.Optional.of(interest1));
        when(interestRepository.findById(lodgerInterest2.getId())).thenReturn(java.util.Optional.of(interest2));

        String expected = "1:comedy,fantasy\n2:";
        assertEquals(expected, customerService.findAllLodgerAndInterests());
    }
}
