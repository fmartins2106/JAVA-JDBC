package academy.devdojo.maratonajava.javacore.excessoes;

public class PlacaInvalidaException40 extends IllegalArgumentException {
    public PlacaInvalidaException40() {
        super("Placa inválida. Digite uma placa no formato AAA0000 ou AAA0A00.");
    }
}
