package academy.devdojo.maratonajava.javacore.excessoes;

public class PlacaInvalidaException42 extends IllegalArgumentException{
    public PlacaInvalidaException42() {
        super("Digite uma placa no formato AAA000 ou AAA0A00.");
    }
}
