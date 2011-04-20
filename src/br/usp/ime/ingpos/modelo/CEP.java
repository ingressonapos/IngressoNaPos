package br.usp.ime.ingpos.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CEP
    implements
        Serializable
{
    private static final long serialVersionUID = 5653550355165213879L;

    @Column( length = 9 )
    private String cep;

	public CEP()
    {
    }
	
    public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
