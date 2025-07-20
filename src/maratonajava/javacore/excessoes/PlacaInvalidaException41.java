package academy.devdojo.maratonajava.javacore.excessoes;

public class PlacaInvalidaException41 extends IllegalArgumentException{
    public PlacaInvalidaException41() {
        super("Campo placa não pode ser vazio ou conter caracteres. Digite uma placa no formato AAA0000 ou AAA0A00.");
    }
}
