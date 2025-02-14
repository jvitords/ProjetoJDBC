package application;

import java.util.Date;
import java.util.List;

import db.DB;
import model.dao.DaoFabrica;
import model.dao.FuncionarioDao;
import model.dao.impl.FuncionarioDaoJDBC;
import model.entities.Departamento;
import model.entities.Funcionario;

public class Program {

	public static void main(String[] args) {

		FuncionarioDao funcionarioDao = DaoFabrica.createFuncionarioDao();
		System.out.println("===== FUNCIONÁRIOS DE CERTO ID =====");
		System.out.println(funcionarioDao.encontrarFuncionarioAtravesDoId(7));
		
		System.out.println("\n===== FUNCIONÁRIOS DE CERTO DEPARTAMENTO =====");
		List<Funcionario> lista1 = funcionarioDao.encontrarFuncionariosDeUmDepartamento(new Departamento(null, 1));
		String nomeDoDepartamento1 = lista1.get(0).getDepartamentoDoFuncionario().getNomeDoDepartamento();
		System.out.println("DEPARTAMENTO: " + nomeDoDepartamento1); // mostrar o nome do departamento
		lista1.forEach(f -> System.out.println("Nome: " + f.getNomeDoFuncionario()));
		
		System.out.println("\n===== TODOS OS FUNCIONÁRIOS =====");
		List<Funcionario> lista2 = funcionarioDao.encontrarTodosFuncionarios();
		lista2.forEach(f -> System.out.println("Nome: " + f.getNomeDoFuncionario() + ", " + f.getDepartamentoDoFuncionario().getNomeDoDepartamento()));
	}
}
