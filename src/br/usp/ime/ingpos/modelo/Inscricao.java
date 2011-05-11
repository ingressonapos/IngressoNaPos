package br.usp.ime.ingpos.modelo;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Inscricao implements Serializable{
	private static final long serialVersionUID = 2908521459850511243L;
	
	private ProcessoSeletivo processoSeletivo;
	
	private String outrosProcessosSeletivos;
}
