/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mariani.modelos;

/**
 *
 * @author maryucha
 */
public enum EnumCargo {
    
    GERENTE("gerente"),
    VENDEDOR("vendedor");
    
    private String descricao;
    
    EnumCargo(String descricao){
        this.descricao=descricao;
    }
    
    public String getDescricao(){
        return descricao;
    }
    
}
