package model.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.vo.ProyectoVo;
import util.JDBCUtilities;

public class ProyectoDao {
    public List<ProyectoVo> listar() throws SQLException {
        ArrayList<ProyectoVo> respuesta = new ArrayList<ProyectoVo>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stmt = null;
        ResultSet rset = null;
        String consulta = "SELECT ID_Proyecto as id, Constructora, Numero_Habitaciones as habitaciones, Ciudad FROM Proyecto p WHERE Clasificacion = 'Casa Campestre' AND ciudad in('Santa Marta', 'Cartagena', 'Barranquilla')";
        try {
            stmt = conn.createStatement();
            rset = stmt.executeQuery(consulta);
            while (rset.next()) {
                ProyectoVo vo = new ProyectoVo();
                vo.setId(rset.getInt("id"));
                vo.setConstructora(rset.getString("constructora"));
                vo.setHabitaciones(rset.getInt("habitaciones"));
                vo.setCiudad(rset.getString("ciudad"));

                respuesta.add(vo);
            }
        } finally {
            if (rset != null) {
                rset.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return respuesta;
    }
}
