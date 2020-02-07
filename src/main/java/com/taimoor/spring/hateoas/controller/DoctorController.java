package com.taimoor.spring.hateoas.controller;

import com.taimoor.spring.hateoas.model.Doctor;
import com.taimoor.spring.hateoas.model.Patient;
import com.taimoor.spring.hateoas.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * @author Taimoor Choudhary
 */
@RestController
@RequestMapping(value = "/doctors")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @GetMapping(value = "/{id}")
    public EntityModel<Doctor> getDoctorById(@PathVariable int id){

        Doctor doctor = doctorService.getDoctorWithPatients(id);

        for (final Patient patient : doctor.getPatientList()) {
            Link selfLink = linkTo(methodOn(PatientController.class).getPatientById(patient.getId())).withSelfRel();
            patient.add(selfLink);
        }

        doctor.add(linkTo(methodOn(DoctorController.class).getDoctorById(id)).withSelfRel());
        doctor.add(linkTo(methodOn(DoctorController.class).getDoctors()).withSelfRel());
        doctor.add(linkTo(methodOn(DoctorController.class).getDoctorPatients(doctor.getId())).withRel("patientList"));

        return new EntityModel<>(doctor);
    }

    @GetMapping
    public CollectionModel<Doctor> getDoctors(){

        List<Doctor> doctors = doctorService.getDoctorsWithPatients();

        for(final Doctor doctor : doctors) {

            doctor.add(linkTo(methodOn(DoctorController.class).getDoctorById(doctor.getId())).withSelfRel());
            doctor.add(linkTo(methodOn(DoctorController.class).getDoctorPatients(doctor.getId())).withRel("patientList"));

            for (final Patient patient : doctor.getPatientList()) {
                Link selfLink = linkTo(methodOn(PatientController.class).getPatientById(patient.getId())).withSelfRel();
                patient.add(selfLink);
            }
        }

        Link link = linkTo(methodOn(DoctorController.class).getDoctors()).withSelfRel();

        return new CollectionModel<>(doctors, link);
    }

    @GetMapping(value = "/{id}/patients")
    public CollectionModel<Patient> getDoctorPatients(@PathVariable int id) {

        Doctor doctor = doctorService.getDoctorWithPatients(id);

        for (final Patient patient : doctor.getPatientList()) {
            Link selfLink = linkTo(methodOn(PatientController.class).getPatientById(patient.getId())).withSelfRel();
            patient.add(selfLink);
        }

        Link link = linkTo(methodOn(DoctorController.class).getDoctorPatients(id)).withSelfRel();

        return new CollectionModel<>(doctor.getPatientList(), link);
    }
}
