package com.idomine.admin.infrastructure.helper;

import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public final class PageHelper
{
    private PageHelper()
    {
    }

    public static void gotoPageCheckingCurrentUrl(String page)
    {
        String urlAtual = FacesContext.getCurrentInstance().getExternalContext().getRequestServletPath();
        boolean inPaginaInicio = urlAtual.indexOf(page) != -1;
        if (!inPaginaInicio)
        {
            gotoPage(page);
        }
    }

    public static void gotoPage(String page)
    {
        FacesContext faces = FacesContext.getCurrentInstance();
        ExternalContext context = faces.getExternalContext();
        try
        {
            context.redirect(faces.getExternalContext().getRequestContextPath()
                    + "/" + page);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void setSessionAttribute(String nome, Object valor)
    {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = null;
        if (fc != null)
            session = (HttpSession) fc.getExternalContext().getSession(false);
        if (session != null)
        {
            session.setAttribute(nome, valor);
        }
    }

    public static Object getSessionAttribute(String atributo)
    {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = null;
        ;
        HttpSession session = null;
        if (fc != null)
            ec = fc.getExternalContext();
        if (ec != null)
            session = (HttpSession) ec.getSession(true);
        return (session != null ? session.getAttribute(atributo) : null);
    }

    public static void removeSessionAttribute(String nome)
    {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = null;
        if (fc != null)
            session = (HttpSession) fc.getExternalContext().getSession(false);
        if (session != null)
        {
            session.removeAttribute(nome);
        }
    }
}
