package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class DataHoraEventoBase01 extends IllegalArgumentException {
    public DataHoraEventoBase01() {
        super("Data não válida. Data deve ser maior que data atual.");
    }
}
