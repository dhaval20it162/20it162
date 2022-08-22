package in.ac.charusat.patientmgmtsystem.repository;

import in.ac.charusat.studentmgmtsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
