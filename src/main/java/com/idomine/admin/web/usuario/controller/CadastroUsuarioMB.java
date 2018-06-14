package com.idomine.admin.web.usuario.controller;

import static com.idomine.admin.infrastructure.helper.FacesServicesHelper.atualizarElemento;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.idomine.admin.domain.privilegio.model.Usuario;
import com.idomine.admin.domain.privilegio.service.UsuarioService;

import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class CadastroUsuarioMB implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Setter
    @Getter
    private Usuario usuario;
    @Setter
    @Getter
    private Long id;
    private boolean editando = false;
    @Inject
    private UsuarioService service;

    @PostConstruct
    public void init()
    {
        usuario =new Usuario();
    }

    public void inicializar()
    {
        if (id != null && !editando)
        {
            usuario = service.porId(id);
            editando = true;
        }
    }

    public String salvar()
    {
        service.salvar(usuario);
        return "lista-usuario.xhtml?faces-redirect=true";
    }

    public String excluir()
    {
        service.excluir(usuario);
        return "lista-usuario.xhtml?faces-redirect=true";
    }

    public void salvarMembro()
    {
        editando = true;
        atualizarElemento("form:usuarioTable");
    }


}
