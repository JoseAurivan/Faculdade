/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model.dao;

import com.mycompany.classes.Item;
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
public class ItemDAO {
    
    @Inject
    EntityManager manager;
    
    public void salvar(Item item){ 
       manager.getTransaction().begin();
       manager.persist(item);
       manager.getTransaction().commit();
       
       
       
    }
        public void deletar(Long id){

        Item item= manager.find(Item.class, id);
        
        
       manager.getTransaction().begin();
       try{
      
            manager.remove(item);
       }catch(IllegalArgumentException ex){
            System.out.println("Impossivel remover");
       }
       manager.getTransaction().commit();
       
       
    }
    
//    public void atualizar(ItenVenda item, Produto pro, int quant){
//        item = manager.find(ItenVenda.class, item.getId());
//        
//        manager.getTransaction().begin();
//        item.setProduto(pro);
//        item.setQtd(quant);
//        manager.merge(item);
//        manager.getTransaction().commit();
//        
//
//    
//    }
    
    public void listar(){
        manager.getTransaction().begin();
        Query q = manager.createQuery("from ItenVenda");
        List<Item> itens = q.getResultList();
        for(Item i : itens){
            System.out.println("Descricao: "+i.getProduto().getDescricao());
            System.out.println("Valor: "+i.getProduto().getValor());
            System.out.println("Quantidade: "+i.getQtd());
        }
        manager.getTransaction().commit();
        
    }
    
    public void buscar(Long id){ 
       Item item = manager.find(Item.class, id);
       
            System.out.println(item.getProduto().getDescricao() + ", "+
                    item.getProduto().getValor()+", "+
                    item.getQtd()+", Total: "+item.total());
       
       
       
    }
    
}
