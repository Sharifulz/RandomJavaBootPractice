package com.exam.service;

import java.util.List;
import java.util.Map;

import com.exam.model.UserAttachmentsModel;

public interface IUserAttachmentService {
	public Map<String, Object> saveAttachments(List<UserAttachmentsModel> userAttachments);
}
