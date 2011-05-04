package br.usp.ime.ingpos.services;

public class ProcessoSeletivoException
    extends
        RuntimeException
{

}

enum Erros
{
    ERRO_DATA_INVALIDA;

    private final String msg;

    private Erros()
    {
        msg = name().toLowerCase();
    }

    public String getMensagem()
    {
        return msg;
    }
}