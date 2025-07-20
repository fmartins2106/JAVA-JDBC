package academy.devdojo.maratonajava.javacore.excessoes;

public class DataValidadePerecivel32 extends RuntimeException {
    public DataValidadePerecivel32() {
        super("Data de validade inválida. Digite uma data no formato DD/MM/AAAA");
    }
}
