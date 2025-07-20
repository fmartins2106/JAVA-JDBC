package academy.devdojo.maratonajava.javacore.designPatterns.dominio;

import academy.devdojo.maratonajava.javacore.navigableMap.excessoes.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class EntradaDeUsuarios02 {
    private static final Scanner scanner = new Scanner(System.in);

    public static String validandoPaciente(){
        while (true){
            System.out.print("Nome do paciente:");
            String paciente = scanner.nextLine().trim();
            try {
                ValidadoresConsulta02.validacaoPaciente(paciente);
                return paciente;
            }catch (PacienteCadastroConsulta e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoMedico(){
        while (true){
            System.out.print("Médico:");
            String medico = scanner.nextLine().trim();
            try {
                ValidadoresConsulta02.validacaoMedico(medico);
                return medico;
            }catch (MedicoCadastroConsulta e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoEspecialidade(){
        while (true){
            try {
                System.out.print("Especialidade:");
                String especialidade = scanner.nextLine().trim();
                ValidadoresConsulta02.validacaoEspecialidade(especialidade);
                return especialidade;
            }catch (EspecialidadeCadastroConsulta e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static BigDecimal validandoValor(){
        while (true){
            System.out.print("Valor:R$");
            String entrada = scanner.nextLine().trim().replace(",",".");
            try {
                BigDecimal valorConsulta = new BigDecimal(entrada).setScale(2, RoundingMode.HALF_UP);
                ValidadoresConsulta02.validacaoValor(valorConsulta);
                return valorConsulta;
            }catch (ValorConsultaCadastro e){
                System.out.println(e.getMessage());
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static LocalDateTime validandoDataHora(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        while (true){
            try {
                System.out.print("Data e Hora da Consulta (DD/MM/AAAA HH:mm:ss):");
                String entrada = scanner.nextLine().trim();
                LocalDateTime dataHora = LocalDateTime.parse(entrada,formatter);
                ValidadoresConsulta02.validacaoDataHora(dataHora);
                return dataHora;
            }catch (DateTimeException e){
                System.out.println("Data inválida.");
            }catch (DataHoraCadastroConsulta e){
                System.out.println(e.getMessage());
            }
        }
    }
}
