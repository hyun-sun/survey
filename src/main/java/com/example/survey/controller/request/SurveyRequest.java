package com.example.survey.controller.request;

import lombok.Data;

@Data
public class SurveyRequest {
	private String id;
	private String name;

	private String nation;
	private String zeroNothingOne;
	private String haveChild;
	private String taxation;
}
