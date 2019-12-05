/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interceptor;

import annotations.Public;
import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import com.mycompany.classes.SessionCliente;
import com.mycompany.controller.ClientesController;
import javax.inject.Inject;

/**
 *
 * @author jose.filho
 */
@Intercepts
public class Interceptador {
    
    @Inject
    private SessionCliente sessionCliente;
    
    @Inject
    private ClientesController controller;
    
    @Inject
    private Result result;
   
    @Inject
    private ControllerMethod controllerMethod;
    
    
    @Accepts
    public boolean accepts(){
        
        return !controllerMethod.containsAnnotation(Public.class);
        
    }
    
    @AroundCall
    public void intercepta(SimpleInterceptorStack stack){
        
        if(sessionCliente.getCliente()== null ){
      
            result.redirectTo(ClientesController.class).form();
            return;
        }
        
        stack.next();
        
        
    }
    
}
