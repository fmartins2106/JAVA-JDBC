package academy.devdojo.maratonajava.javacore.navigableMap.excessoes;

public class EspecialidadeCadastroConsulta extends IllegalArgumentException {
    public EspecialidadeCadastroConsulta() {
        super("Campo especialidade não pode ser vazio ou conter caracteres.");
    }
}
