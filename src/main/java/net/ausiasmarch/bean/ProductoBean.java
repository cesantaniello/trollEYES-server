package net.ausiasmarch.bean;

import com.google.gson.annotations.Expose;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import net.ausiasmarch.dao.TipoProductoDao;

public class ProductoBean implements BeanInterface {

    @Expose
    private Integer id;
    @Expose
    private String codigo;
    @Expose
    private Integer existencias;
    @Expose
    private Double precio;
    @Expose
    private String imagen;
    @Expose
    private String descripcion;
    @Expose(serialize = false)
    private Integer tipo_producto_id;
    @Expose(deserialize = false)
    private TipoProductoBean tipo_producto_obj;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getExistencias() {
        return existencias;
    }

    public void setExistencias(Integer existencias) {
        this.existencias = existencias;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getTipo_producto_id() {
        return tipo_producto_id;
    }

    public void setTipo_producto_id(Integer tipo_producto_id) {
        this.tipo_producto_id = tipo_producto_id;
    }

    public TipoProductoBean getTipo_producto_obj() {
        return tipo_producto_obj;
    }

    public void setTipo_producto_obj(TipoProductoBean tipo_producto_obj) {
        this.tipo_producto_obj = tipo_producto_obj;
    }

    @Override
    public ProductoBean fill(ResultSet oResultSet, Connection oConnection, int spread) throws SQLException {
        this.setId(oResultSet.getInt("id"));
        this.setCodigo(oResultSet.getString("codigo"));
        this.setExistencias(oResultSet.getInt("existencias"));
        this.setPrecio(oResultSet.getDouble("precio"));
        this.setImagen(oResultSet.getString("imagen"));
        this.setDescripcion(oResultSet.getString("descripcion"));
        this.setTipo_producto_id(oResultSet.getInt("tipo_producto_id"));

        if (spread > 0) {
            spread--;
            TipoProductoDao oTipoProductoDao = new TipoProductoDao(oConnection);
            TipoProductoBean oTipoProductoBean = new TipoProductoBean();
            oTipoProductoBean = (TipoProductoBean) oTipoProductoDao.get(this.tipo_producto_id);
            this.tipo_producto_obj = oTipoProductoBean;
        }
        return this;
    }

    @Override
    public PreparedStatement orderSQL(List<String> orden, PreparedStatement oPreparedStatement)
            throws SQLException {
        for (int i = 1; i < orden.size(); i++) {
            if (orden.get((i - 1)).equalsIgnoreCase("id")) {
                oPreparedStatement.setInt(i, 1);
            } else if (orden.get((i - 1)).equalsIgnoreCase("codigo")) {
                oPreparedStatement.setInt(i, 2);
            } else if (orden.get((i - 1)).equalsIgnoreCase("existencias")) {
                oPreparedStatement.setInt(i, 3);
            } else if (orden.get((i - 1)).equalsIgnoreCase("precio")) {
                oPreparedStatement.setInt(i, 4);
            } else if (orden.get((i - 1)).equalsIgnoreCase("imagen")) {
                oPreparedStatement.setInt(i, 5);
            } else if (orden.get((i - 1)).equalsIgnoreCase("descripcion")) {
                oPreparedStatement.setInt(i, 6);
            } else if (orden.get((i - 1)).equalsIgnoreCase("tipo_producto_id")) {
                oPreparedStatement.setInt(i, 7);
            }
        }
        return oPreparedStatement;
    }

    @Override
    public String getFieldInsert() {
        return " (codigo,existencias,precio,imagen,descripcion,tipo_producto_id) VALUES(?,?,?,?,?,?)";
    }

    @Override
    public PreparedStatement setFieldInsert(BeanInterface oBeanParam, PreparedStatement oPreparedStatement) throws SQLException {
        ProductoBean oProductoBean = (ProductoBean) oBeanParam;
        oPreparedStatement.setString(1, oProductoBean.getCodigo());
        oPreparedStatement.setInt(2, oProductoBean.getExistencias());
        oPreparedStatement.setDouble(3, oProductoBean.getPrecio());
        oPreparedStatement.setString(4, oProductoBean.getImagen());
        oPreparedStatement.setString(5, oProductoBean.getDescripcion());
        oPreparedStatement.setInt(6, oProductoBean.getTipo_producto_id());
        return oPreparedStatement;
    }

    @Override
    public String getFieldUpdate() {
        return " (codigo,existencias,precio,imagen,descripcion,tipo_producto_id) VALUES(?,?,?,?,?,?)";
    }

    @Override
    public PreparedStatement setFieldUpdate(BeanInterface oBeanParam, PreparedStatement oPreparedStatement) throws SQLException {
        ProductoBean oProductoBean = (ProductoBean) oBeanParam;
        oPreparedStatement.setString(1, oProductoBean.getCodigo());
        oPreparedStatement.setInt(2, oProductoBean.getExistencias());
        oPreparedStatement.setDouble(3, oProductoBean.getPrecio());
        oPreparedStatement.setString(4, oProductoBean.getImagen());
        oPreparedStatement.setString(5, oProductoBean.getDescripcion());
        oPreparedStatement.setInt(6, oProductoBean.getTipo_producto_id());
        oPreparedStatement.setInt(7, oProductoBean.getId());
        return oPreparedStatement;
    }

}