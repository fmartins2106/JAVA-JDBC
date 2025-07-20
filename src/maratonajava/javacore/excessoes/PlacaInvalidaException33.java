package academy.devdojo.maratonajava.javacore.excessoes;

public class PlacaInvalidaException33 extends IllegalArgumentException {
    public PlacaInvalidaException33() {
        super("Placa deve ter o formato AAA0000 ou AAA0A00.");
    }
}
