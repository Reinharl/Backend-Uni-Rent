package com.unirent.repository;

import com.unirent.entity.Apartment_image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface Apartment_imageRepository extends JpaRepository<Apartment_image, Long> {
}
