package com.amazech.onsked.domain;

import java.io.Serializable;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FileUpload implements Serializable {
	private static final long serialVersionUID = -3740835273741384087L;
	private MultipartFile file;


}