package com.taimoor.spring.hateoas.mapper;

import com.taimoor.spring.hateoas.dto.PatientDto;
import com.taimoor.spring.hateoas.model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Taimoor Choudhary
 */
@Mapper
public interface PatientMapper {

    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    Patient toModel(PatientDto patientDto);
    PatientDto toDto(Patient patient);
}
