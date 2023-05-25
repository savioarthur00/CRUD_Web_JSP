/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.ControllerDAO;

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
public class UsuarioDAO {
        
    
    public boolean incluirUsuario(Usuario u) {
       
    String sql ="INSERT INTO usuarios (login,senha,tipo) VALUES (?,?,?)";
    Connection c = null;
    PreparedStatement statement = null;
    
        try {
            c = Conexao.getConnection();
            statement = c.prepareStatement(sql);
            statement.setString(1, u.getLogin());
            statement.setString(2, u.getSenha());
            statement.setString(3, u.getTipo());
            
                                
            
            statement.execute();           
           
            
            
            
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(),e);
           
        }
        finally{
            Conexao.closeConnection( c,statement);
            
            
        }
        return true;
    
    }

    public boolean alterarUsuario(Usuario u) {
        
    String sql = "UPDATE usuarios SET login= ?,senha= ?,tipo=?  WHERE id = ?";
    
    Connection connection = null;
    PreparedStatement statement = null;
    
        try {
            connection = Conexao.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, u.getLogin());
            statement.setString(2, u.getSenha());     
            statement.setString(3, u.getTipo()); 
            statement.setInt(4, u.getId());
            
            statement.execute();
            
            
            
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar usuario");
           
        }
        return true;
    }
    
    public void excluirUsuario(Usuario u) throws SQLException{
    
        String sql = "DELETE FROM usuarios WHERE id = ? ";
        
        Connection c = null;
        PreparedStatement statement = null;
        
        try {
            
            c = Conexao.getConnection();
            statement = c.prepareStatement(sql);
            statement.setInt(1, u.getId());
            statement.execute();
            
            
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar usuario");
        } finally {
            Conexao.closeConnection(c,statement);
        }
        
    
    
    }
    
    public List<Usuario> getAll(){
        
        String sql = "SELECT * FROM usuarios";
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        List<Usuario> user = new ArrayList<>();
        
        try {
            connection = Conexao.getConnection();
            statement= connection.prepareStatement(sql);
            
            
            resultSet=  statement.executeQuery();
            
            
            while (resultSet.next()){
            Usuario u1 = new Usuario();
            u1.setId(resultSet.getInt("id"));
            u1.setLogin(resultSet.getString("login"));
            u1.setSenha(resultSet.getString("senha"));
            u1.setTipo(resultSet.getString("tipo"));
          
            
           user.add(u1);
            
            }
            
            
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar Usuarios");
        }
        
        finally{
        Conexao.closeConnection(connection,statement);
        
        
        }
        return user;
        
        
        
    }
    
    public Usuario buscarUsuario(int id) {
    String sql = "SELECT * FROM usuarios WHERE id = ?";
    
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    
    try {
        connection = Conexao.getConnection();
        statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        
        if (resultSet.next()) {
            Usuario u = new Usuario();
            u.setId(resultSet.getInt("id"));
            u.setLogin(resultSet.getString("login"));
            u.setSenha(resultSet.getString("senha"));
            u.setTipo(resultSet.getString("tipo"));
            return u;
        } else {
            return null;
        }
        
    } catch (Exception e) {
        throw new RuntimeException("Erro ao buscar usuario");
    } finally {
        Conexao.closeConnection(connection, statement, resultSet);
    }
   }
    
    
}
