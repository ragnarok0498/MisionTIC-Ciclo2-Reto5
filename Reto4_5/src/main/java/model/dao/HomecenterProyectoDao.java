package model.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.vo.HomecenterProyectoVo;
import util.JDBCUtilities;

public class HomecenterProyectoDao {
    public List<HomecenterProyectoVo> listar() throws SQLException {
        ArrayList<HomecenterProyectoVo> respuesta = new ArrayList<HomecenterProyectoVo>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stmt = null;
        ResultSet rset = null;
        String consulta = "SELECT ID_Compra, p.Constructora, p.Banco_Vinculado FROM Compra c JOIN Proyecto p ON c.ID_Proyecto = p.ID_Proyecto WHERE Proveedor = 'Homecenter' AND p.Ciudad = 'Salento'";
        try {
            stmt = conn.createStatement();
            rset = stmt.executeQuery(consulta);
            while (rset.next()) {
                HomecenterProyectoVo vo = new HomecenterProyectoVo();
                vo.setId(rset.getInt("id_compra"));
                vo.setConstructora(rset.getString("constructora"));
                vo.setBanco(rset.getString("banco_vinculado"));
                
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
