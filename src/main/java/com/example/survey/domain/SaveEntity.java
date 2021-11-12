package com.example.survey.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SaveEntity {
	private String id;
	private String name;
	private String category1;
	private String category2;
	private String answer;


}
