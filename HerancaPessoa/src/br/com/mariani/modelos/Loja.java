package br.com.mariani.modelos;

import java.awt.HeadlessException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author maryucha
 */
public class Loja {

    private List<Vendedor> listaVendedor = new ArrayList<>();
    private List<Cliente> listaCliente = new ArrayList<>();
    private List<Compra> listaCompras = new ArrayList<>();

    Vendedor ven = new Vendedor();
    Cliente cli = new Cliente();
    Compra compra = new Compra();
    Gerencia chamar = new Gerencia();

    private final Scanner entrada = new Scanner(System.in);
    private final Calendar cal = Calendar.getInstance();
    private DecimalFormat dF = new DecimalFormat("0.##");
    private String formatado = "";
    Integer menu = 0;

    public void cadCliente() {
        System.out.println("--------------CADASTRO CLIENTE--------------");
        listaCliente.add(cli.criaCli());
    }

    public void validarVendedor() {

    }

    public void vender() {
        System.out.println("------------BUSCANDO O CLIENTE---------");
        System.out.print("Digite o nome do Cliente: ");
        String nome = entrada.nextLine();
        for (int i = 0; i < listaCliente.size(); i++) {
            if (nome.equalsIgnoreCase(listaCliente.get(i).getNome())) {
                System.out.println("Cliente encontrado!");
                ven.vendedorFazVenda();
            } else {
                System.out.println("Cliente não encontrado!");
                cadCliente();
            }
        }
    }

    public void mostrarClientes() {
        System.out.println("------------CLLIENTES CADASTRADOS----------");
        if (listaCliente.isEmpty()) {
            System.out.println("Ainda não temos CLIENTES cadastrados.");
        } else {
            for (int i = 0; i < listaCliente.size(); i++) {
                listaCliente.listIterator(i).next().imprime();
                listaCliente.listIterator(i).next().getListaCompras().listIterator(i).next().imprimeCompra();
            }
        }
    }

    public void fecharOcaixa() {
        System.out.println("-----------------FECHANDO O CAIXA------------");
        System.out.print("digite o nome do vendedor: ");
        String nomeVendedor = entrada.nextLine();
        for (int i = 0; i < listaVendedor.size(); i++) {
            if (nomeVendedor.equalsIgnoreCase(listaVendedor.get(i).getNome())) {
                String nome = listaVendedor.get(i).getNome();
                double vlrVendas = listaVendedor.get(i).getVlrVendas();
                int qtdVendas = listaVendedor.get(i).getQtdVendas();
                int dia = cal.get(Calendar.DAY_OF_MONTH);
                int mes = cal.get(Calendar.MONTH);
                int ano = cal.get(Calendar.YEAR);
                System.out.println("--------------VENDAS DO DIA [" + dia + "/" + mes + "/" + ano + "]---------");
                System.out.println("VENDEDOR [" + nome + "] QTD [" + qtdVendas + "] VLRVENDAS [" + vlrVendas + "]");
            } else {
                System.out.println("Nenuma venda computada!");
            }
        }
    }

    public void mostrarListadeCompras() {
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = entrada.nextLine();
        for (int i = 0; i < listaCliente.size(); i++) {
            if (nomeCliente.equalsIgnoreCase(listaCliente.get(i).getNome())) {
                listaCliente.listIterator(i).next().getListaCompras().listIterator(i).next().imprimeCompra();
            } else {
                System.out.println("Cliente não encontrado");
            }
            System.out.println("");
        }
    }

    public void calcDivida() {
        double valor = 0;
        System.out.println("===============BOLETOS==============");
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = entrada.nextLine();
        for (int i = 0; i < listaCliente.size(); i++) {
            if (nomeCliente.equalsIgnoreCase(listaCliente.get(i).getNome())) {
               // valor = listaCliente.get(i).calcDividaCliente();
                valor = listaCliente.get(i).calcDividaCliente();
                formatado=dF.format(valor);
                System.out.println("CLIENTE ["+listaCliente.get(i).getNome()+"] DIVIDA ["+listaCliente.get(i).calcDividaCliente()+"]");
            } else {
                System.out.println("Cliente não cadastrado!");
            }
        }
    }

    public void balcao() {
        do {
            try {
                System.out.println("=============BALCÃO DA LOJA=========="
                        + "\n1 Cadastrar Cliente: "
                        + "\n2 Mostrar Clientes: "
                        + "\n3 Fazer Venda: "
                        + "\n4 Calcular Divida: "
                        + "\n5 Fechar o Caixa: "
                        + "\n6 Voltar: "
                        + "\n7 Validar vendedor: "
                        + "\n8 Mostrar Lista de compras do cliente: "
                        + "\n---------------------------------");
                menu = entrada.nextInt();
                entrada.nextLine();
            } catch (HeadlessException | NumberFormatException e) {
                menu = null;
            }
            if (menu != null) {
                switch (menu) {
                    case 1:
                        cadCliente();
                        break;
                    case 2:
                        mostrarClientes();
                        break;
                    case 3:
                        vender();
                        break;
                    case 4:
                        calcDivida();
                        break;
                    case 5:
                        fecharOcaixa();
                        int qtdVendas = ven.getQtdVendas();
                        System.out.println("A quantidade de vendas do vendedor: " + qtdVendas);
                        double valorVendido = ven.getVlrVendas();
                        System.out.println("O valor das vendas do vendedor " + valorVendido);
                        break;
                    case 6:
                        System.out.println("Voltando ao menu principal!");
                        break;
                    case 7:
                        validarVendedor();
                        break;
                    case 8:
                        mostrarListadeCompras();
                        break;
                    default:
                        System.out.println("Escolha uma aopção válida!");
                        break;
                }
            }
        } while (menu != 8);

    }

}
