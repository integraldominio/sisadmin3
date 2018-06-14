package com.idomine.admin.domain.privilegio.service;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idomine.admin.domain.privilegio.model.Usuario;
import com.idomine.admin.domain.privilegio.model.vo.SituacaoUsuario;
import com.idomine.admin.domain.privilegio.repository.UsuarioRepository;

@Service
public class UsuarioService implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Inject
    private UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario salvar(Usuario usuario)
    {
        return usuarioRepository.save(usuario);
    }

    @javax.transaction.Transactional
    public void excluir(Usuario usuario)
    {
        if (usuario.getId().equals(1L))
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário adminstrador não poder inativado!", ""));
        }
        else
        {
            usuario.setSituacao(SituacaoUsuario.Inativo);
            usuarioRepository.save(usuario);
        }
    }

    public Usuario porId(Long id)
    {
        return usuarioRepository.findById(id).get();
    }

    public List<Usuario> listAll()
    {
        return usuarioRepository.findAll();
    }

}
