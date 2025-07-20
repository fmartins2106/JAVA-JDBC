package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class DataHoraInvalida24 extends IllegalArgumentException{
    public DataHoraInvalida24() {
        super(String.format("Data ou hora inválida."));
    }
}
