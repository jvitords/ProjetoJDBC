package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import db.DB;
import model.dao.DaoFabrica;
import model.dao.FuncionarioDao;
import model.dao.impl.FuncionarioDaoJDBC;
import model.entities.Departamento;
import model.entities.Funcionario;

public class Program {

	public static void main(String[] args) throws ParseException {

		FuncionarioDao funcionarioDao = DaoFabrica.createFuncionarioDao();
		/*
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
		*/
		
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		
		/*Funcionario funcionarioInsert = new Funcionario(null, "Ana Beatriz Tavares", "anabea@gmail.com", 
				new java.sql.Date(formatoData.parse("14/03/2005").getTime()), 1500.0, new Departamento(null, 3));
		//System.out.println(funcionarioInsert.getNascimentoDoFuncionario());
		funcionarioDao.insert(funcionarioInsert);
		*/
		
		/*
		Funcionario funcionario = funcionarioDao.encontrarFuncionarioAtravesDoId(7);
		funcionario.setEmailDoFuncionario("jvduarte.santos@gmail.com");
		funcionarioDao.update(funcionario);
		*/
		
		funcionarioDao.delete(20);
	}
}
