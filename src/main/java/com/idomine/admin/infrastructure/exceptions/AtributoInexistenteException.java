package com.idomine.admin.infrastructure.exceptions;

public class AtributoInexistenteException extends Exception
{
    private static final long serialVersionUID = 1L;

    public AtributoInexistenteException(String msg)
    {
        super(msg);
        System.err.println(msg);
    }

}
