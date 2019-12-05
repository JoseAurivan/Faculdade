/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import com.mycompany.classes.Cliente;
import com.mycompany.model.dao.ItemDAO;
import com.mycompany.model.dao.ProdutoDAO;
import com.mycompany.model.dao.VendaDAO;
import com.mycompany.classes.Item;
import com.mycompany.classes.Produto;
import com.mycompany.classes.SessionCliente;
import com.mycompany.classes.Venda;
import com.mycompany.model.dao.ClienteDAO;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jose.filho
 */
@Controller
public class VendasController {
    
    @Inject
    private Venda venda;
      
    @Inject
    private Result result;
    
    @Inject 
    private ProdutoDAO pdao;
    
    @Inject
    private HttpSession session;
    
    @Inject
    private Validator validate;
    
    @Inject
    private VendaDAO vdao;
    
    @Inject
    private ClienteDAO cdao;
    
    @Inject
    private SessionCliente scliente;
       
    
    public void formv(){
        result.include("produtos",pdao.produtos());
    }
    
    public void addItem(Item item){
        validate.validate(item);
        validate.onErrorRedirectTo(this).formv();
        
        Produto p = pdao.buscar(item.getProduto().getId());
        item.setProduto(p);
        venda.getItens().add(item);
        result.include("vendaprod",venda);
        result.redirectTo(this).formv();
    }
   
   
    
    public void logout(){
        session.invalidate();
        result.redirectTo(ClientesController.class).login();
    }
    
    public void salvarVenda(){ 

        Venda v = new Venda();
        v.setDataVenda("21/11/2019");
        v.setItens(venda.getItens());
        
        v.setCliente(scliente.getCliente());
        
        validate.addIf(v.getItens().isEmpty(), new I18nMessage("itens","vazio"));
        validate.onErrorRedirectTo(this).formv();
        
        vdao.salvar(v);
        result.redirectTo(this).formv();
    }
    
}
