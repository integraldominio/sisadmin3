package com.idomine.admin.infrastructure.helper;

import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;
 
public final class CookieHelper
{
    private static final Logger logger = 
            Logger.getLogger(CookieHelper.class);
    
    private CookieHelper()
    {
    }

    public static void gravarCookie(String nome, String valor)
    {
        try
        {
            FacesContext context = FacesContext.getCurrentInstance();
            Cookie ck = new Cookie(nome, valor);
            int tempoExpiracaoUmMes = 60 * 60 * 24 * 30;
            ck.setMaxAge(tempoExpiracaoUmMes);
            ((HttpServletResponse) context.getExternalContext().getResponse()).addCookie(ck);
        }
        catch (Exception x)
        {
            x.printStackTrace();
            logger.debug(">>>Erro gravando Cookie!");
        }
    }

    public static String lerCookie(String nome)
    {
        try
        {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();

            Cookie[] cookies = request.getCookies();

            if (cookies != null)
                for (Cookie cookie : cookies)
                {
                    if (cookie.getName().trim().equalsIgnoreCase(nome))
                    {
                        return cookie.getValue();
                    }
                }

        }
        catch (Exception x)
        {
            x.printStackTrace();
        }
        return "";
    }

}
