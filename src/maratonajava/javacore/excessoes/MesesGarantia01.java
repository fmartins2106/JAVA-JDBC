package academy.devdojo.maratonajava.javacore.excessoes;

public class MesesGarantia01 extends IllegalArgumentException{
    public static final int MIMIMO_MESES_GARANTIA = 3;
    public MesesGarantia01() {
        super(String.format("Garantia não pode ser menor que "+MIMIMO_MESES_GARANTIA+" mese"));
    }
}
