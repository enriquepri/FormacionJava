package com.bosonit.springdata.studentdetails.repository;

import com.bosonit.springdata.studentdetails.domain.StudentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDetailsRepository extends JpaRepository<StudentDetails, Integer> {
}
