package com.taimoor.spring.hateoas.repository;

import com.taimoor.spring.hateoas.dto.PatientDto;
import org.springframework.stereotype.Component;

/**
 * @author Taimoor Choudhary
 */
@Component
public class PatientRepositoryEmbedded implements PatientRepository {

    @Override
    public PatientDto getPatientById(int id) {
        return createPatient(id, "Samuel Bradford");
    }

    private PatientDto createPatient(int id, String name){

        return PatientDto.builder()
                .id(id)
                .name(name)
                .build();
    }
}
