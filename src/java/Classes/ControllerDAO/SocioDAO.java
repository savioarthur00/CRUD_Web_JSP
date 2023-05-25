/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.ControllerDAO;

import Classes.ModelClassesDAO.Mensalidade;
import Classes.ModelClassesDAO.Socio;
import Classes.ModelClassesDAO.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.Conexao;

/**
 *
 * @author Arthurcc
 */
public class SocioDAO {
        
    
    public boolean incluirSocio(Socio s) {
       
    String sql ="INSERT INTO socios (nome,pagamento,mensalidade) VALUES (?,?,?)";
    Connection c = null;
    PreparedStatement statement = null;
    
        try {
            c = Conexao.getConnection();
            statement = c.prepareStatement(sql);
            statement.setString(1,s.getNome());
            statement.setString(2, s.getFormaDePagamento());
            statement.setObject(3, s.getMensalidade());
          
            statement.execute();           
            
            
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(),e);
          
        }
        finally{
            Conexao.closeConnection( c,statement);
            
        }
        return true;
    
    }

    public boolean alterarSocio(Socio s) {
        
    String sql = "UPDATE socios SET nome= ?,pagamento= ?,mensalidade=?  WHERE id = ?";
    
    Connection connection = null;
    PreparedStatement statement = null;
    
        try {
            connection = Conexao.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, s.getNome());
            statement.setString(2, s.getFormaDePagamento());     
            statement.setObject(3, s.getMensalidade()); 
            statement.setInt(4, s.getId());
            
            statement.execute();
            
            
            
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar socio");
           
        }
        return true;
    }
    
    public void excluirSocio(Socio s) throws SQLException{
    
        String sql = "DELETE FROM socios WHERE id = ? ";
        
        Connection c = null;
        PreparedStatement statement = null;
        
        try {
            
            c = Conexao.getConnection();
            statement = c.prepareStatement(sql);
            statement.setInt(1, s.getId());
            statement.execute();
            
            
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar socio");
        } finally {
            Conexao.closeConnection(c,statement);
        }
        
    
    
    }
    
    public List<Socio> getAll(){
        
        String sql = "SELECT * FROM socios";
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        List<Socio> socios = new ArrayList<>();
        
        try {
            connection = Conexao.getConnection();
            statement= connection.prepareStatement(sql);
            
            
            resultSet=  statement.executeQuery();
            
            
            while (resultSet.next()){
            Socio s = new Socio();
            s.setId(resultSet.getInt("id"));
            s.setNome(resultSet.getString("nome"));
            s.setFormaDePagamento(resultSet.getString("pagamento"));
            Mensalidade m = new Mensalidade();
            s.setMensalidade(m);
            s.setMensalidade((Mensalidade) resultSet.getArray("mensalidade"));
          
            
           socios.add(s);
            
            }
            
            
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar Usuarios");
        }
        
        finally{
        Conexao.closeConnection(connection,statement);
        
        
        }
        return socios;
        
        
        
    }
    
    public Socio buscarSocio(int id) {
    String sql = "SELECT * FROM socios WHERE id = ?";
    
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    
    try {
        connection = Conexao.getConnection();
        statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        
        if (resultSet.next()) {
            Socio s = new Socio();
            s.setId(resultSet.getInt("id"));
            s.setNome(resultSet.getString("nome"));
            s.setFormaDePagamento(resultSet.getString("pagamento"));
            Mensalidade m = new Mensalidade();
            s.setMensalidade(m);
            s.setMensalidade((Mensalidade) resultSet.getArray("mensalidade"));
            return s;
        } else {
            return null;
        }
        
    } catch (Exception e) {
        throw new RuntimeException("Erro ao buscar socio");
    } finally {
        Conexao.closeConnection(connection, statement, resultSet);
    }
   }
    
    
}
