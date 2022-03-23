/**
* Project Name : Project Management System
* @company YMSLI
* @author Pawandeep Singh
* @date 16 March, 2022
* Copyright (c) 2022, Yamaha Motor Solutions (INDIA) Pvt Ltd.
*
* Description
* ---------------------------------------------------------------------------------------------------------
* ProjectNotFoundException Class : Throws an exception if project not found
* ---------------------------------------------------------------------------------------------------------
*
 */
package com.projectmanagement.model.exception;

public class ProjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ProjectNotFoundException(String message) {
		super(message);
		
	}

	
}
