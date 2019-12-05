/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import annotations.Public;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import com.mycompany.model.dao.ClienteDAO;
import com.mycompany.classes.Cliente;
import com.mycompany.classes.SessionCliente;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jose.filho
 */
@Controller

public class ClientesController {
    @Inject
    ClienteDAO dao;
    
    @Inject
    private Result result;
    
    @Inject
    private HttpSession session;

    @Inject
    SessionCliente sessionCliente;

    @Public
    public void form(){}
    
    public void logado(){}
    
    @Public
    public void login(){}
    
    public List<Cliente> lista(){
        return dao.clientes();
    }
    
    @Public
    public void salvar(Cliente cliente){
        
        //Long id = cliente.getId();
        if(cliente.getId() == null){
            dao.salvar(cliente);
        }
        else{
           dao.update(cliente);
        }
    
        Cliente c = dao.buscar(cliente.getId());
        sessionCliente.setCliente(c);
        
        result.redirectTo(this).logado();
        
    }
    
    public void logout(){
        session.invalidate();
        result.redirectTo(this).login();
    }
    
    @Public
    public void logar(Cliente cliente){
        cliente = dao.buscar(cliente.getNome(), cliente.getSenha());
        sessionCliente.setCliente(cliente);
        result.redirectTo(this).logado();
    }
    
    public void excluir (Long id){
        dao.remove(id);
        result.of(this).logado();
    }
    
    public void alterar (Long id, Result result){
        Cliente cliente = dao.buscar(id);
        result.include(cliente);
        result.of(this).form();
    }
}
