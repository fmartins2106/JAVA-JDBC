package academy.devdojo.maratonajava.javacore.navigableMap.excessoes;

public class MedicoCadastroConsulta extends IllegalArgumentException {
    public MedicoCadastroConsulta() {
        super("Campo nome médico não pode ser vazio ou conter caracteres.");
    }
}
