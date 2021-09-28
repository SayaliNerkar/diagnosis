package com.diagnosis.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.diagnosis.ms.model.Diagnosis;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, String>{

}
