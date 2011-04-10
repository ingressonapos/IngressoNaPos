package br.usp.ime.ingpos.modelo;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public enum TipoCedulaDeIdentidade
{
    RG,
    RNE,
    PASSAPORTE;

    private final String msgKey;

    private TipoCedulaDeIdentidade()
    {
        this.msgKey = toString().toLowerCase();
    }

    public String getMsgKey()
    {
        return msgKey;
    }

    public static List<TipoCedulaDeIdentidade> getTiposCedulaIdentidade()
    {
        return new Vector<TipoCedulaDeIdentidade>(
            Arrays.<TipoCedulaDeIdentidade> asList( values() ) );
    }
}
