package com.diagnosis.ms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diagnosis.ms.model.Diagnosis;
import com.diagnosis.ms.repository.DiagnosisRepository;

@Service
public class DiagnosisService {
	@Autowired
	DiagnosisRepository repo;
	
	public Diagnosis save(Diagnosis diagnosis) {
		return repo.save(diagnosis);
	}
	
	public List<Diagnosis> findAll(){
		return repo.findAll();
	}
	
	public Diagnosis findById(String id) {
		return repo.findById(id).orElse(null);
	}
	
}
