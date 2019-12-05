/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

import com.mycompany.model.dao.ProdutoDAO;

import com.mycompany.classes.Produto;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;

/**
 *
 * @author jose.filho
 */
@Controller
public class ProdutosController {
    
    
    @Inject
    ProdutoDAO dao;
    
    @Inject
    Validator validator;
     
    public void form(){
    }
   
    public List<Produto> lista(){
        return dao.produtos();
    }
    
    public void salvar(Produto produto, Result result){
        validator.validate(produto);
        
        validator.onErrorForwardTo(this).form();
        
        if(produto.getId() == null)
            dao.salvar(produto);
        
        else
            dao.update(produto);
        
        
        result.forwardTo(this).lista();
    }
    
    public void excluir(Long id, Result result){
        dao.remove(id);
        result.forwardTo(this).lista();
    }
    
    public void alterar(Long id, Result result){
        Produto produto = dao.buscar(id);
        result.include(produto);
        result.forwardTo(this).form();
    }
}
