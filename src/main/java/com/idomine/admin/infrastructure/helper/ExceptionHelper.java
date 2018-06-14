package com.idomine.admin.infrastructure.helper;

import java.sql.SQLException;
import java.util.StringJoiner;

import javax.persistence.PersistenceException;

public class ExceptionHelper
{

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void throwException(Throwable exception, Object dummy) throws T
    {
        throw (T) exception;
    }

    public static void throwException(Throwable exception)
    {
        ExceptionHelper.<RuntimeException> throwException(exception, null);
    }

    public static void throwExceptionSe(boolean condicao, Throwable exception)
    {
        if (condicao)
        {
            ExceptionHelper.<RuntimeException> throwException(exception, null);
        }
    }

    public static String databaseSqlException(Exception ex)
    {
        if ( ex.getCause()  instanceof PersistenceException)
        {
            return databaseSqlException((RuntimeException)ex.getCause()  );
        }
        return ex.getMessage();
    }

    public static String databaseSqlException(RuntimeException ex)
    {
        StringJoiner result = new StringJoiner(" ");
        Throwable throwable = ex;

        while (throwable != null && !(throwable instanceof SQLException))
        {
            throwable = throwable.getCause();
        }

        if (throwable instanceof SQLException)
        {
            if (ignoreSQLException(((SQLException) throwable).getSQLState()) == false)
            {
                SQLException sqlex = (SQLException) throwable;
                //result.add("SQL State: " + sqlex.getSQLState());
                //result.add("Error Code: " + sqlex.getErrorCode());
                result.add("Message: " + primeiraLinhaMsg( sqlex.getMessage() ));
            }
        }
        return result.toString();
    }

    private static boolean ignoreSQLException(String sqlState)
    {
        // TODO - erros que devem ser ignorados são tratados aqui
        return false;
    }

    private static String primeiraLinhaMsg(String msg)
    {
        String[] m = msg.split("\n");
        if (m.length > 1)
        {
          return m[0];
        }
        else
        {
            return msg;
        }
    }

}
