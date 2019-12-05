/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model.dao;

import com.mycompany.classes.Cliente;
import com.mycompany.classes.Produto;

/**
 *
 * @author jose.filho
 */
public class Main {
    
    
    public static void main(String[] args) {
        Cliente c1 = new Cliente();
       
        Produto p1 = new Produto();
        
        

        c1.setNome("Jose");
        
        p1.setDescricao("PAO");
        p1.setValor(2.55);

    }
}
