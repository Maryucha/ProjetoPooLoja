package br.com.mariani.controle;

import br.com.mariani.modelos.Funcionario;
import br.com.mariani.modelos.Gerencia;
import br.com.mariani.modelos.Loja;
import br.com.mariani.modelos.Pessoa;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author maryucha
 */
public class PrincipalPessoa {
    public static void main(String[] args) {
        Scanner entrada =new Scanner(System.in);
        Gerencia chamar = new Gerencia();
        Loja lj = new Loja();
        
        
        Integer menu=0;
        
        do{
            try {
                System.out.println("=============MENU==========="
                                   +"\n1 Gerencia: "
                                   +"\n2 Loja: "
                                   +"\n3 Sair: "
                                   +"\n---------------------------");
                menu=entrada.nextInt();
                entrada.nextLine();
            } catch (HeadlessException|NumberFormatException e) {
                menu=null;
            }if(menu!=null){
                switch(menu){
                    case 1:
                       chamar.gerencia();
                        break;
                    case 2:    
                        lj.balcao();
                        break;
                    case 3:    
                        System.out.println("Até mais!");
                        break;
                    default:
                        System.out.println("Escolha uma opção válida!");
                        break;
                }
            }
        }while(menu!=3);
    }
}
