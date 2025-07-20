package academy.devdojo.maratonajava.javacore.navigableMap.exercicios;

import academy.devdojo.maratonajava.javacore.Interface.dominio.DadosProduto05;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutosLogger05;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoDadosProduto;
import academy.devdojo.maratonajava.javacore.navigableMap.dominio.Consultavel01;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercicio03 {

    private final NavigableMap<LocalDateTime, Consultavel01> consultasAgendadas = new TreeMap<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static final Logger logger = ProdutosLogger05.getLogger(Exercicio03.class);

    private static double validandoPreco(){
        while (true){
            try {
                System.out.print("Preço:R$");
                double preco = Double.parseDouble(scanner.nextLine().trim());
                DadosProduto05.validacaoPreco(preco);
                return preco;
            }catch (NumberFormatException e){
                System.out.println("Erro, digite um valor válido para definir preço.");
                logger.log(Level.WARNING,"Erro, digite um valor válido para definir preço."+e.getMessage());
            }catch (PrecoDadosProduto e){
                System.out.println(e.getMessage());
                logger.log(Level.WARNING,"Erro de regra de negócio ->"+e.getMessage());
            }
        }
    }

    private void addConsultaSistema(Consultavel01 consultavel01){
        consultasAgendadas.put(consultavel01.getDataHora(),consultavel01);
        System.out.println("Consulta agendada com sucesso.");
    }

    private void excluirConsulta(LocalDateTime horario){
        if (consultasAgendadas.isEmpty()){
            System.out.println("Nenhuma consulta cadastrada.");
            return;
        }
        consultasAgendadas.remove(horario);
        System.out.println("Consulta removida do sistema.");
    }

    private void listarConsultas(){
        if (consultasAgendadas.isEmpty()){
            System.out.println("Nenhuma consulta cadastrada.");
            return;
        }
        consultasAgendadas.forEach((dateTime, consultavel01) -> System.out.println(consultavel01));
    }

    private boolean jaExiste(LocalDateTime horario){
        return consultasAgendadas.containsKey(horario);
    }

    private Map.Entry<LocalDateTime,Consultavel01> proximaConsulta(){
        return consultasAgendadas.higherEntry(LocalDateTime.now());
    }

    private void consultarAntes(LocalDateTime horario){
        consultasAgendadas.headMap(horario,false)
                .forEach((dateTime, consultavel01) -> System.out.println(consultavel01));
    }

    private void consultarDepois(LocalDateTime horario){
        consultasAgendadas.tailMap(horario,false)
                .forEach((dateTime, consultavel01) -> System.out.println(consultavel01));
    }

    public NavigableMap<LocalDateTime, Consultavel01> getConsultasAgendadas() {
        return consultasAgendadas;
    }
}