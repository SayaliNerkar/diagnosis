package com.diagnosis.ms.dto;

import com.diagnosis.ms.model.Diagnosis;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class VisitDiagnosisDTO {
	Long id;
	String diagnosisCode;
	Long visitId;
	
}
