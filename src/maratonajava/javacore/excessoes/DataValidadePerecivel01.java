package academy.devdojo.maratonajava.javacore.excessoes;

public class DataValidadePerecivel01 extends IllegalArgumentException{
    public DataValidadePerecivel01() {
        super("Data de validade deve ser futura.");
    }
}
