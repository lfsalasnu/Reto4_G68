package Modelo.DAO;
import java.sql.*;
import Utilidades.*;
public class DeudasPorProyectoDao {
    public static ResultSet consulta(double limiteInferior) {
        Statement stmt=null;
        ResultSet rs=null;
        String csql="SELECT ID_Proyecto, SUM(Cantidad*Precio_Unidad) as VALOR FROM Compra  JOIN MaterialConstruccion USING(ID_MaterialConstruccion)  WHERE Pagado='No' GROUP BY ID_Proyecto HAVING VALOR>"+limiteInferior+" ORDER BY VALOR DESC;";
        
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
