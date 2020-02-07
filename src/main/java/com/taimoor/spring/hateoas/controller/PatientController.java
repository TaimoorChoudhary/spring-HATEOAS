package com.taimoor.spring.hateoas.controller;

import com.taimoor.spring.hateoas.model.Patient;
import com.taimoor.spring.hateoas.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * @author Taimoor Choudhary
 */
@RestController
@RequestMapping(value = "/patients")
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping(value = "/{id}")
    public EntityModel<Patient> getPatientById(@PathVariable int id){

        Patient patient = patientService.getPatient(id);

        Link link = linkTo(methodOn(PatientController.class).getPatientById(id)).withSelfRel();

        return new EntityModel<>(patient, link);
    }
}
