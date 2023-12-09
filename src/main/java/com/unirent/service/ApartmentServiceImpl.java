package com.unirent.service;

import com.unirent.repository.ApartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApartmentServiceImpl implements ApartmentService {

    private final ApartmentRepository apartmentRepository;

    @Override
    public List<String> findDistinctCities() {
        return apartmentRepository.findDistinctCities();
    }
}
