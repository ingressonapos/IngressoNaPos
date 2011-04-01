package modelo;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;


@Entity
@Table(name = "endereco")
public class Endereco {

	private String logadouro;
	private String numero;
	private String complemento;
	private String cidade;
	private String estado;
	private String pais;
	private String cep;

	@Embedded
	private Telefone telefones;
}
