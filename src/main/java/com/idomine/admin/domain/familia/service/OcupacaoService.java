package com.idomine.admin.domain.familia.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idomine.admin.domain.familia.model.Ocupacao;
import com.idomine.admin.domain.familia.repository.OcupacaoRepository;

@Service
public class OcupacaoService implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Inject
    private OcupacaoRepository ocupacaoRepository;

    @Transactional
    public Ocupacao salvar(Ocupacao ocupacao)
    {
        return ocupacaoRepository.save(ocupacao);
    }
    @Transactional
    public void excluir(Ocupacao ocupacao)
    {
        ocupacaoRepository.delete(ocupacao);
    }

    public Ocupacao porId(Long id)
    {
        return ocupacaoRepository.findById(id).get();
    }

    public List<Ocupacao> listAll()
    {
        return ocupacaoRepository.findAll();
    }

}
