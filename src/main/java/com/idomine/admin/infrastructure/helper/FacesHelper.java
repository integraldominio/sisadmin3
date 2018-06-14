package com.idomine.admin.infrastructure.helper;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesHelper {

	public static void addInfoMessage(String msg) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));		
	}

}
