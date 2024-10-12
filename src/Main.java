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
                                6. Cálculo de impuestos
                                7. Descuento por compras grandes
                                8. Control de horas trabajadas
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
                    case 6:
                        ejercicio6();
                        break;
                    case 7:
                        ejercicio7();
                        break;
                    case 8:
                        ejercicio8();
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
    public static void ejercicio6() {
        double[] facturas = {100.00, 250.50, 75.75, 400.00, 150.25};

        // Calcular y mostrar el impuesto para cada factura
        StringBuilder resultado = new StringBuilder("Impuestos de venta:\n");
        for (double factura : facturas) {
            double impuesto = calcularImpuesto(factura);
            resultado.append("Factura: ").append(factura).append(" - Impuesto: ").append(impuesto).append("\n");
        }

        // Mostrar el resultado
        JOptionPane.showMessageDialog(null, resultado.toString());
    }
    public static void ejercicio7() {
        double[] compras = {450.00, 600.00, 300.50, 800.00, 520.75};

        // Calcular y mostrar el monto final para cada compra
        StringBuilder resultado = new StringBuilder("Montos finales después del descuento:\n");
        for (double compra : compras) {
            double montoFinal = aplicarDescuento(compra);
            resultado.append("Compra: ").append(compra).append(" - Monto final: ").append(montoFinal).append("\n");
        }

        // Mostrar el resultado
        JOptionPane.showMessageDialog(null, resultado.toString());
    }
    public static void ejercicio8() {
        String[] empleados = {"Juan", "María", "Pedro", "Ana", "Luis"};
        // Crear un arreglo con las horas trabajadas por cada empleado
        double[] horasTrabajadas = new double[empleados.length];

        // Solicitar las horas trabajadas para cada empleado
        for (int i = 0; i < empleados.length; i++) {
            String input = JOptionPane.showInputDialog("Ingrese las horas trabajadas por " + empleados[i] + ":");
            horasTrabajadas[i] = Double.parseDouble(input);
        }

        // Calcular y mostrar el pago semanal para cada empleado
        StringBuilder resultado = new StringBuilder("Pagos semanales:\n");
        for (int i = 0; i < empleados.length; i++) {
            double pago = calcularPagoSemanal(horasTrabajadas[i]);
            resultado.append(empleados[i]).append(": $").append(pago).append("\n");
        }

        // Mostrar el resultado
        JOptionPane.showMessageDialog(null, resultado.toString());
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
        for (int calificacione : calificaciones) {
            suma += calificacione;
        }
        float promedio = suma / calificaciones.length;

        JOptionPane.showMessageDialog(null, "Promedio: "+promedio);
    }
    public static double calcularImpuesto(double monto) {
        return monto * 0.21;
    }
    public static double aplicarDescuento(double monto) {
        if (monto > 500) {
            return monto * 0.85; // Aplica el 15% de descuento
        }
        return monto; // Sin descuento
    }
    public static double calcularPagoSemanal(double horas) {
        double tarifaPorHora = 15.0; // Tarifa de $15 por hora
        return horas * tarifaPorHora; // Calcular el pago
    }
}