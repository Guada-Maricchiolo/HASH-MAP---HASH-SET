import java.util.HashSet;

public class Computadora {
    private String marcaCompu;
    private String modeloCompu;
    private HashSet<ComponenteCPU> componentes = new HashSet<>();   //HashSet de objetos ComponenteCPU

    public Computadora(String marcaCompu, String modeloCompu){
        this.marcaCompu = marcaCompu;
        this. modeloCompu = modeloCompu;
    }
    //----------permite agregar objetos ComponenteCPU a su lista de componentes-----------------------
    public void agregarComponente(ComponenteCPU componenteCPU){
        componentes.add(componenteCPU);
    }
//--------------recorre todos los componentes y suma sus subtotales.

    public double calcularCostoTotal() {
        double costoTotal = 0;
        for (ComponenteCPU componente : componentes) {
            costoTotal += componente.calcularSubtotal();
        }
        return costoTotal;
    }

    public double calcularPrecioVenta() {
        double costoTotal = calcularCostoTotal();
        if (costoTotal < 50000) {
            return costoTotal * 1.4; // Agrega 40% al precio de costo
        } else {
            return costoTotal * 1.3; // Agrega 30% al precio de costo
        }
    }

    public void mostrarDetalles() {
        System.out.println("-----------Computadora----------------");
        System.out.println("Marca: " + marcaCompu);
        System.out.println("Modelo: " + modeloCompu);
        System.out.println("Componentes:");
        System.out.println("Componente Marca Cantidad Precio X Unidad SubTotal");
        for (ComponenteCPU componente : componentes) {
            System.out.println(componente);
        }
        double costoTotal = calcularCostoTotal();
        System.out.println("Costo Total: " + costoTotal);
        System.out.println("El precio sugerido de venta es " + costoTotal + " + " + (calcularPrecioVenta() - costoTotal) + " = " + calcularPrecioVenta());
    }
}


