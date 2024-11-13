public class ComponenteCPU {
   private String componenteCPU;
   private String marcaCPU;
   private int cantidad;
   private double precio;

    public ComponenteCPU(String componenteCPU, double precio, int cantidad, String marcaCPU) {
        this.componenteCPU = componenteCPU;
        this.precio = precio;                   //CONSTRUCTOR
        this.cantidad = cantidad;
        this.marcaCPU = marcaCPU;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getMarcaCPU() {
        return marcaCPU;
    }

    public void setMarcaCPU(String marcaCPU) {
        this.marcaCPU = marcaCPU;
    }

    public String getComponenteCPU() {
        return componenteCPU;
    }

    public void setComponenteCPU(String componenteCPU) {
        this.componenteCPU = componenteCPU;
    }

//--------------recorre todos los componentes y suma sus subtotales.}
    public double calcularSubtotal() {
        return cantidad * precio;
    }

// agregamos metodo toString para tener una impresión legible de los componentes
    @Override
    public String toString() {
         return String.format("%-20s %-10s %-10d %-15.2f %-10.2f", componenteCPU, marcaCPU, cantidad, precio, calcularSubtotal());
    }

}
