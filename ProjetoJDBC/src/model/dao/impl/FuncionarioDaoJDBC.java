package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DBException;
import model.dao.FuncionarioDao;
import model.entities.Departamento;
import model.entities.Funcionario;

public class FuncionarioDaoJDBC implements FuncionarioDao {

	private Connection conexao;

	public FuncionarioDaoJDBC(Connection conexao) {
		this.conexao = conexao;
	}

	@Override
	public void insert(Funcionario funcionario) {
		
		PreparedStatement consultaSQL = null;
		ResultSet resultadoSQL = null;
		
		try {
 			consultaSQL =  conexao.prepareStatement("INSERT INTO seller "
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			consultaSQL.setString(1, funcionario.getNomeDoFuncionario());
			consultaSQL.setString(2, funcionario.getEmailDoFuncionario());
			consultaSQL.setDate(3, new java.sql.Date(funcionario.getNascimentoDoFuncionario().getTime()));
			consultaSQL.setDouble(4, funcionario.getSalarioeDoFuncionario());
			consultaSQL.setInt(5, funcionario.getDepartamentoDoFuncionario().getIdDoDepartamento());
			
			int linhasAlteradas = consultaSQL.executeUpdate();
			
			if(linhasAlteradas < 1) {
				System.out.println("INSERT deu falha!");
			}
			else {
				ResultSet chaveGerada = consultaSQL.getGeneratedKeys();
				if (chaveGerada.next()) {
					int id = chaveGerada.getInt(1);
					funcionario.setIdDoFuncionario(id);
				}
				DB.closeResultSet(resultadoSQL);
				System.out.println("INSERT realizado com sucesso! Funcionário de ID: " + funcionario.getIdDoFuncionario() + " foi registrado");
			}
		} 
		catch (SQLException e) {
			throw new DBException("Erro ao fazer INSERT no banco de dados..." + e.getMessage());
		}
		catch (Exception e) {
			throw new DBException("Erro ao fazer INSERT no banco de dados..." + e.getMessage());
		}
		finally {
			DB.closeStatement(consultaSQL);
		
		}
		
	}

	@Override
	public void update(Funcionario funcionario) {

		PreparedStatement consultaSQL = null;
		ResultSet resultadoSQL = null;
		
		try {
			consultaSQL =  conexao.prepareStatement("UPDATE seller " + 
					"SET Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ? " +
							"WHERE Id = ?");
			consultaSQL.setString(1, funcionario.getNomeDoFuncionario());
			consultaSQL.setString(2, funcionario.getEmailDoFuncionario());
			consultaSQL.setDate(3, new java.sql.Date(funcionario.getNascimentoDoFuncionario().getTime()));
			consultaSQL.setDouble(4, funcionario.getSalarioeDoFuncionario());
			consultaSQL.setInt(5, funcionario.getDepartamentoDoFuncionario().getIdDoDepartamento());
			consultaSQL.setInt(6, funcionario.getIdDoFuncionario());			
			int linhasAlteradas = consultaSQL.executeUpdate();
			
			if(linhasAlteradas < 1) {
				System.out.println("UPDATE deu falha!");
			}
			else {
				System.out.println("UPDATE realizado com sucesso!");
			}
			
		} 
		catch (SQLException e) {
			throw new DBException("Erro ao fazer UPDATE no banco de dados..." + e.getMessage());
		}
		catch (Exception e) {
			throw new DBException("Erro ao fazer UPDATE no banco de dados..." + e.getMessage());
		}
		finally {
			DB.closeStatement(consultaSQL);
		}
	}

	@Override
	public void delete(Integer id) {
		
		PreparedStatement instrucaoSQL = null;
		
		try {
			instrucaoSQL = conexao.prepareStatement("DELETE FROM seller "
					+ "WHERE Id = ?");
			instrucaoSQL.setInt(1, id);
			int linhasAfetadas = instrucaoSQL.executeUpdate();
			if(linhasAfetadas == 0) {
				System.out.println("ID não encontrado!");
			}
			else {
				System.out.println("Funcionário deletado!");
			}
		} 
		catch (SQLException e) {
			throw new DBException("Erro ao remover funcionário");
		}
		finally {
			DB.closeStatement(instrucaoSQL);
		}
	}

	@Override
	public Funcionario encontrarFuncionarioAtravesDoId(Integer id) {

		PreparedStatement consultaSQL = null;
		ResultSet resultadoSQL = null;
		
		/* Com essa consulta abaixo, consigo pegar as informações de um funcionario com certo ID, 
		 e as informações do departamento dele */ 
		 try {
			 consultaSQL = conexao.prepareStatement(
					"SELECT seller.*,department.Name as DepName " + "FROM seller INNER JOIN department "
							+ "ON seller.DepartmentId = department.Id " + "WHERE seller.Id = ?;");
			 consultaSQL.setInt(1, id);

			 resultadoSQL = consultaSQL.executeQuery();
			 if (resultadoSQL.next()) { // confere se tem algo na próxima linha(que no caso é a primeira) do "resultadoSQL"
				 
				 Departamento departamento = instanciarDepartamento(resultadoSQL);
				
				 Funcionario funcionario = instanciarFuncionario(resultadoSQL, instanciarDepartamento(resultadoSQL));
				 return funcionario;
			 }
			 return null;
		}
		 catch (SQLException e) {
			 throw new DBException("Erro ao filtrar funcionário através do ID. " + e.getMessage());
		 }
		 finally {
			DB.closeStatement(consultaSQL);
			DB.closeResultSet(resultadoSQL);
		}
	}
	
	@Override
	public List<Funcionario> encontrarFuncionariosDeUmDepartamento(Departamento departamentoEscolhido) {
		
		PreparedStatement consultaSQL = null;
		ResultSet resultadoSQL = null;
		List<Funcionario> lista = new ArrayList<Funcionario>();
		
		/* Com essa consulta abaixo, consigo pegar as informações de um funcionario com certo ID, 
		 e as informações do departamento dele */ 
		 try {
			 consultaSQL = conexao.prepareStatement(
					"SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE DepartmentId = ? "
					+ "ORDER BY Name;");
			 
			 consultaSQL.setInt(1, departamentoEscolhido.getIdDoDepartamento());
			 resultadoSQL = consultaSQL.executeQuery();
			 Map<Integer, Departamento> map = new HashMap<Integer, Departamento>();
			 
			 while (resultadoSQL.next()) { // confere se tem algo na próxima linha(como se fosse um ForEach
				 
				 Departamento departamento = map.get(resultadoSQL.getObject("DepartmentId"));
				 if (departamento == null) {
					 departamento = instanciarDepartamento(resultadoSQL);
				 }
				 
				 Funcionario funcionario = instanciarFuncionario(resultadoSQL, departamento);
				 lista.add(funcionario);
			 }
			 return lista;
		}
		 catch (SQLException e) {
			 throw new DBException("Erro ao filtrar funcionário através do ID. " + e.getMessage());
		 }
		 finally {
			DB.closeStatement(consultaSQL);
			DB.closeResultSet(resultadoSQL);
		}
	}

	@Override
	public List<Funcionario> encontrarTodosFuncionarios() {

		PreparedStatement consultaSQL = null;
		ResultSet resultadoSQL = null;
		List<Funcionario> lista = new ArrayList<Funcionario>();
		
		/* Com essa consulta abaixo, consigo pegar as informações de um funcionario com certo ID, 
		 e as informações do departamento dele */ 
		 try {
			 consultaSQL = conexao.prepareStatement(
					"SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "ORDER BY Name;");
			 
			 resultadoSQL = consultaSQL.executeQuery();
			 Map<Integer, Departamento> map = new HashMap<Integer, Departamento>();
			 
			 while (resultadoSQL.next()) { // confere se tem algo na próxima linha(como se fosse um ForEach
				 
				 Departamento departamento = map.get(resultadoSQL.getObject("DepartmentId"));
				 if (departamento == null) {
					 departamento = instanciarDepartamento(resultadoSQL);
				 }
				 
				 Funcionario funcionario = instanciarFuncionario(resultadoSQL, departamento);
				 lista.add(funcionario);
			 }
			 return lista;
		}
		 catch (SQLException e) {
			 throw new DBException("Erro ao filtrar funcionário através do ID. " + e.getMessage());
		 }
		 finally {
			DB.closeStatement(consultaSQL);
			DB.closeResultSet(resultadoSQL);
		}
		
	}

	public static Departamento instanciarDepartamento(ResultSet resultadoSQL) throws SQLException {
		// instanciando o departamento com nome e id recebido da consulta  SQL(resultadoSQL)
		Departamento departamento = new Departamento(resultadoSQL.getString("DepName"), resultadoSQL.getInt("DepartmentId"));
		return departamento;
	}
	
	private Funcionario instanciarFuncionario(ResultSet resultadoSQL, Departamento departamento) throws SQLException {
		// instanciando o funcionario informações recebidas da consulta  SQL(resultadoSQL)
		Funcionario funcionario = new Funcionario(resultadoSQL.getInt("Id"), resultadoSQL.getString("Name"), 
				resultadoSQL.getString("Email"), resultadoSQL.getDate("BirthDate"), resultadoSQL.getDouble("BaseSalary"), 
				departamento);
		return funcionario;
	}

	
	
}
