package com.taimoor.spring.hateoas.repository;

import com.taimoor.spring.hateoas.dto.DoctorDto;

import java.util.List;

/**
 * @author Taimoor Choudhary
 */
public interface DoctorRepository {

    DoctorDto getDoctorById(int id);
    DoctorDto getDoctorByIdWithPatients(int id);
    List<DoctorDto> getDoctors();
    List<DoctorDto> getDoctorsWithPatients();
}
