package com.idomine.admin.domain.privilegio.model.vo;

import java.util.HashMap;
import java.util.Map;

public enum Funcionalidade
{
    Familia("Familia"),
    Usuario("Usuario"),
    Ocupacao("Ocupacao"),
    Cidade("Cidade"),
    Bairro("Bairro"),
    Configuracao("Configuracao");
    
    private String value;
    
    private Funcionalidade(String value)
    {
        this.setValue(value);
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public static Funcionalidade getTipo(String value)
    {
        if (value != null)
        {
            switch (value)
            {
                case "Familia":
                    return Funcionalidade.Familia;
                case "Usuario":
                    return Funcionalidade.Usuario;
                case "Ocupacao":
                    return Funcionalidade.Ocupacao;
                case "Cidade":
                    return Funcionalidade.Cidade;
                case "Bairro":
                    return Funcionalidade.Bairro;
                case "Configuracao":
                    return Funcionalidade.Configuracao;            }
        }
        return Funcionalidade.Familia;
    }

    public static Map<String, Funcionalidade> listar()
    {
        Map<String, Funcionalidade> lista = new HashMap<>();
        lista.put("Família", Funcionalidade.Familia);
        lista.put("Usuário", Funcionalidade.Usuario);
        lista.put("Ocupação", Funcionalidade.Ocupacao);
        lista.put("Cidade", Funcionalidade.Cidade);
        lista.put("Bairro", Funcionalidade.Bairro);
        lista.put("Configuração", Funcionalidade.Configuracao);
        return lista;
    }

}
