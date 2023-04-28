package com.bosonit.springdata.school.repository;

import com.bosonit.springdata.school.domain.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School,Integer> {
}
