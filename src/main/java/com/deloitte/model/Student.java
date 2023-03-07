package com.deloitte.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="Students")
public class Student {

	@Id
	private String id;
	private String fName;
	private String lName;
	private String address;
	private String pincode;
}
