/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model.dao;

import com.mycompany.classes.Venda;
import java.util.List;
import javax.enterprise.context.Dependent;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author jose.filho
 */

@Dependent
public class VendaDAO {
    
    @Inject
    EntityManager manager;
    
    public void salvar(Venda venda){ 
       manager.getTransaction().begin();
       manager.persist(venda);
       manager.getTransaction().commit();
      
    }
     
     public void deletar(Long id){

        Venda venda= manager.find(Venda.class, id);
        
        
       manager.getTransaction().begin();
       try{
      
            manager.remove(venda);
       }catch(IllegalArgumentException ex){
            System.out.println("Impossivel remover");
       }
       manager.getTransaction().commit();
      
       
    }
    
    public void atualizar(Venda venda){
        venda = manager.find(Venda.class, venda.getId());
        
        manager.getTransaction().begin();  
        manager.merge(venda);
        manager.getTransaction().commit();
       

    
    }
    
    public void listar(){
        manager.getTransaction().begin();
        Query q = manager.createQuery("from Venda");
        List<Venda> vendas = q.getResultList();
        for(Venda v : vendas){
            System.out.println("Data: "+v.getDataVenda());
            v.listaItens();
        }
        manager.getTransaction().commit();
       
    }
    
    public void buscar(Long id){ 
     Venda  venda = manager.find(Venda.class, id);
       
            System.out.println(venda.getDataVenda());
            venda.listaItens();
       
      
       
    }
    
}
