package br.com.mariani.modelos;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author maryucha
 */
public abstract class Funcionario extends Pessoa{
    private String matricula;
    private double salario;
    private EnumCargo cargo;

    private Scanner entrada =new Scanner(System.in);
    private Calendar cal = Calendar.getInstance();
    private DecimalFormat dF = new DecimalFormat("0.##");
    private String formatado = "";
    

    public Funcionario(String matricula, EnumCargo cargo, String nome, int idade, char sexo) {
        super(nome, idade, sexo);
        this.matricula = matricula;
        this.cargo = cargo;
    }

    public Funcionario(String matricula, EnumCargo cargo) {
        this.matricula = matricula;
        this.cargo = cargo;
    }
    
    public Funcionario(){
        
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }  

    public EnumCargo getCargo() {
        return cargo;
    }

    public void setCargo(EnumCargo cargo) {
        this.cargo = cargo;
    }
    
    public void valorInss(){
        double novoSalario=0;
        double vlrInss=0;
        System.out.println("================CALCULAR INSS===========");
        if(salario<=1830.29){
            vlrInss=(this.salario*7.5)/100;
            novoSalario=salario-vlrInss;
            formatado=dF.format(novoSalario);
            String formatado2 = dF.format(vlrInss);
            String formatado3 = dF.format(salario);
            System.out.println("==========================================="
                            +"\n* SALÁRIO LÍQUIDO R$"+formatado3+"        *"
                            +"\n* SALÁRIO BRUTO R$"+formatado+"           *"
                            +"\n* VALOR DA CONTRIBUIÇÃO R$"+formatado2+"  *"
                            +"\n===========================================");     
        }else if(this.salario>1830.30&&this.salario<=3050.52){
         vlrInss=(this.salario*9)/100;
            novoSalario=salario-vlrInss;
            formatado=dF.format(novoSalario);
            String formatado2 = dF.format(vlrInss);
            String formatado3 = dF.format(salario);
            System.out.println("==========================================="
                            +"\n* SALÁRIO LÍQUIDO R$"+formatado3+"        *"
                            +"\n* SALÁRIO BRUTO R$"+formatado+"           *"
                            +"\n* VALOR DA CONTRIBUIÇÃO R$"+formatado2+"  *"
                            +"\n===========================================");  
        }else if(this.salario>3053.53&&this.salario<=6101.06){
         vlrInss=(this.salario*12)/100;
            novoSalario=salario-vlrInss;
            formatado=dF.format(novoSalario);
            String formatado2 = dF.format(vlrInss);
            String formatado3 = dF.format(salario);
            System.out.println("==========================================="
                            +"\n* SALÁRIO LÍQUIDO R$"+formatado3+"        *"
                            +"\n* SALÁRIO BRUTO R$"+formatado+"           *"
                            +"\n* VALOR DA CONTRIBUIÇÃO R$"+formatado2+"  *"
                            +"\n===========================================");  
        }else{
         vlrInss=(this.salario*14)/100;
            novoSalario=salario-vlrInss;
            formatado=dF.format(novoSalario);
            String formatado2 = dF.format(vlrInss);
            String formatado3 = dF.format(salario);
            System.out.println("==========================================="
                            +"\n* SALÁRIO LÍQUIDO R$"+formatado3+"        *"
                            +"\n* SALÁRIO BRUTO R$"+formatado+"           *"
                            +"\n* VALOR DA CONTRIBUIÇÃO R$"+formatado2+"  *"
                            +"\n===========================================");  
        }
    }
    
    public void carregaDados(){
        System.out.print("Digite o nome do funcionário: ");
        this.setNome(entrada.nextLine());
        System.out.print("Digite a data de nascimento do Funcionário: [00/00/0000]");
        String data = entrada.nextLine();
        String valor[]=data.split("/");
        int anoNas = Integer.parseInt(valor[2]);
        int anoAtual=cal.get(Calendar.YEAR);
        int idade=anoAtual-anoNas;
        super.setIdadae(idade);
        int mes=cal.get(Calendar.MONTH);
        int dia=cal.get(Calendar.DAY_OF_MONTH);
        System.out.print("Digite o sexo [F/M]: ");
        super.setSexo(entrada.next().charAt(0));
        entrada.nextLine();
        System.out.print("Digite o salário do Funcionário R$");
        this.setSalario(entrada.nextDouble());
        entrada.nextLine();
  
    }
}
