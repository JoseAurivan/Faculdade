/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author jose.filho
 */
@SessionScoped
@Named("venda")
@Entity
@Table(name="tb_venda")
public class Venda implements Serializable{
    
    @GeneratedValue
    @Id
    private Long id;
        
    private String dataVenda;
    
    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name="id_venda")
    private List<Item> itens = new ArrayList();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
    
    public double total(){
        double total = 0;
        for(Item iten : itens){
            total += iten.total();
        }
        return total;
    }
    
    public void listaItens(){
        for(Item iten : itens){
            System.out.println("Descricao:"+iten.getProduto().getDescricao());
            System.out.println("Valor:"+iten.getProduto().getValor());
            System.out.println("Quantidade:"+iten.getQtd());
        }
    }
    
    
}
