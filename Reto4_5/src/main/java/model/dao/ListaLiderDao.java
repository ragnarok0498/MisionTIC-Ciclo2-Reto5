package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.vo.ListaLiderVo;
import util.JDBCUtilities;

public class ListaLiderDao {

    public List<ListaLiderVo> listar() throws SQLException {
        ArrayList<ListaLiderVo> respuesta = new ArrayList<ListaLiderVo>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stmt = null;
        ResultSet rset = null;
        String consulta = "SELECT ID_Lider as id, Nombre, Primer_Apellido as apellido, Ciudad_Residencia as ciudad FROM Lider ORDER BY Ciudad_Residencia";
        try {
            stmt = conn.createStatement();
            rset = stmt.executeQuery(consulta);
            while (rset.next()) {
                ListaLiderVo vo = new ListaLiderVo();
                vo.setId(rset.getInt("id"));
                vo.setNombre(rset.getString("nombre"));
                vo.setApellido(rset.getString("apellido"));
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
