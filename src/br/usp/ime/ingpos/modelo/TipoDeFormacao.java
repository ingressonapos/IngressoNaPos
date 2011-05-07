package br.usp.ime.ingpos.modelo;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public enum TipoDeFormacao
{
    GRADUACAO,
    POS_GRADUACAO,
    OUTROS;
    
    private final String msgKey;

    private TipoDeFormacao()
    {
        this.msgKey = toString().toLowerCase();
    }

    public String getMsgKey()
    {
        return msgKey;
    }

    public static List<TipoDeFormacao> getTiposDeFormacao()
    {
        return new Vector<TipoDeFormacao>( Arrays.<TipoDeFormacao> asList( values() ) );
    }
    
}
