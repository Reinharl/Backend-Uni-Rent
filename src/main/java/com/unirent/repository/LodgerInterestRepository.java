package com.unirent.repository;

import com.unirent.entity.LodgerInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "lodger-interests", path = "lodger-interests")
public interface LodgerInterestRepository extends JpaRepository<LodgerInterest, Long> {

    @RestResource(exported = false)
    List<LodgerInterest> findAllByLodger_Id(Long id);
}
