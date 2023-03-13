package com.shchukinmanag.vladimir.parameters.repositories;

import com.shchukinmanag.vladimir.parameters.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository <Country, Integer> {
}
