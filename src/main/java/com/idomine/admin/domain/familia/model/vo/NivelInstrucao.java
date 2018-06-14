package com.idomine.admin.domain.familia.model.vo;

import java.util.HashMap;
import java.util.Map;

public enum NivelInstrucao
{
    SemEscolaridade("SemEscolaridade"), Elementar("Elementar"), Medio("Medio"), Superior("Superior");

    private String value;

    private NivelInstrucao(String value)
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

    public static NivelInstrucao getTipo(String value)
    {
        if (value != null)
        {
            switch (value)
            {
                case "SemEscolaridade":
                    return NivelInstrucao.SemEscolaridade;
                case "Elementar":
                    return NivelInstrucao.Elementar;
                case "Medio":
                    return NivelInstrucao.Medio;
                case "Superior":
                    return NivelInstrucao.Superior;
            }
        }
        return NivelInstrucao.Medio;
    }

    public static Map<String, NivelInstrucao> listar()
    {
        Map<String, NivelInstrucao> lista = new HashMap<>();
        lista.put("Sem Escolaridade", NivelInstrucao.SemEscolaridade);
        lista.put("Elementar", NivelInstrucao.Elementar);
        lista.put("Médio", NivelInstrucao.Medio);
        lista.put("Superior", NivelInstrucao.Superior);
        return lista;
    }
}
