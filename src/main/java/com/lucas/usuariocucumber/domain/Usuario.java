package com.lucas.usuariocucumber.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.lucas.usuariocucumber.util.DataUtil;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Table
@Entity
@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper = false)
public class Usuario implements Serializable{

	@Id
	@Column(name = "id_usuario")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
	@SequenceGenerator(allocationSize = 1, name = "seq_usuario", sequenceName = "seq_usuario")
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String email;
	
	@Column
	private Date dataNascimento;
	
	@Column
	private Date dataCadastro;
	
	@Column
	private String cpf;
	
	public String getDataNascimento() {
		return DataUtil.getData(dataNascimento);
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = DataUtil.getData(dataNascimento);
	}
	
	public String getDataCadastro() {
		return DataUtil.getData(dataCadastro);
	}
	
	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = DataUtil.getData(dataCadastro);
	}
}
