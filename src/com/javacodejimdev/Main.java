package com.javacodejimdev;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        // Definimos las tasas de cambio.
        double[] tasasDeCambio = {
                3.59,   // Soles Peruanos a dólares
                16.69,  // Pesos Mexicanos a dólares
                3940.56, // Pesos Colombianos a dólares
                97.50,  // Pesos Argentinos a dólares
                29.27,  // Bolivares Venezolanos a dólares
                4.72,   // Reales Brasileños a dólares
                7.82,   // Quetzales Guatemaltecos a dólares
                24.51,  // Lempiras Hondureños
        };

        // Mostramos el menú al usuario.
        int seleccion;
        do {
            seleccion = JOptionPane.showOptionDialog(
                    null,
                    "CONVERSOR DE MONEDAS\n"
                            + "1 - Soles Peruanos a dólares\n"
                            + "2 - Pesos Mexicanos a dólares\n"
                            + "3 - Pesos Colombianos a dólares\n"
                            + "4 - Pesos Argentinos a dólares\n"
                            + "5 - Bolivares Venezolanos a dólares\n"
                            + "6 - Reales Brasileños a dólares\n"
                            + "7 - Quetzales Guatemaltecos a dólares\n"
                            + "8 - Lempiras Hondureños a dólares\n"
                            + "9 - Salir\n\n"
                            + "INGRESE UNA OPCIÓN:",
                    "Conversor de monedas",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "Salir"},
                    tasasDeCambio[0]);

            // Si el usuario seleccionó salir, termina el programa.
            if (seleccion == 8) {
                System.exit(0);
            }

            if (seleccion >= 0 && seleccion < tasasDeCambio.length) {
                // Obtenemos la cantidad de dinero ingresada por el usuario.
                String cantidadMonedaStr = JOptionPane.showInputDialog(
                        "Ingrese la cantidad de "
                                + getNombreMoneda(seleccion + 1)
                                + " a convertir:" + "\n" + "1 USD = "
                                + tasasDeCambio[seleccion]
                                + " " + getNombreMoneda(seleccion + 1));
                if (cantidadMonedaStr == null) {
                    return;
                }

                double cantidadMoneda = 0;
                try {
                    cantidadMoneda = Double.parseDouble(cantidadMonedaStr);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: Por favor, ingrese un valor numérico válido.");
                    return;
                }

                // Calculamos la cantidad de dólares.
                double dolares = cantidadMoneda / tasasDeCambio[seleccion];

                // Mostramos el resultado al usuario.
                String resultadoMensaje = "==========================\n"
                        + "|    Tienes $" + String.format("%.2f", dolares) + " Dolares   |\n"
                        + "==========================";
                JOptionPane.showMessageDialog(null, resultadoMensaje);
            }
        } while (seleccion >= 0 && seleccion < tasasDeCambio.length);
    }

    // Método para obtener el nombre de la moneda según la opción seleccionada.
    public static String getNombreMoneda(int opcion) {
        switch (opcion) {
            case 1:
                return "Soles Peruanos";
            case 2:
                return "Pesos Mexicanos";
            case 3:
                return "Pesos Colombianos";
            case 4:
                return "Pesos Argentinos";
            case 5:
                return "Bolivares Venezolanos";
            case 6:
                return "Reales Brasileños";
            case 7:
                return "Quetzales Guatemaltecos";
            case 8:
                return "Lempiras Hondureños";
            default:
                return "";
        }
    }
}