package academy.devdojo.maratonajava.javacore.navigableMap.test;

import academy.devdojo.maratonajava.javacore.navigableMap.dominio.AgendaConsulta01;
import academy.devdojo.maratonajava.javacore.navigableMap.dominio.CadastroConsulta01;
import academy.devdojo.maratonajava.javacore.navigableMap.dominio.ConsultaLogger01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SistemaConsulta01 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private static final AgendaConsulta01 agendaConsulta01 = new AgendaConsulta01();
    private static final Logger logger = ConsultaLogger01.getLogger(SistemaConsulta01.class);

    public static void main(String[] args) {
        int opcao = 0;
        do {
            exibirMenu();
            opcao = capturarOpcao();
            switch (opcao){
                case 1:
                    agendarConsulta();
                    break;
                case 2:
                    dataHoraCancelamentoConsulta();
                    break;
                case 3:
                    proximaConsulta();
                    break;
                case 4:
                    agendaConsulta01.listarTodos();
                    break;
                case 5:
                    listarTodasConsultas();
                    break;
                case 6:
                    consultarDepois();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Erro. Digite uma opção válida.");
            }
        }while (opcao !=7);
        System.out.println(">>>>Finalizando sistema.");
    }

    private static int capturarOpcao(){
        while (true){
            try {
                System.out.print("Digite uma das opções acima:");
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Número inválido.");
                logger.log(Level.WARNING,"Erro na digitação do número, número inválido."+e.getMessage());
            }
        }
    }

    private static void agendarConsulta(){
        LocalDateTime dataHora = AgendaConsulta01.validandoDataHora();
        if (agendaConsulta01.jaExiste(dataHora)){
            System.out.println("Consulta já existe neste horário.");
            return;
        }
        String paciente = AgendaConsulta01.validandoPaciente();
        String medico = AgendaConsulta01.validandoMedico();
        String especialidade = AgendaConsulta01.validandoEspecialidade();
        CadastroConsulta01 cadastroConsulta01 = new CadastroConsulta01(paciente,medico,especialidade,dataHora);
        agendaConsulta01.agendar(cadastroConsulta01);
    }

    private static void dataHoraCancelamentoConsulta(){
        if (agendaConsulta01.getRegistroConsultas().isEmpty()){
            System.out.println("Nenhuma consulta agendada.");
            return;
        }
        LocalDateTime dateTime = AgendaConsulta01.validandoDataHora();
        agendaConsulta01.cancelar(dateTime);
    }

    private static void proximaConsulta(){
        if (agendaConsulta01.getRegistroConsultas().isEmpty()){
            System.out.println("Nenhuma consulta agendada.");
            return;
        }
        var proxima = agendaConsulta01.proximasConsulta();
        if (proxima != null){
            System.out.println("Próximas consultas:"+proxima.getKey()+" - "+proxima.getValue());
            return;
        }
        System.out.println("Nenhuma consulta agendada.");
    }

    private static void listarTodasConsultas(){
        if (agendaConsulta01.getRegistroConsultas().isEmpty()){
            System.out.println("Nenhuma consulta agendada.");
            return;
        }
        LocalDateTime dataHora = AgendaConsulta01.validandoDataHora();
        agendaConsulta01.consultarAntes(dataHora);
    }

    private static void consultarDepois(){
        if (agendaConsulta01.getRegistroConsultas().isEmpty()){
            System.out.println("Nenhuma consulta agendada.");
            return;
        }
        LocalDateTime dataHora = AgendaConsulta01.validandoDataHora();
        agendaConsulta01.consultarDepois(dataHora);
    }

    private static void exibirMenu(){
        System.out.println("[1] - Agendar consulta.");
        System.out.println("[2] - Cancelar consulta.");
        System.out.println("[3] - Próxima consulta.");
        System.out.println("[4] - Listar todas.");
        System.out.println("[5] - Consultas antes de uma data/hora.");
        System.out.println("[6] - Consultas depois de uma data/hora.");
        System.out.println("[7] - Sair.");
    }
}
