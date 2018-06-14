package com.idomine.admin.web.familia.controller;

import static com.idomine.admin.infrastructure.helper.FacesServicesHelper.atualizarElemento;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.idomine.admin.domain.familia.model.Bairro;
import com.idomine.admin.domain.familia.model.Cidade;
import com.idomine.admin.domain.familia.model.Familia;
import com.idomine.admin.domain.familia.model.Membro;
import com.idomine.admin.domain.familia.model.Ocupacao;
import com.idomine.admin.domain.familia.model.vo.EstadoCivil;
import com.idomine.admin.domain.familia.model.vo.NivelInstrucao;
import com.idomine.admin.domain.familia.model.vo.Parentesco;
import com.idomine.admin.domain.familia.model.vo.Sexo;
import com.idomine.admin.domain.familia.model.vo.SimNao;
import com.idomine.admin.domain.familia.model.vo.TipoDocumento;
import com.idomine.admin.domain.familia.repository.BairroRepository;
import com.idomine.admin.domain.familia.repository.CidadeRepository;
import com.idomine.admin.domain.familia.repository.OcupacaoRepository;
import com.idomine.admin.domain.familia.service.FamiliaService;

import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class CadastroFamiliaMB implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Setter
    @Getter
    private Familia familia;
    @Setter
    @Getter
    private Long id;
    @Getter
    private Map<String, SimNao> simnao = SimNao.listar();
    @Getter
    private Map<String, Parentesco> parentesco = Parentesco.listar();
    @Getter
    private Map<String, Sexo> sexo = Sexo.listar();
    @Getter
    private Map<String, EstadoCivil> estadoCivil = EstadoCivil.listar();
    @Getter
    private Map<String, NivelInstrucao> nivelInstrucao = NivelInstrucao.listar();
    @Getter
    private Map<String, TipoDocumento> tipoDocumento = TipoDocumento.listar();
    @Inject
    private FamiliaService service;
    @Getter
    private List<Cidade> cidades;
    @Getter
    private List<Bairro> bairros;
    @Inject
    private CidadeRepository cidadeRepository;
    @Inject
    private BairroRepository bairroRepository;
    @Setter
    @Getter
    private Membro membro;
    @Getter
    private List<Ocupacao> ocupacao;
    @Inject
    private OcupacaoRepository ocupacaoRepository;
    @Setter
    @Getter
    private Membro membroSelecionado;
    private boolean editando = false;

    @PostConstruct
    public void init()
    {
        familia = new Familia();
        cidades = cidadeRepository.findAll();
        bairros = bairroRepository.findAll();
        ocupacao = ocupacaoRepository.findAll();
    }

    public void inicializar()
    {
        if (id != null && !editando)
        {
            familia = service.porId(id);
            editando = true;
        }
    }

    public String salvar()
    {
        service.salvar(familia);
        return "lista-familia.xhtml?faces-redirect=true";
    }

    public String excluir()
    {
        service.excluir(familia);
        return "lista-familia.xhtml?faces-redirect=true";
    }

    public void salvarMembro()
    {
        editando = true;
        membro.setFamilia(familia);
        familia.getMembros().add(membro);
        membro = null;
        atualizarElemento("form:membroTable");
        atualizarElemento("form:membro");
    }

    public void novoMembro()
    {
        membro = new Membro();
    }

    public void cancelarNovoMembro()
    {
        membro = null;
    }

    public void excluirMembro(Membro membro)
    {
        familia.setMembros(familia.getMembros().stream().filter(m -> !m.getNome().equals(membro.getNome()))
                .collect(Collectors.toList()));
        atualizarElemento("form:membroTable");
    }

    public void editarMembro()
    {

    }

}
