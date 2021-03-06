package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Empresa;



public class EmpresaDAO {

		public int criar(Empresa empresa) {
			String sqlInsert = "INSERT INTO empresa(cnpj, razaoSocial, conjunto, horarioDeFuncionamento, temperaturaDoArCondicionado, horarioDoArCondicionado) VALUES (?, ?, ?, ?, ?, ?)";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
				stm.setString(1, empresa.getCnpj());
				stm.setString(2, empresa.getRazaoSocial());
				stm.setString(3, empresa.getConjunto());
				stm.setString(4, empresa.getHorarioDeFuncionamento());
				stm.setString(5, empresa.getTemperaturaDoArCondicionado());
				stm.setString(6, empresa.getHorarioDoArCondicionado());
				stm.execute();
				String sqlQuery = "SELECT LAST_INSERT_ID()";
				try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
						ResultSet rs = stm2.executeQuery();) {
					if (rs.next()) {
						empresa.setId(rs.getInt(1));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return empresa.getId();
		}
		
		public void atualizar( Empresa empresa) {
			String sqlUpdate = "UPDATE empresa SET cnpj=?, razaoSocial=?, conjunto=?, horarioDeFuncionamento=?, temperaturaDoArCondicionado=?, horarioDoArCondicionado=? WHERE id=?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
				stm.setString(1, empresa.getCnpj());
				stm.setString(2, empresa.getRazaoSocial());
				stm.setString(3, empresa.getConjunto());
				stm.setString(4, empresa.getHorarioDeFuncionamento());
				stm.setString(5, empresa.getTemperaturaDoArCondicionado());
				stm.setString(6, empresa.getHorarioDoArCondicionado());
				stm.setInt(7, (int) empresa.getId());
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		public void excluir(int id) {
			String sqlDelete = "DELETE FROM empresa WHERE id = ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
				stm.setInt(1, id);
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public Empresa carregar(int id) {
			Empresa empresa = new Empresa();
			empresa.setId(id);
			String sqlSelect = "SELECT cnpj, razaoSocial, conjunto, horarioDeFuncionamento, temperaturaDoArCondicionado, horarioDoArCondicionado FROM empresa WHERE empresa.id = ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setInt(1, empresa.getId());
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						empresa.setCnpj(rs.getString("cnpj"));
						empresa.setRazaoSocial(rs.getString("razaoSocial"));
						empresa.setConjunto(rs.getString("Conjunto"));
						empresa.setHorarioDeFuncionamento(rs.getString("horarioDeFuncionamento"));
						empresa.setTemperaturaDoArCondicionado(rs.getString("temperaturaDoArCondicionado"));
						empresa.setHorarioDoArCondicionado(rs.getString("horarioDoArCondicionado"));
					} else {
						empresa.setId(1);
						empresa.setCnpj(null);
						empresa.setRazaoSocial(null);
						empresa.setConjunto(null);
						empresa.setHorarioDeFuncionamento(null);
						empresa.setTemperaturaDoArCondicionado(null);
						empresa.setHorarioDoArCondicionado(null);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
			return empresa;
		}
		
		public ArrayList<Empresa> listarEmpresas() {
			Empresa empresa;
			ArrayList<Empresa> lista = new ArrayList<>();
			String sqlSelect = "SELECT id, cnpj, razaoSocial, conjunto, horarioDeFuncionamento, temperaturaDoArCondicionado, horarioDoArCondicionado FROM empresa;";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						empresa = new Empresa();
						empresa.setId(rs.getInt("id"));
                        empresa.setCnpj(rs.getString("cnpj"));
						empresa.setRazaoSocial(rs.getString("razaoSocial"));
						empresa.setConjunto(rs.getString("conjunto"));
						empresa.setHorarioDeFuncionamento(rs.getString("horarioDeFuncionamento"));
						empresa.setTemperaturaDoArCondicionado(rs.getString("temperaturaDoArCondicionado"));
						empresa.setHorarioDoArCondicionado(rs.getString("horarioDoArCondicionado"));
						
						lista.add(empresa);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
			return lista;
		}
		
		public ArrayList<Empresa> listarEmpresas(String chave) {
			Empresa empresa;
			ArrayList<Empresa> lista = new ArrayList<>();
			String sqlSelect = "SELECT id, cnpj, razaoSocial, conjunto, horarioDeFuncionamento, temperaturaDoArCondicionado, horarioDoArCondicionado FROM empresa where upper(cnpj) like ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						empresa = new Empresa();
						empresa.setId(rs.getInt("id"));
                        empresa.setCnpj(rs.getString("cnpj"));
						empresa.setRazaoSocial(rs.getString("razaoSocial"));
						empresa.setConjunto(rs.getString("conjunto"));
						empresa.setHorarioDeFuncionamento(rs.getString("horarioDeFuncionamento"));
						empresa.setTemperaturaDoArCondicionado(rs.getString("temperaturaDoArCondicionado"));
						empresa.setHorarioDoArCondicionado(rs.getString("horarioDoArCondicionado"));
						
						lista.add(empresa);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
			return lista;
		}

		/*public ArrayList<Empresa> listarEmpresas(String chave) {
			// TODO Auto-generated method stub
			return null;
		}  */


}
