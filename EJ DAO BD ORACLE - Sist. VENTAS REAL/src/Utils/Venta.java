package Utils;

public class Venta {
    private int id;
    private String producto;
    private double precio;
    private String fecha;

    public Venta(int id, String producto, double precio, String fecha) {
        this.id = id;
        this.producto = producto;
        this.precio = precio;
        this.fecha = fecha;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
