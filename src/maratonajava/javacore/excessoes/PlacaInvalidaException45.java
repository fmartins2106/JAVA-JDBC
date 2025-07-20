package academy.devdojo.maratonajava.javacore.excessoes;

public class PlacaInvalidaException45 extends IllegalArgumentException {
    public PlacaInvalidaException45() {
        super("Plava inválida. Digite uma placa no formato  AAA0000 ou AAA0A00.");
    }
}
