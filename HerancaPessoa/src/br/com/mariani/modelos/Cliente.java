package br.com.mariani.modelos;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author maryucha
 */
public class Cliente extends Pessoa {

    private Scanner entrada = new Scanner(System.in);
    private Calendar cal = Calendar.getInstance();
    private DecimalFormat dF = new DecimalFormat("0.##");
    private String formatado = "";

    private double vlrDivida;

    private List<Compra> listaCompras = new ArrayList<>();

    Compra com = new Compra();

    public Cliente(double vlrDivida, List<Compra> listaCompras, String nome, int idade, char sexo) {
        super(nome, idade, sexo);
        this.vlrDivida = vlrDivida;
        this.listaCompras = listaCompras;

    }

    public Cliente() {
    }

    public List<Compra> getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(List<Compra> listaCompras) {
        this.listaCompras = listaCompras;
    }

    public double getVlrDivida() {
        return vlrDivida;
    }

    public void setVlrDivida(double vlrDivida) {
        this.vlrDivida = vlrDivida;
    }

    public Cliente criaCli() {
        Cliente listaCliente = new Cliente();
        listaCliente.carregaDados();
        return listaCliente;
    }

    public void carregaDados() {
        System.out.print("Digite o nome do Cliente: ");
        this.setNome(entrada.nextLine());
        System.out.print("Digite a data de nascimento do Cliente: [00/00/0000]");
        String data = entrada.nextLine();
        String valor[] = data.split("/");
        int anoNas = Integer.parseInt(valor[2]);
        int anoAtual = cal.get(Calendar.YEAR);
        int idade = anoAtual - anoNas;
        super.setIdadae(idade);
        int mes = cal.get(Calendar.MONTH);
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        System.out.print("Digite o sexo [F/M]: ");
        super.setSexo(entrada.next().charAt(0));
        entrada.nextLine();
    }

      public double calcDividaCliente() {
        double valor = 0;
        
        for (int i = 0; i < listaCompras.size(); i++) {
                valor = getVlrDivida();       
        }
        return valor;
    }

    public void clienteCompra() {
        int totProdutos = 0;
        int qtdProdutos = 0;
        double vlrtotCompra = 0;
        double custoProduto = 0;
        String nomeProduto="";
        
        int teste = 0;
        System.out.println("===================CAIXA===================");
        do {
            listaCompras.add(com.carregarCompra());
            for (int i = 0; i < listaCompras.size(); i++) {
                
                //mudando o total de produtos
                listaCompras.get(i).setTotProdutos(totProdutos++);
                //mostrar a quantidade de produtos
                System.out.println("a qtd de produtos é "+listaCompras.get(i).getTotProdutos());
                
                //pegando o valor
                qtdProdutos = listaCompras.get(i).getQtdProduto();
                custoProduto = listaCompras.get(i).getValorProduto();
                //fazendo a conta
                vlrtotCompra = (qtdProdutos * custoProduto);
                //imprimindo
                listaCompras.get(i).imprimeCompra();
                listaCompras.get(i).setVlrtotCompra(vlrtotCompra);
                
                //mostrando a divida
                setVlrDivida(vlrtotCompra);
                System.out.println("Sua divida está em R$"+getVlrDivida());
            }
            
            formatado = dF.format(vlrtotCompra);
            System.out.println("Deseja continuar comprando [S=0/N=1]");
            teste = entrada.nextInt();
            entrada.nextLine();
            System.out.println("--------------------------------------");
            System.out.println("Sua compra deu: R$" + formatado);
        } while (teste != 1);
    }
}
