/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.ModelClassesDAO;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Arthurcc
 */
public class Socio {
    
    private String nome,formaDePagamento;
    Mensalidade mensalidade;
    private int id;
    private Date createdAt;
    private Date updatedAt;

    

    public Socio(String nome, String formaDePagamento) {
        this.nome = nome;
        this.formaDePagamento = formaDePagamento;
    }

    public Socio(String nome, String formaDePagamento, Mensalidade mensalidade) {
        this.nome = nome;
        this.formaDePagamento = formaDePagamento;
        this.mensalidade = mensalidade;
    }

    public Socio(String nome, String formaDePagamento, Mensalidade mensalidade, Date createdAt, Date updatedAt) {
        this.nome = nome;
        this.formaDePagamento = formaDePagamento;
        this.mensalidade = mensalidade;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

   
    
    
    public Mensalidade getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(Mensalidade mensalidade) {
        this.mensalidade = mensalidade;
    }

    
    
    
    public Socio() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }
    
    
    
}
