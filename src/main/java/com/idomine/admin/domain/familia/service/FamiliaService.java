package com.idomine.admin.domain.familia.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idomine.admin.domain.familia.model.Familia;
import com.idomine.admin.domain.familia.model.vo.Situacao;
import com.idomine.admin.domain.familia.repository.FamiliaRepository;

@Service
public class FamiliaService implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Inject
    private FamiliaRepository familiaRepository;

    @Transactional
    public Familia salvar(Familia familia)
    {
        if (familia.isIncluindo())
        {
            familia.setCriacao(new Date());
            familia.setSituacao(Situacao.Ativo);
        }
        return familiaRepository.save(familia);
    }

    @Transactional
    public void excluir(Familia familia)
    {
        familiaRepository.delete(familia);
    }

    public Familia porId(Long id)
    {
        return familiaRepository.findById(id).get();
    }

    public List<Familia> listAll()
    {
        return familiaRepository.findAll();
    }

}
