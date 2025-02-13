package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Departamento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nomeDoDepartamento;
	private int idDoDepartamento;
	
	public Departamento() {
	}
	
	public Departamento(String nomeDoDepartamento, int idDoDepartamento) {
		this.nomeDoDepartamento = nomeDoDepartamento;
		this.idDoDepartamento = idDoDepartamento;
	}

	public String getNomeDoDepartamento() {
		return nomeDoDepartamento;
	}

	public void setNomeDoDepartamento(String nomeDoDepartamento) {
		this.nomeDoDepartamento = nomeDoDepartamento;
	}

	public int getIdDoDepartamento() {
		return idDoDepartamento;
	}

	public void setIdDoDepartamento(int idDoDepartamento) {
		this.idDoDepartamento = idDoDepartamento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idDoDepartamento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return idDoDepartamento == other.idDoDepartamento;
	}

	
	@Override
	public String toString() {
		return "Departamento: " + nomeDoDepartamento + ", ID: " + idDoDepartamento;
	}
	
	
}
