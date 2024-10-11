import javax.swing.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int option = 0;
        do {
            try {
                option = Integer.parseInt(JOptionPane.showInputDialog(
                        null,
                        """
                                ¿Que ejercicio desea ejecutar?
                                0. Salid
                                1. Calcular el precio final con descuentos
                                2. Generar reportes de inventario
                                3. Gestión de clientes
                                4. Cálculo de descuentos para fidelización
                                5. Promedio de satisfacción del cliente
                                6.
                                7.
                                8.
                                9.
                                """));
                switch (option) {
                    case 0:
                        JOptionPane.showMessageDialog(null, "Programa finalizado");
                        break;
                    case 1:
                        ejercicio1();
                        break;
                    case 2:
                        ejercicio2();
                        break;
                    case 3:
                        ejercicio3();
                        break;
                    case 4:
                        ejercicio4();
                        break;
                    case 5:
                        ejercicio5();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion no valida");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        } while (option != 0);
    }

    //-----------------------Ejercicios-------------------------
    public static void ejercicio1() {
        int[] ventas = new int[30];
        Random random = new Random();
        StringBuilder mensaje = new StringBuilder("Ventas diarias(generacion random)\n");
        int ward = 0;

        for (int i = 0; i < ventas.length; i++) {
            ventas[i] = random.nextInt(1000);
            mensaje.append(ventas[i] + ", ");
            if (ward == 6) {
                mensaje.append("\n");
                ward = 0;
            } else ward++;
        }
        mensaje.append("\nVentas totales: ").append(calcularIngresosMensuales(ventas));
        JOptionPane.showMessageDialog(null, mensaje);
    }
    public static void ejercicio2() {
        String[] productos = {"Televisor", "Celular", "Laptop", "Tablet", "Cámara"};
        int[] stocks = {3, 10, 2, 6, 4};

        generarReporteBajoStock(productos, stocks);

    }
    public static void ejercicio3() {
        String[] clientes = {"Juan", "María", "Pedro", "Ana", "Luis", "Sofía", "Carlos", "Laura", "Javier", "Elena"};
        int[] facturasPendientes = {45, 123, 678, 234, 890, 12, 567, 345, 789, 456};
        enviarFacturas(clientes, facturasPendientes);
    }
    public static void ejercicio4() {
        String[] clientes = {"Juan", "María", "Pedro", "Ana", "Luis", "Sofía", "Carlos", "Laura", "Javier", "Elena"};
        int[] compras = {3, 15, 7, 19, 2, 11, 6, 14, 8, 17};
        calcularDescuento(clientes, compras);
    }
    public static void ejercicio5() {
        int[] calificaciones = {2, 5, 1, 3, 5, 1, 3, 1, 1, 5};
        calcularPromedioSatisfaccion(calificaciones);
    }

    //----------------------Funciones--------------------------
    public static int calcularIngresosMensuales(int[] ventas) {
        int suma = 0;
        for (int venta : ventas) {
            suma += venta;
        }
        return suma;
    }
    public static void generarReporteBajoStock(String[] productos, int[] stocks) {
        StringBuilder mensaje = new StringBuilder("Productos con poco stock\n");
        for (int i = 0; i < productos.length; i++) {
            if (stocks[i] < 5) {
                mensaje.append(productos[i] + " - Unidades: " + stocks[i]+"\n");
            }
        }
                JOptionPane.showMessageDialog(null, mensaje);
    }
    public static void enviarFacturas(String[] clientes, int[] facturasPendientes){
        StringBuilder mensaje = new StringBuilder("Facturas pendientes mayores a 500\n");
        for (int i = 0; i < clientes.length; i++) {
            if(facturasPendientes[i] > 500){
                mensaje.append(clientes[i]).append(" debe: $").append(facturasPendientes[i]).append(".\n");
            }
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }
    public static void calcularDescuento(String[] clientes, int[] compras){
        StringBuilder mensaje = new StringBuilder("Clientes con descuento\n");
        for (int i = 0; i < clientes.length; i++) {
            if(compras[i] > 10) {
                mensaje.append(clientes[i]).append(" compro: ").append(compras[i]).append(" veces.\n");
            }
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }
    public static void calcularPromedioSatisfaccion(int[] calificaciones) {
        float suma = 0;
        for (int i = 0; i < calificaciones.length; i++) {
            suma += calificaciones[i];
        }
        float promedio = suma / calificaciones.length;

        JOptionPane.showMessageDialog(null, "Promedio: "+promedio);
    }
}