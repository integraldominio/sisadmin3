package com.idomine.admin.domain.tarefa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idomine.admin.domain.tarefa.model.Tarefa;

 
public interface TarefaRepository extends JpaRepository<Tarefa, Long> 
{

}
