package br.usp.ime.ingpos.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Perfil
    implements
        Serializable
{
    private static final long serialVersionUID = 5653550355165213879L;

    public static final String DESCRICAO_ADMINISTRADOR = "Administrador";
    public static final String DESCRICAO_CANDIDATO = "Candidato";
    public static final String DESCRICAO_COORDENADOR = "Coordenador";
    public static final String DESCRICAO_PROFESSOR = "Professor";
    public static final String DESCRICAO_SECRETARIO = "Secretario";

    @Id
    @GeneratedValue
    private Long perfilID;

    @Column( unique = true )
    private String descricao;

    public Perfil()
    {
    }

    public Long getPerfilID()
    {
        return perfilID;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(
        String descricao )
    {
        this.descricao = descricao;
    }

}
