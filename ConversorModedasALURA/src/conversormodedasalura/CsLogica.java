package conversormodedasalura;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author PabloFernádez
 */
public class CsLogica {

    //inicializacion de variables
    String tipoConversor = "";
    String tipoDatoElegida = "";
    double valorInsertado = 0;
    double datoConvertido = 0;
    String dato = "";
    String datoInicial = "";

    public void elegirConversor() {

        tipoConversor = selectTipoConversor(); //se guarda que tipo de conversor elije el usuario
        pedirDato(); //funcion que pide y valida monto a convertir

        switch (tipoConversor) {
            case "Conversor de monedas":
                datoConvertido = convertirMoneda(); // se hace la operacion matematica segun sea la moneda
                JOptionPane.showMessageDialog(null, valorInsertado + datoInicial + "convertidos a " + dato + " son: " + tipoDatoElegida + datoConvertido);

                salir();
                break;

            case "Conversor de distancia":
                datoConvertido = convertirDistancia(); // se hace la operacion matematica segun sea la moneda
                JOptionPane.showMessageDialog(null, valorInsertado + datoInicial + "convertidos a " + dato + " son: " + datoConvertido + tipoDatoElegida);

                salir();
                break;
        }

    }

    public String selectTipoConversor() { //retorna el tipo de conversor
        String conversorSeleccionado = "";

        // Opciones disponibles para que el usuario elija
        String[] tipoConversor = {"", "Conversor de monedas", "Conversor de distancia"};

        do {
            // Mostrar un cuadro de diálogo con las opciones y obtener la opción seleccionada
            conversorSeleccionado = (String) JOptionPane.showInputDialog(null, "Seleccione una opción:",
                    "Elegir opción", JOptionPane.QUESTION_MESSAGE, null, tipoConversor, tipoConversor[0]);

            validacionesBasicas(conversorSeleccionado); //se valida que lo que digite en el input sea correcto

        } while (conversorSeleccionado.isEmpty());

        return conversorSeleccionado;
    }

    public void pedirDato() {

        String input = null;
        do {
            input = JOptionPane.showInputDialog(null, "Ingresa un dato para convertirlo: ");

            if (input == null) {
                // Si el usuario hace clic en Cancelar o cierra el cuadro de diálogo
                salir();
            } else if (input.trim().isEmpty()) {
                // Si el usuario ingresó una cadena vacía o solo espacios en blanco
                JOptionPane.showMessageDialog(null, "Debe digitar algún valor");
            } else {
                if (!input.matches("^\\d+(\\.\\d+)?$")) {
                    JOptionPane.showMessageDialog(null, "Solo valores númericos");
                } else {
                    valorInsertado = Double.parseDouble(input);
                    if (valorInsertado <= 0 || valorInsertado > Double.MAX_VALUE) {

                        JOptionPane.showMessageDialog(null, "Valores a convertir deben ser mayores a 0 y menores a " + Double.MAX_VALUE + ".");
                    }
                }
            }

        } while (!input.matches("^\\d+(\\.\\d+)?$") || input == null || input.trim().isEmpty() || valorInsertado <= 0 || valorInsertado > Double.MAX_VALUE);
    }

    private double convertirDistancia() {

        String tipo = selectTipoDato(); //guarda la moneda elegida
        double distancia = 0;

        switch (tipo) {
            case "Convertir de Metros a Pulgadas":
                distancia = valorInsertado * 39.3701;
                tipoDatoElegida = "''";
                dato = " pulgadas ";
                datoInicial = " metros ";
                break;
            case "Convertir de Pulgadas a Metros":
                distancia = valorInsertado / 39.3701;
                tipoDatoElegida = " m";
                dato = " metros ";
                datoInicial = " pulgadas ";
                break;
            case "Convertir de Millas a Kilometros":
                distancia = valorInsertado * 1.60934;
                tipoDatoElegida = " km";
                dato = " kilometros";
                datoInicial = " millas ";
                break;
            case "Convertir de Kilometros a Millas":
                distancia = valorInsertado / 1.60934;
                tipoDatoElegida = " millas";
                dato = " millas";
                datoInicial = " kilometros ";
                break;
        }
        return distancia;

    }

