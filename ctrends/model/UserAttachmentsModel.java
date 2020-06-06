package com.ctrends.model;
import java.util.UUID;
import javax.persistence.Id;
import org.hibernate.annotations.Type;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_attachments")
public class UserAttachmentsModel{

 	@Id
	@Type(type = "org.hibernate.type.PostgresUUIDType")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private UUID id;	//NOT NULL DEFAULT uuid_generate_v4() 

	@Column(name = "username")
	private String username;
	
	@Column(name = "person_name")
	private String personName;

	@Column(name = "file_name")
	private String fileName;	// options: Photo, Signature, Initial, NID Front, NID Back, Spouse Photo,

	@Column(name = "file_type")
	private String fileType;	// options: Image, PDF, Doc, Spreadsheet

	@Column(name = "file_content")
	private String fileContent;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileContent() {
		return fileContent;
	}

	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}

	public UserAttachmentsModel() {}



}
