package academy.devdojo.maratonajava.introducao;
/*
Prática,
Crie variáveis para os campos descritos abaixo entre <> e imprima a seguinte mensagem:
Eu <nome>, morando no endereço <endereço>, na data <data>
 */
public class Aula3TiposPrimitivosExercicios {
    public static void main(String[] args) {
        String nome1 = "Fernando";
        String endereço1 = "Rua dos Caçadores";
        double salário1 = 2500.00;
        String DataRecebimentoSalario1 = "20/12/2021";
        String relatorio = "Eu " + nome1 + " morando na " + endereço1 + " confirmo que recebi o salário de R$" + salário1 + ", na data " + DataRecebimentoSalario1;
        System.out.println(relatorio);


        String nome2 = "Fernando";
        String endereço2 = "Rua dos caçadores";
        double salário2 = 2500.00;
        String DatadeRecebimentoSalario2 = "02/11/2024";
        String Novorelatório = "Eu " + nome2 + "morando na " + endereço2 + " confirmo que recebio o salário de R$ " + salário2 + ", na data " + DatadeRecebimentoSalario2;
        System.out.println(Novorelatório);

        String nome3 = " Fernando ";
        String endereço3 = " Rua dos Caçadores ";
        double salário3 = 2500.00;
        String DataRecebimentoSalario3 = " 15/01/2023 ";
        String NovoRelatorio3 = "Eu"+nome3+"morando na rua"+endereço3+"confirmo que recebi o salário de R$ "+salário3+ ", na data"+DataRecebimentoSalario3;
        System.out.println(NovoRelatorio3);

        String nome4 = " Fernando ";
        String endereço4 = " Rua dos Caçadores ";
        double salário4 = 3500.00;
        String DataRecebimentoSalario4 = " 02/11/2024 ";
        String NovoRelatorio4 = "Eu"+nome4+"morando na"+endereço4+"confirmo que recebi o salário de R$ "+salário4+", na data"+DataRecebimentoSalario4;
        System.out.println(NovoRelatorio4);

        String nome5 = " Fernando ";
        String endereço5 = " Rua dos Caçadores ";
        double salario5 = 7000.35;
        String DataRecebimentoSalario5 = " 02/11/2024 ";
        String NovoRelatorio5 = "Eu"+nome5+"morando na"+endereço5+"confirmo que recebi o salário de R$ "+salario5+", na data"+DataRecebimentoSalario5;
        System.out.println(NovoRelatorio5);
    }
}
