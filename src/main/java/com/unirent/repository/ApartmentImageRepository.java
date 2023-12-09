package com.unirent.repository;

import com.unirent.entity.ApartmentImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "apartment-images", path = "apartment-images")
public interface ApartmentImageRepository extends JpaRepository<ApartmentImage, Long> {

    @RestResource(path = "findByApartmentId")
    List<ApartmentImage> findByApartment_Id(Long id);
}
