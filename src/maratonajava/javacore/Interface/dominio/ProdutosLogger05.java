package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ProdutosLogger05 {

    private static final String LOGS_DIRETORIO = "logs";
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static Logger getLogger(Class<?> clazz){
        Logger logger = Logger.getLogger(clazz.getName());
        logger.setUseParentHandlers(false);

        if (logger.getHandlers().length == 0){
            configuracaoLogger(logger,clazz.getSimpleName());
        }
        return logger;
    }

    private static void configuracaoLogger(Logger logger, String className){
        try {
            Files.createDirectories(Paths.get(LOGS_DIRETORIO));
            String dataAtual = DATE_FORMAT.format(LocalDateTime.now());
            String logFileName = String.format("log_%s_%s.logs",className,dataAtual);
            Path logFilePath = Paths.get(LOGS_DIRETORIO,logFileName);

            FileHandler fileHandler = new FileHandler(logFilePath.toString(),true);
            fileHandler.setFormatter(new SimpleFormatter());
            fileHandler.setLevel(Level.ALL);

            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);
        }catch (IOException e){
            System.out.println("Erro na configuração do logger -> "+className+" :"+e.getMessage());
        }
    }

//    private static final String LOG_DIRETORIO = "logs";
//    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
//
//    private Logger getLogger(Class<?> clazz){
//        Logger logger = Logger.getLogger(clazz.getName());
//        logger.setUseParentHandlers(false);
//        if (logger.getHandlers().length == 0){
//            configuracaoLogger2(clazz.getSimpleName());
//        }
//        return logger;
//    }
//
//    private static void configuracaoLogger2(Logger logger, String className){
//        try {
//            Files.createDirectories(Paths.get(LOG_DIRETORIO));
//            String dataAtual = DATE_FORMAT.format(new Date());
//            String logFileName = String.format("log_%s_%s.logs",className,dataAtual);
//            Path logFilePath = Paths.get(LOGS_DIRETORIO,logFileName);
//
//            FileHandler fileHandler = new FileHandler(logFilePath.toString(),true);
//            fileHandler.setFormatter(new SimpleFormatter());
//            fileHandler.setLevel(Level.ALL);
//
//            logger.addHandler(fileHandler);
//            logger.setLevel(Level.ALL);
//        }catch (IOException e){
//            System.out.println("Erro na configuração do logger "+className+" :"+e.getMessage());
//        }
//    }
//

}
