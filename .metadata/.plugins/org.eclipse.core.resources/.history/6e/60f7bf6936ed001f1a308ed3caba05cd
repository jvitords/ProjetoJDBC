package model.dao;

import java.util.List;

import model.entities.Departamento;
import model.entities.Funcionario;

public interface FuncionarioDao {
	
	void insert(Funcionario funcionario);
	void update(Funcionario funcionario);
	void delete(Funcionario funcionario);
	Funcionario encontrarFuncionarioAtravesDoId(Integer id);
	List<Funcionario> encontrarTodosFuncionarios();
	List<Funcionario> encontrarFuncionariosDeUmDepartamento(Departamento departamento);
}
