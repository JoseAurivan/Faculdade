/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model.dao;

import annotations.Public;
import com.mycompany.classes.Cliente;
import com.mycompany.classes.Venda;
import java.util.List;
import javax.enterprise.context.Dependent;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
    
    public List<Venda> listar(){
        manager.getTransaction().begin();
        Query q = manager.createQuery("from Venda");
        manager.getTransaction().commit();
        return q.getResultList();
       
    }
    

    public List<Venda> listarPorCliente(Long id){
        TypedQuery<Venda> query = manager.createQuery("select v from Venda v where v.cliente.id =:id",Venda.class);
                query.setParameter("id", id);
                return query.getResultList();
    }
    
    public void buscar(Long id){ 
     Venda  venda = manager.find(Venda.class, id);
       
            System.out.println(venda.getDataVenda());
            venda.listaItens();
       
      
       
    }
    
}
