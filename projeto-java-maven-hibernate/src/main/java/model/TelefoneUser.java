package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TelefoneUser {

	@Id //Id obrigatório
	@GeneratedValue(strategy = GenerationType.AUTO) //Gerar IDs de forma automática
	private Long id;

	@Column(nullable = false) // Utilizado para informar que a coluna tipo é obrigatória no banco de dados
	private String tipo;

	@Column(nullable = false) // Utilizado para informar que a coluna número é obrigatória no banco de dados
	private String numero;

	@ManyToOne(optional = false, fetch = FetchType.EAGER) // Vários telefones para uma pessoa "ManyToOne = muitos para um" referencia para a pessoa que é
															
	private UsuarioPessoa usuarioPessoa;// Instânciado o objeto

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public UsuarioPessoa getUsuarioPessoa() {
		return usuarioPessoa;
	}

	public void setUsuarioPessoa(UsuarioPessoa usuarioPessoa) {
		this.usuarioPessoa = usuarioPessoa;
	}

}
