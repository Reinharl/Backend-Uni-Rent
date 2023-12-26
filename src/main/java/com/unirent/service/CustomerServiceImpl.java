package com.unirent.service;

import com.unirent.entity.Customer;
import com.unirent.entity.LodgerInterest;
import com.unirent.repository.CustomerRepository;
import com.unirent.repository.LodgerInterestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final LodgerInterestRepository lodgerInterestRepository;

    @Override
    public String findAllLodgerAndInterests() {
        List<Customer> lodgers = customerRepository.findByRole("lodger");

        return lodgers.stream().map(lodger -> {
            List<LodgerInterest> lodgerInterests = lodgerInterestRepository.findAllByLodger_Id(lodger.getId());

            String interests = lodgerInterests.stream()
                    .map(lodgerInterest -> lodgerInterest.getInterest().getDescription())
                    .collect(Collectors.joining(","));

            return lodger.getId() + ":" + interests;
        }).collect(Collectors.joining("\n"));
    }

    @Override
    public Long findFirstNumberInResponse(String response) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(response);

        if (matcher.find()) {
            return Long.parseLong(matcher.group());
        } else {
            throw new RuntimeException("No numbers found in string");
        }
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }
}
