package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.awt.desktop.OpenFilesHandler;
import java.io.DataInput;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.*;

public class ProdutosLogger04 {

    private static final String LOG_DIR = "logs";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    public static Logger getLogger(Class<?> clazz){
        Logger logger = Logger.getLogger(clazz.getName());
        logger.setUseParentHandlers(false);

        if (logger.getHandlers().length == 0){
            configurarLogger(logger,clazz.getSimpleName());
        }
        return logger;
    }

    public static void configurarLogger(Logger logger, String className){
        try {
            Files.createDirectories(Paths.get(LOG_DIR));
            String dataAtual = DATE_FORMAT.format(new Date());
            String logFileName = String.format("log_%s_%s.log",className,dataAtual);
            Path logFilePath = Paths.get(LOG_DIR, logFileName);


            FileHandler fileHandler = new FileHandler(logFilePath.toString(),true);
            fileHandler.setFormatter(new SimpleFormatter());
            fileHandler.setLevel(Level.ALL);

            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);

        }catch (IOException e){
            System.err.println("Erro na configuração do logger "+className+" :"+e.getMessage());
        }
    }


//    private static final String LOGS_DIRETORIO = "logs";
//    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
//
//    public static Logger getLogger2(Class<?> clazz) {
//        /* Método estático que retorna um logger personalizado para a classe informada */
//        // Obtém uma instância de Logger com o nome da classe fornecida
//        Logger logger = Logger.getLogger(clazz.getName());
//
//        // Desativa os manipuladores de log herdados do logger pai (evita logs duplicados no console)
//        logger.setUseParentHandlers(false);
//
//        // Se o logger ainda não tem manipuladores configurados
//        if (logger.getHandlers().length == 0) {
//            // Configura o logger com um manipulador de arquivo
//            configurarLogger2(logger, clazz.getSimpleName());
//        }
//
//        // Retorna o logger configurado
//        return logger;
//    }
//
//    // Método que configura o logger para gravar em um arquivo com base no nome da classe e data atual
//    public static void configurarLogger2(Logger logger, String className) {
//        try {
//            // Garante que o diretório de logs exista (cria se não existir)
//            Files.createDirectories(Paths.get(LOGS_DIRETORIO));
//
//            // Gera uma string com a data atual formatada (ex: 2025-06-08)
//            String dataAtual = SIMPLE_DATE_FORMAT.format(new Date());
//
//            // Define o nome do arquivo de log com base na classe e na data
//            String logFileName = String.format("log_%s_%s.logs", className, dataAtual);
//
//            // Cria o caminho completo para o arquivo de log
//            Path logFilePath = Paths.get(LOGS_DIRETORIO, logFileName);
//
//            // Cria um manipulador de log que grava no arquivo (modo de adição: true)
//            FileHandler fileHandler = new FileHandler(logFilePath.toString(), true);
//
//            // Define o formato do log para o padrão simples do Java
//            fileHandler.setFormatter(new SimpleFormatter());
//
//            // Define o nível do log para capturar todos os níveis (INFO, DEBUG, WARNING etc.)
//            fileHandler.setLevel(Level.ALL);
//
//            // Adiciona esse manipulador ao logger
//            logger.addHandler(fileHandler);
//
//            // Define o nível geral do logger para ALL (captura tudo)
//            logger.setLevel(Level.ALL);
//
//        } catch (IOException e) {
//            // Em caso de erro ao configurar o diretório ou o arquivo de log, exibe mensagem no console
//            System.out.println("Erro na configuração do diretório " + className + " :" + e.getMessage());
//        }
//    }

}