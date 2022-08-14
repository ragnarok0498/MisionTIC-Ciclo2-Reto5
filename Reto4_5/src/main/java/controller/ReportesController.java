package controller;

import java.sql.SQLException;
import java.util.List;
import model.dao.ListaLiderDao;
import model.dao.HomecenterProyectoDao;
import model.dao.ProyectoDao;
import model.vo.ListaLiderVo;
import model.vo.HomecenterProyectoVo;
import model.vo.ProyectoVo;

public class ReportesController {
    private ProyectoDao proyectoDao;
    private ListaLiderDao listaLideresDao;
    private HomecenterProyectoDao homecenterProyectoDao;

    public ReportesController() {
        proyectoDao = new ProyectoDao();
        listaLideresDao = new ListaLiderDao();
        homecenterProyectoDao = new HomecenterProyectoDao();
    }

    public List<ProyectoVo> listarProyectos() throws SQLException {
        return proyectoDao.listar();
    }

    public List<HomecenterProyectoVo> listarHomecenterProyectos() throws SQLException {
        return homecenterProyectoDao.listar();
    }

    public List<ListaLiderVo> listarLideres() throws SQLException {
        return listaLideresDao.listar();
    }
}