    public double convertirMoneda() {
        String tipoMoneda = selectTipoDato(); //guarda la moneda elegida
        double monto = 0;

        switch (tipoMoneda) {
            case "Convertir de Colones a Dolar":
                monto = valorInsertado * 0.0018;
                tipoDatoElegida = "$ ";
                dato = " dolares ";
                datoInicial = " colones ";
                break;
            case "Convertir de Colones a Euros":
                monto = valorInsertado * 0.0017;
                tipoDatoElegida = "€ ";
                dato = " euros ";
                datoInicial = " colones ";
                break;
            case "Convertir de Colones a Libras Esterlinas":
                monto = valorInsertado * 0.0015;
                tipoDatoElegida = "£ ";
                dato = " libras esterlinas";
                datoInicial = " colones ";
                break;
            case "Convertir de Colones a Yen Japonés":
                monto = valorInsertado * 0.27;
                tipoDatoElegida = "¥ ";
                dato = " yenes ";
                datoInicial = " colones ";
                break;
            case "Convertir de Colones a Won sul-coreano":
                monto = valorInsertado * 2.43;
                tipoDatoElegida = "₩ ";
                dato = " Won sul-coreanos ";
                datoInicial = " colones ";
                break;

            case "Convertir de Dolares a colones":
                monto = valorInsertado / 0.0018;
                tipoDatoElegida = "₡ ";
                dato = "colones";
                datoInicial = " Dolares ";
                break;
            case "Convertir de Euros a colones":
                monto = valorInsertado / 0.0017;
                tipoDatoElegida = "₡ ";
                dato = "colones";
                datoInicial = " Euros ";
                break;
            case "Convertir de Libras Esterlinas a colones":
                monto = valorInsertado / 0.0015;
                tipoDatoElegida = "₡ ";
                dato = "colones";
                datoInicial = " Libras Esterlinas ";
                break;

            case "Convertir de Yen Japonés a colones":
                monto = valorInsertado / 0.27;
                tipoDatoElegida = "₡ ";
                dato = "colones";
                datoInicial = " yen ";
                break;
            case "Convertir de Won sul-coreano a colones":
                monto = valorInsertado / 2.43;
                tipoDatoElegida = "₡ ";
                dato = "colones";
                datoInicial = " Won sul-coreano ";
                break;

        }

        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        // Redondear el número y obtener la representación formateada
        String numeroFormateado = decimalFormat.format(monto);
        monto = Double.parseDouble(numeroFormateado);
        return monto;

    }

    public String selectTipoDato() {
        String[] opcionesMoneda = opLista(); //se van aguardar las fiferentes opciones de tipos de conversiones
        String monedaSelect;

        do {
            // Mostrar un cuadro de diálogo con las opciones y obtener la opción seleccionada
            monedaSelect = (String) JOptionPane.showInputDialog(null, "Seleccione alguna opción para realizar la conversión:",
                    "Elegir opción", JOptionPane.QUESTION_MESSAGE, null, opcionesMoneda, opcionesMoneda[0]);

            validacionesBasicas(monedaSelect); //se valida que lo que digite en el input sea correcto
        } while (monedaSelect.trim().isEmpty());

        return monedaSelect;
    }

    public String[] opLista() {
        String[] opcionesLista = null;

        if (tipoConversor.equals("Conversor de monedas")) {
            opcionesLista = new String[]{
                "", "Convertir de Colones a Dolar", "Convertir de Colones a Euros", "Convertir de Colones a Libras Esterlinas",
                "Convertir de Colones a Yen Japonés", "Convertir de Colones a Won sul-coreano", " ", "Convertir de Dolares a colones",
                "Convertir de Euros a colones", "Convertir de Libras Esterlinas a colones",
                "Convertir de Yen Japonés a colones", "Convertir de Won sul-coreano a colones"
            };
        } else if (tipoConversor.equals("Conversor de distancia")) {
            opcionesLista = new String[]{
                "", "Convertir de Metros a Pulgadas", "Convertir de Kilometros a Millas",
                "Convertir de Pulgadas a Metros", "Convertir de Millas a Kilometros"
            };
        }

        return opcionesLista;
    }

    //funcion para salir del programa
    public void salir() {
        int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas salir del programa?",
                "Confirmar", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {

            JOptionPane.showMessageDialog(null, "Saliendo del programa...");
            System.exit(0);  // Cierra el programa

        } else {
            elegirConversor();
        }
    }

    private boolean validacionesBasicas(String dato) {

        if (dato == null) {
            salir();

        }
        if (dato.trim().isEmpty()) {
            // Si el usuario ingresó una cadena vacía o solo espacios en blanco
            JOptionPane.showMessageDialog(null, "Debe elegir alguna opción");
            return false;
        }
        return true;
    }
}
