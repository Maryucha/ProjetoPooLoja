package br.com.mariani.controle;

import br.com.mariani.modelos.Gerente;
import br.com.mariani.modelos.Vendedor;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author maryucha
 */
public class ControleFuncionarios {

    private final List<Gerente> listaGerente = new ArrayList<>();
    private final List<Vendedor> listaVendedor = new ArrayList<>();

    Gerente ger = new Gerente();
    Vendedor ven = new Vendedor();

    private final Scanner entrada = new Scanner(System.in);
    Integer menu = 0;

    public void cadFuncionario() {
        System.out.println("-----------------CADASTRO DE FUNCIONARIO------------");
        System.out.print("Digite o cargo: ");
        String carDig = entrada.nextLine();
        int testeCargo = 0;
        if (carDig.contains("GERENTE")) {
            listaGerente.add(ger.criaGer());
        } else if (carDig.contains("VENDEDOR")) {
            listaVendedor.add(ven.criaVendedor());
        }

    }

    public void mostarGerente() {
        System.out.println("------------GERENTES CADASTRADOS----------");
        if (listaGerente.isEmpty()) {
            System.out.println("Ainda não temos GERENTES cadastrados.");
        } else {
            for (int i = 0; i < listaGerente.size(); i++) {
                listaGerente.listIterator(i).next().imprime();
            }
        }

    }

    public void remGer() {
        System.out.print("Digite o nome do Gerente: ");
        String nome = entrada.nextLine();
        for (int i = 0; i < listaGerente.size(); i++) {
            if (nome.equalsIgnoreCase(listaGerente.get(i).getNome())) {
                listaGerente.remove(i);
            } else {
                System.out.println("Gerente não encontrado!");
            }
        }
    }

    public int buGerente() {
        int num = 0;
        System.out.print("Digite o nome do Gerente: ");
        String nome = entrada.nextLine();
        for (int i = 0; i < listaGerente.size(); i++) {
            if (nome.equalsIgnoreCase(listaGerente.get(i).getNome())) {
                num = i;
            } else {
                System.out.println("Gerente não encontrado!");
            }
        }
        return num;
    }

    public void mostarVendedor() {
        System.out.println("------------VENDEDORES CADASTRADOS----------");
        if (listaVendedor.isEmpty()) {
            System.out.println("Ainda não temos VENDEDORES cadastrados.");
        } else {
            for (int i = 0; i < listaVendedor.size(); i++) {
                listaVendedor.listIterator(i).next().imprime();
            }
        }

    }

    public void remVen() {
        System.out.print("Digite o nome do vendedor: ");
        String nome = entrada.nextLine();
        for (int i = 0; i < listaVendedor.size(); i++) {
            if (nome.equalsIgnoreCase(listaVendedor.get(i).getNome())) {
                listaVendedor.remove(i);
            } else {
                System.out.println("Vendedor não encontrado!");
            }
        }
    }

    public int buVendedor() {
        int num = 0;
        System.out.print("Digite o nome do vendedor: ");
        String nome = entrada.nextLine();
        for (int i = 0; i < listaVendedor.size(); i++) {
            if (nome.equalsIgnoreCase(listaVendedor.get(i).getNome())) {
                num = i;
            } else {
                System.out.println("Vendedor não encontrado!");
            }
        }
        return num;
    }

    public void desligar() {
        System.out.println("-----------------DESLIGAR FUNCIONARIO------------");
        System.out.print("Digite o cargo: ");
        String carDig = entrada.nextLine();

        if (carDig.contains("GERENTE")) {
            remGer();
            System.out.println("Gerente desvinculado!");
            mostarGerente();
        } else if (carDig.contains("VENDEDOR")) {
            remVen();
            mostarVendedor();
        }
    }

    public void buscarCalcular() {
        int numFun = 0;
        System.out.println("---------------CALCULOS--------------");
        System.out.print("Digite o cargo: ");
        String carDig = entrada.nextLine();
        if (carDig.contains("GERENTE")) {
            listaGerente.get(buGerente()).valorInss();
        } else if (carDig.contains("VENDEDOR")) {
            listaVendedor.get(buVendedor()).valorInss();

        }
    }

    public void gerencia() {
        do {
            try {
                System.out.println("==========MENU GERENCIA==========="
                        + "\n1 Cadastrar Funcionário: "
                        + "\n2 Mostrar Vendedores: "
                        + "\n3 Mostrar Gerentes: "
                        + "\n4 Desvincular: "
                        + "\n5 Calcular Inss: "
                        + "\n6 Voltar: "
                        + "\n----------------------------------------");
                menu = entrada.nextInt();
                entrada.nextLine();
            } catch (HeadlessException | NumberFormatException e) {
                menu = null;
            }
            if (menu != null) {
                switch (menu) {
                    case 1:
                        cadFuncionario();
                        break;
                    case 2:
                        mostarVendedor();
                        break;
                    case 3:
                        mostarGerente();
                        break;
                    case 4:
                        desligar();
                        break;
                    case 5:
                        buscarCalcular();
                        break;
                    case 6:
                        System.out.println("Voltar para menu principal.");
                        break;
                    default:
                        break;
                }
            }
        } while (menu != 6);
    }

}
