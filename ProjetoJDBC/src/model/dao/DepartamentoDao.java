package model.dao;

import java.util.List;

import model.entities.Departamento;

public interface DepartamentoDao {

	void insert(Departamento Departamento);
	void update(Departamento Departamento);
	void delete(Departamento Departamento);
	Departamento encontrarDepartamentoAtravesDoId(Integer id);
	List<Departamento> encontrarTodosDepartamentos();
}
