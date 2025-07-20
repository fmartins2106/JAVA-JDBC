package academy.devdojo.maratonajava.javacore.navigableMap.excessoes;

public class DataHoraCadastroConsulta extends IllegalArgumentException {
    public DataHoraCadastroConsulta() {
        super("Data ou hora inválida.");
    }
}
