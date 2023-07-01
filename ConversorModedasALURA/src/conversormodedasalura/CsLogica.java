package conversormodedasalura;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Pablo
 */
public class CsLogica {

    String tipoConversor = "";
    String tipoMonedaElegida = "";
    double valorInsertado = 0;

    public void elejirConversor() {

        tipoConversor = selectTipoConversor(); //se guarda que tipo de conversor elije el usuario
        pedirMonto(); //funcion que pide y valida monto a convertir

        switch (tipoConversor) {
            case "Conversor de monedas":
                double total = convertirMoneda(valorInsertado); // se hace la operacion matematica segun sea la moneda
                JOptionPane.showMessageDialog(null, "Tienes: " + tipoMonedaElegida + total);
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

            if (conversorSeleccionado == "") {
                JOptionPane.showMessageDialog(null, "Debe elejir una opción..");
            }
            if (conversorSeleccionado == null) {
                // Si el usuario hace clic en Cancelar o cierra el cuadro de diálogo
                salir();
            }

            if (conversorSeleccionado.trim().isEmpty()) {
                // Si el usuario ingresó una cadena vacía o solo espacios en blanco
                System.out.println("Debe digitar algún valor");
            }

        } while (conversorSeleccionado == "");

        return conversorSeleccionado;
    }

    public void pedirMonto() {

        String input = null;
        do {
            input = JOptionPane.showInputDialog(null, "Ingresa un monto: ");

            if (input == null) {
                // Si el usuario hace clic en Cancelar o cierra el cuadro de diálogo
                salir();
            } else if (input.trim().isEmpty()) {
                // Si el usuario ingresó una cadena vacía o solo espacios en blanco
                JOptionPane.showMessageDialog(null, "Debe digitar algún valor");
            } else {
                valorInsertado = Double.parseDouble(input);
            }
            if (valorInsertado <= 0 || valorInsertado > Double.MAX_VALUE) {

                JOptionPane.showMessageDialog(null, "Valores a convertir deben ser mayores a 0 y menores a " + Double.MAX_VALUE + ".");
            }
        } while (input == null || input.trim().isEmpty() || valorInsertado <= 0 || valorInsertado > Double.MAX_VALUE);
    }

    public double convertirMoneda(double valorInsertado) {
        String tipoMoneda = selectTipoMoneda(); //guarda la moneda elegida
        double monto = 0;

        switch (tipoMoneda) {
            case "Convertir de Colones a Dolar":
                monto = valorInsertado * 0.0018;
                tipoMonedaElegida = "$ ";
                break;
            case "Convertir de Colones a Euros":
                monto = valorInsertado * 0.0017;
                tipoMonedaElegida = "€ ";
                break;
            case "Convertir de Colones a Libras Esterlinas":
                monto = valorInsertado * 0.0015;
                tipoMonedaElegida = "£ ";
                break;
            case "Convertir de Colones a Yen Japonés":
                monto = valorInsertado * 0.27;
                tipoMonedaElegida = "¥ ";
                break;
            case "Convertir de Colones a Won sul-coreano":
                monto = valorInsertado * 2.43;
                tipoMonedaElegida = "₩ ";
                break;

        }

        /*DecimalFormat decimalFormat = new DecimalFormat("#.##");
        // Redondear el número y obtener la representación formateada
        String numeroFormateado = decimalFormat.format(monto);
        monto = Double.parseDouble(numeroFormateado);*/
        return monto;

    }

    public String selectTipoMoneda() {
        String[] opcionesMoneda = {"", "Convertir de Colones a Dolar", "Convertir de Colones a Euros", "Convertir de Colones a Libras Esterlinas",
            "Convertir de Colones a Yen Japonés", "Convertir de Colones a Won sul-coreano"};

        String monedaSelect;

        // Opciones disponibles para que el usuario elija
        //String[] opcionesMoneda = {"", "Convertir de Euros a  colones", "Convertir de Libras Esterlinas a  colones",
        //  "Convertir de Yen Japonés a  colones", "Convertir de Won sul-coreano a  colones"};
        do {
            // Mostrar un cuadro de diálogo con las opciones y obtener la opción seleccionada
            monedaSelect = (String) JOptionPane.showInputDialog(null, "Seleccione una moneda:",
                    "Elegir opción", JOptionPane.QUESTION_MESSAGE, null, opcionesMoneda, opcionesMoneda[0]);

            if (monedaSelect.trim().isEmpty()) {
                // Si el usuario ingresó una cadena vacía o solo espacios en blanco
                JOptionPane.showMessageDialog(null, "Debe elegir alguna moneda");
            }
        } while (monedaSelect.trim().isEmpty());

        return monedaSelect;
    }

    //funcion para salir del programa
    public void salir() {
        int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas salir del programa?",
                "Confirmar", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            System.out.println("Saliendo del programa...");
            System.exit(0);  // Cierra el programa
        } else {
            elejirConversor();
        }
    }
}
