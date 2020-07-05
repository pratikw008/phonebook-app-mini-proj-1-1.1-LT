package com.phoneBook.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1459744940525664906L;

	private Integer contactId;
	
	private String contactName;
	
	private String contactEmail;
	
	private Long contactNumber;
	
	private LocalDateTime createdDate;
	
	private LocalDateTime updatedDate;
}