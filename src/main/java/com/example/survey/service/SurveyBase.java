package com.example.survey.service;

import lombok.Getter;

import java.util.Arrays;

public enum SurveyBase {
	SURVEY_001_001("nation", "001", "001"),
	SURVEY_001_002("zeroNothingOne", "001", "002"),
	SURVEY_001_003("haveChild", "001", "003"),
	SURVEY_001_004("taxation", "001", "004");

	@Getter
	private String surveyQuestion;
	@Getter
	private String surveyCategory1;
	@Getter
	private String serveyCategory2;

	SurveyBase(String surveyQuestion, String surveyCategory1, String serveyCategory2) {
		this.surveyQuestion = surveyQuestion;
		this.surveyCategory1 = surveyCategory1;
		this.serveyCategory2 = serveyCategory2;
	}

	public static SurveyBase getSurveyBase(String question) {
		return Arrays.stream(values()).filter(surveyBase -> surveyBase.getSurveyQuestion().equals(question)).findFirst().orElse(null);
	}
}
