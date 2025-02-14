package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Funcionario implements Serializable{

	
	private static final long serialVersionUID = 1L; // serve para transformar os dados em bytes
	
	private Integer idDoFuncionario;
	private String nomeDoFuncionario;
	private String emailDoFuncionario;
	private Date nascimentoDoFuncionario;
	private Double salarioeDoFuncionario;
	private Departamento departamentoDoFuncionario;
	
	public Funcionario() {
	}
	
	public Funcionario(Integer idDoFuncionario, String nomeDoFuncionario, String emailDoFuncionario,
			Date nascimentoDoFuncionario, Double salarioeDoFuncionario, Departamento departamentoDoFuncionario) {
		this.idDoFuncionario = idDoFuncionario;
		this.nomeDoFuncionario = nomeDoFuncionario;
		this.emailDoFuncionario = emailDoFuncionario;
		this.nascimentoDoFuncionario = nascimentoDoFuncionario;
		this.salarioeDoFuncionario = salarioeDoFuncionario;
		this.departamentoDoFuncionario = departamentoDoFuncionario;
	}

	
	public int getIdDoFuncionario() {
		return idDoFuncionario;
	}

	
	public void setIdDoFuncionario(int idDoFuncionario) {
		this.idDoFuncionario = idDoFuncionario;
	}

	
	public String getNomeDoFuncionario() {
		return nomeDoFuncionario;
	}

	
	public void setNomeDoFuncionario(String nomeDoFuncionario) {
		this.nomeDoFuncionario = nomeDoFuncionario;
	}

	
	public String getEmailDoFuncionario() {
		return emailDoFuncionario;
	}

	
	public void setEmailDoFuncionario(String emailDoFuncionario) {
		this.emailDoFuncionario = emailDoFuncionario;
	}

	
	public Date getNascimentoDoFuncionario() {
		return nascimentoDoFuncionario;
	}

	
	public void setNascimentoDoFuncionario(Date nascimentoDoFuncionario) {
		this.nascimentoDoFuncionario = nascimentoDoFuncionario;
	}

	
	public Double getSalarioeDoFuncionario() {
		return salarioeDoFuncionario;
	}

	
	public void setSalarioeDoFuncionario(Double salarioeDoFuncionario) {
		this.salarioeDoFuncionario = salarioeDoFuncionario;
	}

	
	public Departamento getDepartamentoDoFuncionario() {
		return departamentoDoFuncionario;
	}

	
	public void setDepartamentoDoFuncionario(Departamento departamentoDoFuncionario) {
		this.departamentoDoFuncionario = departamentoDoFuncionario;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(idDoFuncionario);
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return idDoFuncionario == other.idDoFuncionario;
	}

	
	@Override
	public String toString() {
		return "Funcionario [idDoFuncionario=" + idDoFuncionario + ", nomeDoFuncionario=" + nomeDoFuncionario
				+ ", emailDoFuncionario=" + emailDoFuncionario + ", nascimentoDoFuncionario=" + nascimentoDoFuncionario
				+ ", salarioeDoFuncionario=" + salarioeDoFuncionario + ", departamentoDoFuncionario="
				+ departamentoDoFuncionario + "]";
	}
	
	
	
}
