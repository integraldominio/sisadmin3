package com.idomine.admin.web.ocupacao.controller;

import static com.idomine.admin.infrastructure.helper.FacesServicesHelper.atualizarElemento;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.idomine.admin.domain.familia.model.Ocupacao;
import com.idomine.admin.domain.familia.service.OcupacaoService;

import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class CadastroOcupacaoMB implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Setter
    @Getter
    private Ocupacao ocupacao;
    @Setter
    @Getter
    private Long id;
    private boolean editando = false;
    @Inject
    private OcupacaoService service;

    @PostConstruct
    public void init()
    {
        ocupacao = new Ocupacao();
    }

    public void inicializar()
    {
        if (id != null && !editando)
        {
            ocupacao = service.porId(id);
            editando = true;
        }
    }

    public String salvar()
    {
        service.salvar(ocupacao);
        return "lista-ocupacao.xhtml?faces-redirect=true";
    }

    public String excluir()
    {
        service.excluir(ocupacao);
        return "lista-ocupacao.xhtml?faces-redirect=true";
    }

    public void salvarMembro()
    {
        editando = true;
        atualizarElemento("form:usuarioTable");
    }

}
