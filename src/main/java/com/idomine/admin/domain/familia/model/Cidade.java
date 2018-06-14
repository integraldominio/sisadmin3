package com.idomine.admin.domain.familia.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@EqualsAndHashCode(of = { "id" })
public class Cidade implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nome;
    
    public boolean isIncluindo() {
        return id == null ? true : false;
    }
    
    public boolean isEditando() {
        return !isIncluindo();
    }
}
