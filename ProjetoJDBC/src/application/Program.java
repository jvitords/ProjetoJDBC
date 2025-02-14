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
		List<Funcionario> listaFuncionarios = funcionarioDao.encontrarFuncionariosDeUmDepartamento(new Departamento(null, 1));
		String nomeDoDepartamento = listaFuncionarios.get(0).getDepartamentoDoFuncionario().getNomeDoDepartamento();
		System.out.println("DEPARTAMENTO: " + nomeDoDepartamento); // mostrar o nome do departamento
		listaFuncionarios.forEach(f -> System.out.println("Nome: " + f.getNomeDoFuncionario()));
	}
}
