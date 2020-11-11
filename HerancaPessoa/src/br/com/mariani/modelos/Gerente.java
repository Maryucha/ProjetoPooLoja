package br.com.mariani.modelos;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author maryucha
 */
public class Gerente extends Funcionario {

    private String nomeGrencia;

    private Scanner entrada = new Scanner(System.in);
    private Calendar cal = Calendar.getInstance();
    private DecimalFormat dF = new DecimalFormat("0.##");
    private String formatado = "";

    public Gerente(String nomeGrencia, String matricula, Cargo cargo, String nome, int idade, char sexo) {
        super(matricula, cargo, nome, idade, sexo);
        this.nomeGrencia = nomeGrencia;
    }

    public Gerente() {

    }

    public String getNomeGrencia() {
        return nomeGrencia;
    }

    public void setNomeGrencia(String nomeGrencia) {
        this.nomeGrencia = nomeGrencia;
    }

    public Gerente criaGer() {
        Gerente listaGerente = new Gerente();
        System.out.print("Digite o nome da Gerência: ");
        listaGerente.setNomeGrencia(entrada.nextLine());
        listaGerente.carregaDados();
        return listaGerente;
    }
    
}
