package com.idomine.admin.web.familia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.idomine.admin.domain.familia.model.Familia;
import com.idomine.admin.domain.familia.service.FamiliaService;
import com.idomine.admin.infrastructure.helper.FacesHelper;

import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class ListaFamiliaMB implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Inject
    private FamiliaService service;
    @Getter
    @Setter
    private List<Familia> familias = new ArrayList<>();
    @Getter
    @Setter
    private List<Familia> familiaSelecionadas = new ArrayList<>();

    @PostConstruct
    public void inicializar()
    {
        familias = service.listAll();
    }

    public void excluirSelecionados()
    {
        for (Familia tarefa : familiaSelecionadas)
        {
            service.excluir(tarefa);
            familias.remove(tarefa);
        }
        FacesHelper.addInfoMessage("Familia(s) excluída(s) com sucesso!");
    }

}
