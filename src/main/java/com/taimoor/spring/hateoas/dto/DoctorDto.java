package com.taimoor.spring.hateoas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Taimoor Choudhary
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {

    private int id;
    private String name;
    private String speciality;
    private List<PatientDto> patientDtoList;
}
