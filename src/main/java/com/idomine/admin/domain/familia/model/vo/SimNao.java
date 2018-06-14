package com.idomine.admin.domain.familia.model.vo;

import java.util.HashMap;
import java.util.Map;

public enum SimNao
{
    Sim("S"),
    Nao("N");
    
    private String value;

    private SimNao(String value)
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
    
    public static SimNao getTipo(String value)
    {
        if (value != null)
        {
            switch (value)
            {
                case "M":
                    return SimNao.Sim;
                case "F":
                    return SimNao.Nao;
            }
        }
        return SimNao.Sim;
    }

    public static Map<String, SimNao> listar()
    {
        Map<String, SimNao> lista = new HashMap<>();
        lista.put("Sim", SimNao.Sim);
        lista.put("Não", SimNao.Nao);
        return lista;
    }
}
