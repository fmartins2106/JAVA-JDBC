package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

public class Pessoas {
    public String nome;
    public int idade;
    public String email;

    public Pessoas(String nome, int idade, String email){
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }

    public void apresentar(){
        System.out.println("Olá, meu nome é "+nome+" tenho "+idade+" e meu e-mail é:"+email);
    }
}
