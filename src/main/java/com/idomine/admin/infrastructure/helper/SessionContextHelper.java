package com.idomine.admin.infrastructure.helper;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *   SessionContext trabalhará com o padrão de projeto Singleton.
 *   Garantimos que só existirá uma instância deste objeto durante toda a aplicação
 */
public class SessionContextHelper {
    
    private static SessionContextHelper instance;
    
    public static SessionContextHelper getInstance(){
       if (instance == null){
           instance = new SessionContextHelper();
       }
       
       return instance;
    }
    
    private SessionContextHelper(){
       
    }
    
    private ExternalContext currentExternalContext(){
       if (FacesContext.getCurrentInstance() == null){
           throw new RuntimeException("O FacesContext não pode ser chamado fora de uma requisição HTTP");
       }else{
           return FacesContext.getCurrentInstance().getExternalContext();
       }
    }
    
    
    public void encerrarSessao(){
       currentExternalContext().invalidateSession();
    }
    
    public Object getAttribute(String nome){
       return currentExternalContext().getSessionMap().get(nome);
    }
    
    public void setAttribute(String nome, Object valor){
       currentExternalContext().getSessionMap().put(nome, valor);
    }
    
    public void removeAttribute(String nome){
        HttpSession session = ((HttpSession) 
        currentExternalContext().getSession(false));
        if (session != null)
        {
            session.removeAttribute(nome);
        }
     }
    
    public  void ajustarSessaoTimeOut(int tempoMinutos)
    {
        HttpSession session = ((HttpSession) 
        currentExternalContext().getSession(false));
        session.setMaxInactiveInterval(20 * tempoMinutos);    
    }
 
}