/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mariani.modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author maryucha
 */
public class Compra {

    private double valorProduto = 0;
    private int qtdProduto = 0;
    private String nomeProduto = "";
    
    private int totProdutos = 0;
    private double vlrtotCompra = 0;

    private Scanner entrada = new Scanner(System.in);

    public Compra() {
    }
  

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getTotProdutos() {
        return totProdutos;
    }

    public void setTotProdutos(int totProdutos) {
        this.totProdutos += qtdProduto;
    }

    public double getVlrtotCompra() {
        return vlrtotCompra;
    }

    public void setVlrtotCompra(double vlrtotCompra) {
        this.vlrtotCompra = vlrtotCompra;
    } 
    
    public void imprimeCompra() {
        System.out.println("--------------COMPROU-----------");
        System.out.println("PRODUTO [" + this.nomeProduto + "] VALOR [" + this.valorProduto + "] QUANTIDADE [" + this.qtdProduto + "]");
        System.out.println("==================================");
    }
       
  
    public Compra carregarCompra() {
        int num=0;
       Compra listaCompras = new Compra();
        System.out.print("Digite o nome do produto: ");
        listaCompras.setNomeProduto( entrada.nextLine());
        System.out.print("Digite a quantidade: ");
        listaCompras.setQtdProduto(entrada.nextInt());
        entrada.nextLine();
        System.out.print("Digite o valor do produto: ");
        listaCompras.setValorProduto(entrada.nextDouble());
        entrada.nextLine();
        setTotProdutos(qtdProduto);
        return listaCompras;
    }

}
