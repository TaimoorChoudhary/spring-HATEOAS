package com.taimoor.spring.hateoas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

/**
 * @author Taimoor Choudhary
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Doctor extends RepresentationModel<Doctor> {

    private int id;
    private String name;
    private String speciality;
    private List<Patient> patientList;
}
