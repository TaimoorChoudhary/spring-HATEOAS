package com.taimoor.spring.hateoas.service;

import com.taimoor.spring.hateoas.dto.DoctorDto;
import com.taimoor.spring.hateoas.mapper.DoctorMapper;
import com.taimoor.spring.hateoas.model.Doctor;
import com.taimoor.spring.hateoas.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Taimoor Choudhary
 */
@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    public Doctor getDoctor(int id){

        return DoctorMapper.INSTANCE.toModel(doctorRepository.getDoctorById(id));
    }

    public Doctor getDoctorWithPatients(int id){

        return DoctorMapper.INSTANCE.toModel(doctorRepository.getDoctorByIdWithPatients(id));
    }

    public List<Doctor> getDoctors(){

        List<DoctorDto> doctorDtoList = doctorRepository.getDoctors();

        return doctorDtoList.stream()
                .map(DoctorMapper.INSTANCE::toModel)
                .collect(Collectors.toList());
    }

    public List<Doctor> getDoctorsWithPatients(){

        List<DoctorDto> doctorDtoList = doctorRepository.getDoctorsWithPatients();

        return doctorDtoList.stream()
                .map(DoctorMapper.INSTANCE::toModel)
                .collect(Collectors.toList());
    }
}
