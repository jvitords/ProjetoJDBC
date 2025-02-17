package model.dao;

import java.util.List;

import model.entities.Departamento;

public interface DepartamentoDao {

	void insert(String nome);
	void update(Integer id, String nomeDoDepartamento);
	void delete(Integer id);
	Departamento encontrarDepartamentoAtravesDoId(Integer id);
	List<Departamento> encontrarTodosDepartamentos();
}
