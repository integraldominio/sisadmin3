package com.idomine.admin.web.usuario.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.idomine.admin.domain.privilegio.model.Usuario;
import com.idomine.admin.domain.privilegio.service.UsuarioService;
import com.idomine.admin.infrastructure.helper.FacesHelper;

import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class ListaUsuarioMB implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Inject
    private UsuarioService service;
    @Getter
    @Setter
    private List<Usuario> usuarios = new ArrayList<>();
    @Getter
    @Setter
    private List<Usuario> usuariosSelecionados = new ArrayList<>();

    @PostConstruct
    public void inicializar()
    {
        usuarios = service.listAll();
    }

    public void excluirSelecionados()
    {
        for (Usuario tarefa : usuariosSelecionados)
        {
            service.excluir(tarefa);
            usuarios.remove(tarefa);
        }
        FacesHelper.addInfoMessage("Usuario(s) excluída(s) com sucesso!");
    }

}
