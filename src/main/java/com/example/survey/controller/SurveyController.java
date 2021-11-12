package com.example.survey.controller;

import com.example.survey.controller.request.SurveyRequest;
import com.example.survey.domain.SaveEntity;
import com.example.survey.service.SurveyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class SurveyController {

	private final SurveyService surveyService;

	public SurveyController(SurveyService surveyService) {
		this.surveyService = surveyService;
	}

	@PostMapping(value = "/v1/survey")
	public List<SaveEntity> survey(@RequestBody SurveyRequest surveyRequest) {

		return surveyService.saveSurvey(surveyRequest);
	}
}
