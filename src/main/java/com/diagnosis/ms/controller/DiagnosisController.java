package com.diagnosis.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diagnosis.ms.dto.VisitDiagnosisDTO;
import com.diagnosis.ms.model.Diagnosis;
import com.diagnosis.ms.model.VisitDiagnosis;
import com.diagnosis.ms.service.DiagnosisService;
import com.diagnosis.ms.service.VisitDiagnosisService;

@RestController
@RequestMapping(value = "/api/v1/diagnosis")
public class DiagnosisController {

	@Autowired
	DiagnosisService service;
	
	@Autowired
	VisitDiagnosisService vdService;
	
	@GetMapping()
	public ResponseEntity findAllDiagnosis() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@PostMapping()
	public ResponseEntity save(@RequestBody Diagnosis diagnosis) {
		return ResponseEntity.ok(service.save(diagnosis));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity findById(@PathVariable String id) {
		Diagnosis diagnosis = service.findById(id);
		if(diagnosis != null) {
			return ResponseEntity.ok(diagnosis);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}
	
	@GetMapping("/visit/{id}")
	public ResponseEntity findByVisitId(@PathVariable Long id) {
		return ResponseEntity.ok(vdService.findByVisitId(id));
	}
	
	@GetMapping("/visitDiagnosis/{id}")
	public ResponseEntity findByVisitDiagnosisId(@PathVariable Long id) {
		VisitDiagnosis diagnosis = vdService.findById(id);
		if(diagnosis != null) {
			return ResponseEntity.ok(diagnosis);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/visitDiagnosis/{id}")
	public ResponseEntity deleteVisitDiagnosis(@PathVariable Long id) {
		boolean isDeleted = vdService.delete(id);
		
		if(isDeleted) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PostMapping("/visitDiagnosis")
	public ResponseEntity addVisitDiagnosis(@RequestBody VisitDiagnosisDTO visitDiagno) {
		VisitDiagnosis vdDiagno = vdService.save(visitDiagno);
		if(vdDiagno == null) {
			return ResponseEntity.badRequest().build();
		}else {
			return ResponseEntity.ok().build();
		}
	}
	
	@PutMapping("/visitDiagnosis/{id}")
	public ResponseEntity updateVisitDiagnosis(@PathVariable Long id,@RequestBody VisitDiagnosisDTO visitDiagno) {
		VisitDiagnosis vdDiagno = vdService.save(visitDiagno);
		if(vdDiagno == null) {
			return ResponseEntity.badRequest().build();
		}else {
			return ResponseEntity.ok().build();
		}
	}
}
