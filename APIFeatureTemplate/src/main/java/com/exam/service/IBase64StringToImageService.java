package com.exam.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.exam.payload.StringImageViewModel;

public interface IBase64StringToImageService {
	public Map<String, Object> uploadImageFromString(HttpServletRequest request, List<StringImageViewModel> viewModel);
}
