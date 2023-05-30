package com.shaan31.fmi.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "FILE_DATA")
public class FileData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String fileName;
	private String uploadedBy;
	private Date uploadedOn;
	private String data;
	
	public FileData(long id, String fileName, String uploadedBy, Date uploadedOn, String data) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.uploadedBy = uploadedBy;
		this.uploadedOn = uploadedOn;
		this.data = data;
	}

	public FileData() {
		super();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUploadedBy() {
		return uploadedBy;
	}
	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}
	public Date getUploadedOn() {
		return uploadedOn;
	}
	public void setUploadedOn(Date uploadedOn) {
		this.uploadedOn = uploadedOn;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
