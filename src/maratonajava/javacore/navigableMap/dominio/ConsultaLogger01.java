package academy.devdojo.maratonajava.javacore.navigableMap.dominio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ConsultaLogger01 {

    private static final String LOG_DIR = "logs";
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    public static Logger getLogger(Class<?> clazz){
        Logger logger = Logger.getLogger(clazz.getName());
        logger.setUseParentHandlers(false);

        if (logger.getHandlers().length == 0){
            configuracaoLogger(logger,clazz.getSimpleName());
        }
        return logger;
    }

    public static void configuracaoLogger(Logger logger, String className){
        try {
            Files.createDirectories(Paths.get(LOG_DIR));
            String dataAtual = SIMPLE_DATE_FORMAT.format(new Date());
            String logFileName = String.format("log_%s_%s.logs",className,dataAtual);
            Path logFilePath = Paths.get(LOG_DIR,logFileName);

            FileHandler fileHandler = new FileHandler(logFilePath.toString(),true);
            fileHandler.setFormatter(new SimpleFormatter());
            fileHandler.setLevel(Level.ALL);

            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);
        }catch (IOException e){
            System.out.println("Erro na configuração do logger "+className+" :"+e.getMessage());
        }
    }

//    private static final String LOGS_DIRETORIO = "logs";
//    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
//
//    private static Logger getLogger(Class<?> clazz){ // Método que cria ou retorna um logger para a classe passada como parâmetro
//        Logger logger = Logger.getLogger(clazz.getName()); // Cria um logger com o nome da classe (único para cada classe)
//        logger.setUseParentHandlers(false); // Desativa os handlers padrão (console), para não gerar logs duplicados
//
//        if (logger.getHandlers().length == 0){ // Verifica se o logger já tem algum handler (evita adicionar múltiplos)
//            configurarLogger2(logger, clazz.getSimpleName()); // Se não tem handler, chama o método para configurar
//        }
//        return logger; // Retorna o logger configurado
//    }
//
//    private static void configurarLogger2(Logger logger, String className){ // Método que configura o logger, criando arquivo de log específico
//        try {
//            Files.createDirectories(Paths.get(LOGS_DIRETORIO)); // Cria o diretório 'logs' se ele não existir
//
//            String dataAtual = DATE_FORMAT.format(new Date()); // Gera a data atual no formato definido (ex.: 14-06-2025)
//            String logFileName = String.format("log_%s_%s.logs", className, dataAtual); // Cria o nome do arquivo de log: ex. log_NomeDaClasse_14-06-2025.logs
//
//            Path logFilePath = Paths.get(LOGS_DIRETORIO, logFileName); // Cria o caminho completo até o arquivo de log
//
//            FileHandler fileHandler = new FileHandler(logFilePath.toString(), true); // Cria o handler para escrever no arquivo, com append=true (adiciona no arquivo existente)
//            fileHandler.setFormatter(new SimpleFormatter()); // Define o formato do log como simples (texto padrão do Java)
//            fileHandler.setLevel(Level.ALL); // Define que o handler irá capturar todos os níveis de log (INFO, WARNING, ERROR, etc.)
//
//            logger.addHandler(fileHandler); // Adiciona o handler (arquivo) ao logger
//            logger.setLevel(Level.ALL); // Define que o logger também irá capturar todos os níveis de log
//        } catch (IOException e) { // Captura qualquer erro na configuração, como problema ao criar arquivo ou diretório
//            System.out.println("Erro na configuração do logger -> " + className + " : " + e.getMessage()); // Exibe o erro no console
//        }
//    }


}
