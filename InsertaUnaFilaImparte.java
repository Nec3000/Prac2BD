package cursos;

import java.sql.*;
import java.time.LocalDate;

public class InsertaUnaFilaImparte implements DataBaseTask {

    @Override
    public void run(Connection conn, String data)throws BBDDException, SQLException {
        String[] datos = data.split(",");
        PreparedStatement psI= conn.
                prepareStatement("INSERT INTO IMPARTE(profesor_id , curso_id , n_modulo , aula_id , fecha) VALUES (?,?,?,?,?)");

        psI.setInt(1,Integer.parseInt(datos[0].trim()));
        psI.setInt(2,Integer.parseInt(datos[1].trim()));
        psI.setInt(3,Integer.parseInt(datos[2].trim()));
        psI.setInt(4,Integer.parseInt(datos[3].trim()));
        Date fecha= Date.valueOf(datos[4].trim());
        psI.setDate(5, fecha);
        int res = psI.executeUpdate();

        psI.close();


    }

}