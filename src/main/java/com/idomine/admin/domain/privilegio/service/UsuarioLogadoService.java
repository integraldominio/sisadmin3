package com.idomine.admin.domain.privilegio.service;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.idomine.admin.domain.privilegio.model.Usuario;
import com.idomine.admin.domain.privilegio.model.vo.SituacaoUsuario;
import com.idomine.admin.domain.privilegio.repository.UsuarioRepository;

@Service
public class UsuarioLogadoService implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Inject
    private UsuarioRepository usuarioRepository;

    public Usuario verificarUsuario(Usuario usuarioInformado)
    {
        Usuario usuarioCadastrado = null;
        List<Usuario> usuariosEncontrados = usuarioRepository.findByLogin(usuarioInformado.getNome());

        if (usuariosEncontrados.size() > 0)
        {
            usuarioCadastrado = usuariosEncontrados.get(0);
            boolean verificado = verificarNomeSenha(usuarioCadastrado, usuarioInformado) && isUsuarioAtivo(usuarioCadastrado);
            if (!verificado)
                usuarioCadastrado = null;
        }
        return usuarioCadastrado;
    }

    private boolean isUsuarioAtivo(Usuario usuario)
    {
        return SituacaoUsuario.Ativo.equals(usuario.getSituacao());
    }

    private boolean verificarNomeSenha(Usuario userUm, Usuario userDois)
    {
        return userUm.getNome().toLowerCase().equals(userUm.getNome().toLowerCase()) &&
                userUm.getSenha().equals(userDois.getSenha());
    }

    public boolean checarPermissao(Usuario currentUser, String modulo)
    {
        return currentUser.getFuncionalidades().stream().filter(f->f.getValue().equals(modulo)).collect(Collectors.toList()).size()>0;
    }

}
