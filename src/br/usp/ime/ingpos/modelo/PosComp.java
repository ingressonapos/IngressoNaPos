package br.usp.ime.ingpos.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PosComp {
	@Id
	@GeneratedValue
	private Long posCompId;
	private Integer notaMatematica;
	private Integer notaLogica;
	private Integer notaTecnologia;
}
