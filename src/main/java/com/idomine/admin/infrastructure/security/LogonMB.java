package com.idomine.admin.infrastructure.security;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Specializes;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Faces;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.github.adminfaces.template.session.AdminSession;
import com.idomine.admin.domain.privilegio.model.Usuario;
import com.idomine.admin.domain.privilegio.service.UsuarioLogadoService;
import com.idomine.admin.infrastructure.helper.Utils;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by rmpestano on 12/20/14.
 *
 * This is just a login example.
 *
 * AdminSession uses isLoggedIn to determine if user must be redirect to login page or not. By default AdminSession
 * isLoggedIn always resolves to true so it will not try to redirect user.
 *
 * If you already have your authorization mechanism which controls when user must be redirect to initial page or logon
 * you can skip this class.
 */
//@Named
//@SessionScoped
//@Specializes

@Named
@SessionScoped
@Specializes
@Primary
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LogonMB extends AdminSession implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    private Usuario currentUser;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String password;
    @Getter
    @Setter
    private boolean remember;
    
    @Inject
    private UsuarioLogadoService usuarioService;


    public boolean permissao(String modulo)
    {
        return usuarioService.checarPermissao(currentUser,modulo);
    }
    
    
    public void desconectarUsuario()
    {
        currentUser=null;
    }
    
    public void logout() throws IOException
    {
        currentUser=null;
        Faces.redirect("login.xhtml");
    }

    public void login() throws IOException
    {
        Usuario usuarioInformado = new Usuario (email,password );
        Usuario usuarioVerificao = usuarioService.verificarUsuario(usuarioInformado);
        if ( usuarioVerificao!=null)
        {
            currentUser = usuarioVerificao;
            Utils.addDetailMessage("Bem-vindo, <b>"+ email + "</b>");
            Faces.getExternalContext().getFlash().setKeepMessages(true);
            Faces.redirect("index.xhtml");
        }
        else
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Nome ou senha inválidos!",  "" ));
        }
    }

    
    public void verificarUsuarioLogado() throws IOException
    {
        if(!isLoggedIn())
        {
            Faces.redirect("login.xhtml");
        }
    }
    
    @Override
    public boolean isLoggedIn()
    {

        return currentUser != null;
    }

}
