package br.com.mariani.modelos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author maryucha
 */
public class Vendedor extends Funcionario {

    private double vlrVendas;
    private int qtdVendas;

    private Scanner entrada = new Scanner(System.in);
    private List<Cliente> listaCliente = new ArrayList<>();


    public Vendedor(double vlrVendas, int qtdVendas, String matricula, EnumCargo cargo, String nome, int idade, char sexo) {
        super(matricula, cargo, nome, idade, sexo);
        this.vlrVendas = vlrVendas;
        this.qtdVendas = qtdVendas;
    }

    public Vendedor() {

    }

    public double getVlrVendas() {
        return vlrVendas;
    }

    public void setVlrVendas(double vlrVendas) {
        this.vlrVendas = vlrVendas;
    }

    public int getQtdVendas() {
        return qtdVendas;
    }

    public void setQtdVendas(int qtdVendas) {
        this.qtdVendas = qtdVendas;
    }

    public Vendedor criaVendedor() {
        Vendedor vendedor = new Vendedor();
        vendedor.carregaDados();
        return vendedor;
    }

    public Cliente vendedorFazVenda() {
        int vendas = 0;
        Cliente listaCliente = new Cliente();
        listaCliente.clienteCompra();
        double vlrVenda = listaCliente.getVlrDivida();
        this.vlrVendas += vlrVenda;
        this.qtdVendas += ++vendas;
        return listaCliente;
    }
}
