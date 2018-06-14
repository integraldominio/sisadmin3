package com.idomine.admin.infrastructure.helper;


import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import org.jboss.logging.Logger;
import org.primefaces.context.RequestContext;

public final class FacesMessagesHelper
{
    private FacesMessagesHelper()
    {
    }

    private static final String ERROR_STR = "Error";
    private static final String AVISO_STR = "Aviso";
    
    private static final Logger logger = 
            Logger.getLogger(FacesMessagesHelper.class);

    public static void showMessage(String titulo, String msg, String obj, Severity severity)
    {
        FacesMessage fm = new FacesMessage();
        fm.setSummary(titulo + ":");
        fm.setDetail(msg);
        fm.setSeverity(severity);
        FacesContext contex = FacesContext.getCurrentInstance();
        if (contex != null)
        {
            contex.addMessage(obj, fm);
            // Soluciona problema del growl, este siempre desaparece en cada ajax update del primefaces
            // para que funcione se debe omitir el uso del autoupdate igual a true.
            String severityStr = fm.getSeverity().toString().split(" ")[0].toLowerCase();
            RequestContext.getCurrentInstance().execute(
                    "PrimeFaces.widgets.growl.show([{summary:'" + fm.getSummary() + "', detail: '" + fm.getDetail()
                            + "', severity: '" + severityStr + "'}])");
        }
        else
        {
            logger.info(">>>" + msg); 
//            System.err.println(">>>" + msg);
        }
    }

    public static void erro(String msg)
    {
        showMessage(ERROR_STR, msg, null, FacesMessage.SEVERITY_ERROR);
    }

    public static void aviso(String msg)
    {
        showMessage(AVISO_STR, msg, null, FacesMessage.SEVERITY_WARN);
    }

    public static void info(String msg)
    {
        showMessage(AVISO_STR, msg, null, FacesMessage.SEVERITY_INFO);
    }

}
