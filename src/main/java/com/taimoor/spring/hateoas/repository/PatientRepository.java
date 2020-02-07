package com.taimoor.spring.hateoas.repository;

import com.taimoor.spring.hateoas.dto.PatientDto;

/**
 * @author Taimoor Choudhary
 */
public interface PatientRepository {

    PatientDto getPatientById(int id);
}
