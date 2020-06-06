package com.ctrends.service;

import java.util.List;
import java.util.Map;

import com.ctrends.model.UserAttachmentsModel;

public interface IUserAttachmentService {
	public Map<String, Object> saveAttachments(List<UserAttachmentsModel> userAttachments);
	public Map<String, Object> updateUserAttachments(String username, UserAttachmentsModel userAttachment);
	public Map<String, Object> deleteUserAttachments(String username, UserAttachmentsModel userAttachment);
	public Map<String, Object> attachmentValidityCheck(UserAttachmentsModel userAttachments);
}
