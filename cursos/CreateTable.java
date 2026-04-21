package Prac2BD.cursos;
import java.sql.*;

public class CreateTable implements DataBaseTask {
	public CreateTable() {}
    @Override
    public void run(Connection conn, String data) throws SQLException {
    	String sql = "CREATE TABLE imparte("+
    				 "Fecha DATE, "+
    				 "n_modulo INT NOT NULL,"+
    				 "id_aula INT,"+
    				 "id_profesor INT," +
    				 "PRIMARY KEY(n_modulo,id_aula,id_profedor),"+
    				 "FOREIGN KEY(n_modulo) REFERENCES modulo(n_modulo),"+
    				 "ON DELETE CASCADE ON  UPDATE CASCADE,"+
    				 "FOREIGN KEY(id_aula) REFERENCES aula(id),"+
    				 "ON DELETE CASCADE ON  UPDATE CASCADE,"+
    				 "FOREIGN KEY(id_profe) REFERENCES profesor(id)"+
    				 "ON DELETE CASCADE ON  UPDATE CASCADE)";
    	try {
            Statement st = conn.createStatement();
            int rows = st.executeUpdate(sql);
            System.out.println("Filas afectadas: " + rows);
            st.close();
        }
        catch (Exception e) {}
    }
}
