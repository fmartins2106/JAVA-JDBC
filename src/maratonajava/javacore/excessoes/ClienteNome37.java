package academy.devdojo.maratonajava.javacore.excessoes;

public class ClienteNome37 extends IllegalArgumentException {

    public ClienteNome37(){
        super("Digite o nome completo. Campo nome não pode ser vazio ou conter caracateres.");
    }
}
