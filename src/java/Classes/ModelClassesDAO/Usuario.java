/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.ModelClassesDAO;

import java.util.Date;

/**
 *
 * @author Arthurcc
 */
public class Usuario {
   private int id;
   private String login,senha,tipo;
   private Date createdAt;
   private Date updatedAt;
   
   

    public Usuario() {
    }
   
   

    public Usuario(String login, String senha, String tipo) {
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
    }

    public Usuario(String login, String senha, String tipo, Date createdAt, Date updatedAt) {
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
   
   

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", login=" + login + ", senha=" + senha + ", tipo=" + tipo + '}';
    }
    
    

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
   
   
   
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
   
   
    
}
