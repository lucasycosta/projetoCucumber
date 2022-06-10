package com.lucas.usuariocucumber.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Soma implements Serializable{
	
	@Id
	@Column(name = "id_soma")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_soma")
	@SequenceGenerator(allocationSize = 1, name = "seq_soma", sequenceName = "seq_soma")
	private Long id;
	
	@Column
	Double numero1;
	
	@Column
	Double numero2;
	
	@Column
	Double resultado;
}
