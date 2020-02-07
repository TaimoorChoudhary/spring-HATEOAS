package com.taimoor.spring.hateoas.repository;

import com.taimoor.spring.hateoas.dto.DoctorDto;
import com.taimoor.spring.hateoas.dto.PatientDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Taimoor Choudhary
 */
@Component
public class DoctorRepositoryEmbedded implements DoctorRepository {

    @Override
    public DoctorDto getDoctorById(int id) {

        return createDoctor(id, "Dr. Sanders", "General",null);
    }

    @Override
    public DoctorDto getDoctorByIdWithPatients(int id) {

        List<PatientDto> patientDtoList = new ArrayList<>();

        patientDtoList.add(createPatient(1, "J. Smalling"));
        patientDtoList.add(createPatient(2, "Samantha Williams"));

        return createDoctor(id, "Dr. Sanders", "General", patientDtoList);
    }

    @Override
    public List<DoctorDto> getDoctors() {

        List<DoctorDto> doctorDtoList = new ArrayList<>();

        doctorDtoList.add(createDoctor(1, "Dr. Sanders", "General",null));
        doctorDtoList.add(createDoctor(2, "Dr. Goldberg", "General",null));

        return doctorDtoList;
    }

    @Override
    public List<DoctorDto> getDoctorsWithPatients() {

        List<PatientDto> patientDtoList = new ArrayList<>();

        patientDtoList.add(createPatient(1, "J. Smalling"));
        patientDtoList.add(createPatient(2, "Samantha Williams"));
        patientDtoList.add(createPatient(3, "Alfred Tim"));
        patientDtoList.add(createPatient(4, "K. Oliver"));

        List<DoctorDto> doctorDtoList = new ArrayList<>();

        doctorDtoList.add(createDoctor(1, "Dr. Sanders", "General", patientDtoList.subList(0, 2)));
        doctorDtoList.add(createDoctor(2, "Dr. Goldberg", "General", patientDtoList.subList(2, 4)));

        return doctorDtoList;
    }

    private DoctorDto createDoctor(int id, String name, String speciality, List<PatientDto> patientDtos){

        return DoctorDto.builder()
                .id(id)
                .name(name)
                .speciality(speciality)
                .patientDtoList(patientDtos)
                .build();
    }

    private PatientDto createPatient(int id, String name){

        return PatientDto.builder()
                .id(id)
                .name(name)
                .build();
    }
}
