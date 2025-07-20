package academy.devdojo.maratonajava.javacore.excessoes;

public class DataValidadePerecivel34 extends IllegalArgumentException {
    public DataValidadePerecivel34() {
        super("Data de valida inválida. Digite uma data no formato DD/MM/AAAA");
    }
}
