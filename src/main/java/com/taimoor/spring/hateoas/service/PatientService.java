package com.taimoor.spring.hateoas.service;

import com.taimoor.spring.hateoas.mapper.PatientMapper;
import com.taimoor.spring.hateoas.model.Patient;
import com.taimoor.spring.hateoas.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Taimoor Choudhary
 */
@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public Patient getPatient(int id){

        return PatientMapper.INSTANCE.toModel(patientRepository.getPatientById(id));
    }
}
