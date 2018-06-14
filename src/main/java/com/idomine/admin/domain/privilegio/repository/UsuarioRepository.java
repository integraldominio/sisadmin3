package com.idomine.admin.domain.privilegio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idomine.admin.domain.privilegio.model.Usuario;

 
public interface UsuarioRepository  extends JpaRepository<Usuario, Long>
{
    
    public List<Usuario> findByNome(String nome);
    
    public List<Usuario> findByLogin(String nome);

}
