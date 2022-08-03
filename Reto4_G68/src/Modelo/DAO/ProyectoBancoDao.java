package Modelo.DAO;
import java.sql.*;
import Utilidades.*;

public class ProyectoBancoDao {
    public static ResultSet consulta(String banco) {
        Statement stmt=null;
        ResultSet rs=null;
        String csql="SELECT Id_Proyecto as ID, Constructora, Ciudad, Proyecto.Clasificacion, Estrato, Nombre||' '||Primer_Apellido||' '||Segundo_Apellido as LIDER FROM Proyecto JOIN Tipo USING(ID_Tipo) JOIN Lider USING(ID_Lider) WHERE Banco_Vinculado='"+banco+"' ORDER BY Fecha_Inicio DESC, Ciudad ASC, Constructora;";

        try {
            var conn=JDBCUtilities.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery(csql);
            
        } catch (Exception e) {
            System.out.println(e);
        }

        return rs;
        
    }
}
