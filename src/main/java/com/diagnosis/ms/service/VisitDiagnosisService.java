package com.diagnosis.ms.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diagnosis.ms.dto.VisitDiagnosisDTO;
import com.diagnosis.ms.model.Diagnosis;
import com.diagnosis.ms.model.VisitDiagnosis;
import com.diagnosis.ms.repository.DiagnosisRepository;
import com.diagnosis.ms.repository.VisitDiagnosisRepository;

@Service
public class VisitDiagnosisService {

	@Autowired
	VisitDiagnosisRepository repo;
	
	@Autowired
	DiagnosisRepository diagnoRepo;	
	
	@Autowired
	EntityManager em;
	
	public VisitDiagnosis save(VisitDiagnosisDTO visitDto) {
		Optional<Diagnosis> diagnoOpt = diagnoRepo.findById(visitDto.getDiagnosisCode());
		
		VisitDiagnosis visitDiagno = new VisitDiagnosis();
		
		visitDiagno.setId(visitDto.getId());
		visitDiagno.setVisitId(visitDto.getVisitId());
		if(diagnoOpt.isPresent()) {
			visitDiagno.setDiagnosis(diagnoOpt.get());
			return repo.save(visitDiagno);
		}
		return null;
	}
	
	public List<VisitDiagnosis> findByVisitId(Long visitId) {
		TypedQuery<VisitDiagnosis> q = em.createQuery("SELECT pa FROM VisitDiagnosis pa where pa.visitId = :visitId", VisitDiagnosis.class);
		q.setParameter("visitId", visitId);
		
		return q.getResultList();
	}
	
	public VisitDiagnosis findById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public boolean delete(Long id) {
		try {
			repo.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
}
