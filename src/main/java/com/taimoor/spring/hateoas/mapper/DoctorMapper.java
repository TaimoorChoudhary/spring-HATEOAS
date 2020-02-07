package com.taimoor.spring.hateoas.mapper;

import com.taimoor.spring.hateoas.dto.DoctorDto;
import com.taimoor.spring.hateoas.model.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Taimoor Choudhary
 */
@Mapper(uses = {PatientMapper.class})
public interface DoctorMapper {

    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    @Mapping(source = "doctorDto.patientDtoList", target = "patientList")
    Doctor toModel(DoctorDto doctorDto);

    @Mapping(source = "doctor.patientList", target = "patientDtoList")
    DoctorDto toDto(Doctor doctor);
}
