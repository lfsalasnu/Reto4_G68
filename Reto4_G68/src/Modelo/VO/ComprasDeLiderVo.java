package Modelo.VO;
import java.sql.*;
import Modelo.DAO.*;
public class ComprasDeLiderVo {
    public static void valores() {
        try {
            
            ResultSet rs=ComprasDeLiderDao.consulta();
            
            while(rs.next()){
                String lider=rs.getString("LIDER");
                Float valor=rs.getFloat("VALOR");
                System.out.println(String.format("%-25s %,15.1f", lider, valor));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}
