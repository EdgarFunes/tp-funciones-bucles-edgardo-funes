import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int option = 0;
        do{
            try{
                option = Integer.parseInt(JOptionPane.showInputDialog(
                        null,
                        """
                                ¿Que ejercicio desea ejecutar?
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
                    case 1:
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion no valida");
                }
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
            }
        }while(option != 0);
    }
}