package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Endereco;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Funcionario;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Pessoa;

public class HerancaTest01 {
    public static void main(String[] args) {
        Endereco endereco = new Endereco();
        endereco.setRua("Rua 03");
        endereco.setCep("012365-7854");
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Fernando Martins");
        pessoa.setCpf("89040-232");
        pessoa.setEndereco(endereco);
        pessoa.imprime();


        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Maria da Silva");
        funcionario.setCpf("0550542235-52");
        funcionario.setEndereco(endereco);
        funcionario.setSalario(2000);
        System.out.println("______________________________________");
        funcionario.imprime();
    }
}
