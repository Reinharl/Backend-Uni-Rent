package com.unirent.repository;

import com.unirent.entity.LodgerInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "lodger-interests", path = "lodger-interests")
public interface LodgerInterestRepository extends JpaRepository<LodgerInterest, Long> {
}
