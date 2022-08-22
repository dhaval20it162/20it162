package in.ac.charusat.Patientmgmtsystem.controller;

import in.ac.charusat.Patientmgmtsystem.model.Patient;
import in.ac.charusat.patientmgmtsystem.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="https://app-dummy123.herokuapp.com")
public class PatientController {

    @Autowired
    patientRepository patientRepository;

    @GetMapping("/listPatients")
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Get the Patient information
    @GetMapping("/Patient/{id}")
    public Patient getPatient(@PathVariable Integer id) {
        return PatientRepository.findById(id).get();
    }

    // Delete the Patient
    @DeleteMapping("/Patient/{id}")
    public List<Patient> deletePatient(@PathVariable Integer id) {
        PatientRepository.delete(PatientRepository.findById(id).get());
        return PatientRepository.findAll();
    }

    // Add new Patient
    @PostMapping("/Patient")
    public List<Patient> addPatient(@RequestBody Patient Patient) {
        PatientRepository.save(Patient);
        return PatientRepository.findAll();
    }

    // Update the Patient information
    @PutMapping("/Patient/{id}")
    public List<Patient> updatePatient(@RequestBody Patient Patient, @PathVariable Integer id) {
        Patient PatientObj = PatientRepository.findById(id).get();
        PatientObj.setName(Patient.getName());
        PatientObj.setAddress(Patient.getAddress());
        PatientRepository.save(PatientObj);
        return PatientRepository.findAll();
    }

}
