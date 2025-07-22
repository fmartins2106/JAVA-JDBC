package JDCB.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sql.RowSet;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import java.sql.SQLException;

public class CustomRowSetListener implements RowSetListener {


    private static final Logger log = LogManager.getLogger(CustomRowSetListener.class);

    @Override
    public void rowSetChanged(RowSetEvent rowSetEvent) {
        log.info("Command execute triggered");
    }

    @Override
    public void rowChanged(RowSetEvent rowSetEvent) {
        log.info("ROw inserted, updated or deleted");
        if (rowSetEvent.getSource() instanceof RowSet){
            try {
                ((RowSet) rowSetEvent.getSource()).execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void cursorMoved(RowSetEvent rowSetEvent) {
        log.info("Cursor Removed.");
    }
}
