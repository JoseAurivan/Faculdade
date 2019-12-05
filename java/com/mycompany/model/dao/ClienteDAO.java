/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model.dao;

import com.mycompany.classes.Cliente;
import com.mycompany.classes.Produto;
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
public class ClienteDAO {
    
    @Inject
    EntityManager manager;
    
    public void salvar(Cliente cliente){
       
        manager.getTransaction().begin();
        //gravar um Cliente no banco
        manager.persist(cliente);
        manager.getTransaction().commit();
       
    }
    
    public Cliente buscar(long id){
        manager.getTransaction().begin();
        Cliente cliente = manager.find(Cliente.class, id);
        return cliente;
    }
    
    public Cliente buscar(String nome, String senha){
        TypedQuery<Cliente> query = manager.
                createQuery("select c from Cliente as c where c.nome =:nome and c.senha =:senha",Cliente.class);
                query.setParameter("nome", nome);
                query.setParameter("senha", senha);
                
        return query.getSingleResult();
    }
    
    public List<Cliente> clientes(){
        Query query = manager.createQuery("from Cliente");
        return query.getResultList();
    }    
        
    public void remove(long id){
        manager.getTransaction().begin();
        manager.remove(manager.find(Cliente.class, id));
        manager.getTransaction().commit();
    }
    
    public void update(Cliente cliente){
  
        
        manager.getTransaction().begin();  
        manager.merge(cliente);
        manager.getTransaction().commit();
      
    }
    
}
