import javax.swing.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int option = 0;
        do{
            try{
                option = Integer.parseInt(JOptionPane.showInputDialog(
                        null,
                        """
                                ¿Que ejercicio desea ejecutar?
                                0. Salid
                                1. Calcular el precio final con descuentos
                                2. 
                                3.
                                4.
                                5.
                                6.
                                7.
                                8.
                                9.
                                """));
                switch(option){
                    case 0:
                        JOptionPane.showMessageDialog(null, "Programa finalizado");
                        break;
                    case 1:
                        ejercicio1();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion no valida");
                }
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
            }
        }while(option != 0);
    }
//-----------------------Ejercicios-------------------------
    public static void ejercicio1(){
        int[] ventas = new int[30];
        Random random = new Random();
        StringBuilder mensaje = new StringBuilder("Ventas diarias(generacion random)\n");
        int ward = 0;

        for (int i = 0; i < ventas.length; i++) {
            ventas[i] = random.nextInt(1000);
            mensaje.append(ventas[i]+", ");
            if(ward == 6) {
                mensaje.append("\n");
                ward = 0;
            }else ward++;
        }
        mensaje.append("\nVentas totales: ").append(calcularIngresosMensuales(ventas));
            JOptionPane.showMessageDialog(null, mensaje);
    }

//----------------------Funciones--------------------------
    public static int calcularIngresosMensuales(int[] ventas){
        int suma = 0;
        for (int venta : ventas) {
            suma += venta;
        }
        return suma;
    }
}