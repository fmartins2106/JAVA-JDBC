package academy.devdojo.maratonajava.javacore.excessoes;

public class PlacaInvalidaException32 extends IllegalArgumentException {
    public PlacaInvalidaException32(){
        super("Digite uma polaca no formato AAA0000 ou AAA0A00.");
    }
}
