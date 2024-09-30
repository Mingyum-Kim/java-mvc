package com.interface21.webmvc.servlet.view;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JsonView implements View {

	private static final int DOSE_NOT_USE_JSON_COUNT = 1;
	private final ObjectMapper objectMapper;

	public JsonView() {
		this.objectMapper = new ObjectMapper();
	}

	@Override
    public void render(final Map<String, ?> model, final HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (model.size() == DOSE_NOT_USE_JSON_COUNT)  {
			setModelAttribute(model, request);
			return;
		}
        objectMapper.writeValue(response.getWriter(), model);
		response.setContentType("application/json; charset=utf-8");
    }

	private void setModelAttribute(Map<String, ?> model, HttpServletRequest request) {
		model.keySet().forEach(key -> {
			request.setAttribute(key, model.get(key));
		});
	}
}
