package com.idomine.admin.web.ocupacao.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.idomine.admin.domain.familia.model.Ocupacao;
import com.idomine.admin.domain.familia.service.OcupacaoService;
import com.idomine.admin.infrastructure.helper.FacesHelper;

import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class ListaOcupacaoMB implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Inject
    private OcupacaoService service;
    @Getter
    @Setter
    private List<Ocupacao> ocupacoes = new ArrayList<>();
    @Getter
    @Setter
    private List<Ocupacao> ocupacaoSelecionados = new ArrayList<>();

    @PostConstruct
    public void inicializar()
    {
        ocupacoes = service.listAll();
    }

    public void excluirSelecionados()
    {
        for (Ocupacao tarefa : ocupacaoSelecionados)
        {
            service.excluir(tarefa);
        }
        FacesHelper.addInfoMessage("Ocupação(s) excluída(s) com sucesso!");
    }

}
