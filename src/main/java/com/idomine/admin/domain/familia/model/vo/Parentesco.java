package com.idomine.admin.domain.familia.model.vo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum Parentesco
{
    NaoInformado("NaoInformado"),
    
    Trisavo("Trisavo"), Bisavo("Bisavo"), Avo("Avo"), Pai("Pai"), Filho("Filho"), Neto("Neto"), Bisneto(
            "Bisneto"), Trineto("Trineto"),

    Irmao("Irmao"), Sobrinho("Sobrinho"), NetoDoIrmao("NetoDoIrmao"), BisnetoDoIrmao("BisnetoDoIrmao"), TrinetoDoIrmao(
            "TrinetoDoIrmao"),

    Tio("Tio"), Primo("Primo"), FilhoDoPrimo("FilhoDoPrimo"), NetoDoPrimo("NetoDoPrimo"), BisnetoDoPrimo(
            "BisnetoDoPrimo"), TrinetoDoPrimo("TrinetoDoPrimo"),

    TioAvo("TioAvo"), FilhoDoTioAvo("FilhoDoTioAvo"), NetoDoTpoAvo("NetoDoTpoAvo"), BisnetoDoTioAvo(
            "NetoDoTpoAvo"), TrinetoDoTioAvo("TrinetoDoTioAvo");

    private String value;

    private Parentesco(String value)
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

    public static Parentesco getTipo(String value)
    {
        if (value != null)
        {
            switch (value)
            {
                case "NaoInformado":
                    return Parentesco.NaoInformado;
                case "Trisavo":
                     return Parentesco.Trisavo;
                case "Bisavo":
                    return Parentesco.Bisavo;
                case "Avo":
                    return Parentesco.Avo;
                case "Pai":
                    return Parentesco.Pai;
                case "Filho":
                    return Parentesco.Filho;
                case "Neto":
                    return Parentesco.Neto;
                case "Bisneto":
                    return Parentesco.Bisneto;
                case "Trineto":
                    return Parentesco.Trineto;
                    
                    
                case "Irmao":
                    return Parentesco.Irmao;
                case "Sobrinho":
                    return Parentesco.Sobrinho;
                case "NetoDoIrmao":
                    return Parentesco.NetoDoIrmao;
                case "TrinetoDoIrmao":
                    return Parentesco.TrinetoDoIrmao;
                    
                    
                case "Tio":
                    return Parentesco.Tio;
                case "Primo":
                    return Parentesco.Primo;
                case "FilhoDoPrimo":
                    return Parentesco.FilhoDoPrimo;
                case "NetoDoPrimo":
                    return Parentesco.NetoDoPrimo;
                case "BisnetoDoPrimo":
                    return Parentesco.BisnetoDoPrimo;
                case "TrinetoDoPrimo":
                    return Parentesco.TrinetoDoPrimo;
                    
                    
                case "TioAvo":
                    return Parentesco.TioAvo;
                case "FilhoDoTioAvo":
                    return Parentesco.FilhoDoTioAvo;
                case "NetoDoTpoAvo":
                    return Parentesco.NetoDoTpoAvo;
                case "BisnetoDoTioAvo":
                    return Parentesco.BisnetoDoTioAvo;
                case "TrinetoDoTioAvo":
                    return Parentesco.TrinetoDoTioAvo;
            }
        }
        return Parentesco.NaoInformado;
    }
    
 
    @SuppressWarnings("rawtypes")
    public String getString()
    {
        Iterator<?> it = listar().entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry pair = (Map.Entry)it.next();
            if (pair.getValue().toString().equals(value))
            {
                return pair.getKey().toString();
            }
        }
        return "";
    }

    public static Map<String, Parentesco> listar()
    {
        Map<String, Parentesco> lista = new HashMap<>();
        lista.put("N/A", Parentesco.NaoInformado);
        lista.put("Trisavô(ó)", Parentesco.Trisavo);
        lista.put("Bisavô(ó)", Parentesco.Bisavo);
        lista.put("Avô(ó)", Parentesco.Avo);
        lista.put("Pai(Mãe)", Parentesco.Pai);
        lista.put("Filho(a)", Parentesco.Filho);
        lista.put("Neto/Neta", Parentesco.Neto);
        lista.put("Bisneto(a)", Parentesco.Bisneto);
        lista.put("Trineto(a)", Parentesco.Trineto);

        lista.put("Irmão/Irmã", Parentesco.Irmao);
        lista.put("Sobrinho(a)", Parentesco.Sobrinho);
        lista.put("Net(a) do Primo(a)", Parentesco.NetoDoIrmao);
        lista.put("Trineto(a) do Primo(a)", Parentesco.TrinetoDoIrmao);
        
        lista.put("Tio(a)", Parentesco.Tio);
        lista.put("Prio(a)", Parentesco.Primo);
        lista.put("Filho(a) do Primo(a)", Parentesco.FilhoDoPrimo);
        lista.put("Neto(a) do Primo(a)", Parentesco.NetoDoPrimo);
        lista.put("Bisneto(a) do Primo(a)", Parentesco.BisnetoDoPrimo);
        lista.put("Trineto(a) do Primo(a)", Parentesco.TrinetoDoPrimo);
        
        lista.put("Tio(a)", Parentesco.TioAvo);
        lista.put("Filho(a) do Ti(a) Avô(ó)", Parentesco.FilhoDoTioAvo);
        lista.put("Neto(a) do Ti(a) Avô(ó)", Parentesco.NetoDoTpoAvo);
        lista.put("Bisneto(a) do Ti(a) Avô(ó)", Parentesco.BisnetoDoTioAvo);
        lista.put("Trineto(a) do Ti(a) Avô(ó)", Parentesco.TrinetoDoTioAvo);
        return lista;
    }
}
