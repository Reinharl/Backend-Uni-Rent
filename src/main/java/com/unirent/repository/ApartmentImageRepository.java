package com.unirent.repository;

import com.unirent.entity.ApartmentImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "apartment-images", path = "apartment-images")
public interface ApartmentImageRepository extends JpaRepository<ApartmentImage, Long> {
}
