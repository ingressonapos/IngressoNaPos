package br.usp.ime.ingpos.modelo;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public enum TipoEstadoCivil
{
    SOLTEIRO,
    CASADO,
    DIVORCIADO,
    VIUVO;

    private final String msgKey;

    private TipoEstadoCivil()
    {
        this.msgKey = toString().toLowerCase();
    }

    public String getMsgKey()
    {
        return msgKey;
    }

    public static List<TipoEstadoCivil> getTiposEstadoCivil()
    {
        return new Vector<TipoEstadoCivil>( Arrays.<TipoEstadoCivil> asList( values() ) );
    }
}
