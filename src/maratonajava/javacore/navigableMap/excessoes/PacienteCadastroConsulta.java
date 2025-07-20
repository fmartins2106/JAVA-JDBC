package academy.devdojo.maratonajava.javacore.navigableMap.excessoes;

public class PacienteCadastroConsulta extends IllegalArgumentException {
    public PacienteCadastroConsulta() {
        super("Campo paciente não pode ficar vazio ou conter caracteres.");
    }
}
