package com.example.survey.service;

import com.example.survey.controller.request.SurveyRequest;
import com.example.survey.domain.SaveEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SurveyService {

	public List<SaveEntity> saveSurvey(SurveyRequest surveyRequest) {
		return getSurveyList(surveyRequest);
	}

	private List<SaveEntity> getSurveyList(SurveyRequest request) {
		List<SaveEntity> entities = new ArrayList<>();
		Arrays.stream(request.getClass().getDeclaredFields()).forEach(field -> {
			String name = field.getName();
			SurveyBase surveyBase = SurveyBase.getSurveyBase(name);
			if(surveyBase != null) {
				try {
					field.setAccessible(true);
					String value = (String) field.get(request);
					SaveEntity saveEntity = SaveEntity.builder()
							.id(request.getId())
							.name(request.getName())
							.category1(surveyBase.getSurveyCategory1())
							.category2(surveyBase.getServeyCategory2())
							.answer(value)
							.build();
					entities.add(saveEntity);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		return entities;
	}

}
