import com.google.gson.Gson;
import modelos.FiltroCambio;
import modelos.MonedasIniciales;
import modelos.ResultadoJson;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner entrada = new Scanner(System.in);
        int eleccionMonedaOrigen = 1, eleccionMonedaDestino=1, continuarCantidad=1;
        MonedasIniciales cambio = new MonedasIniciales();
        String monedaConversion;
        Double cantidad;

        System.out.println("\nCONVERSOR DE MONEDAS");
        while (eleccionMonedaOrigen != 0) {
            ResultadoJson json = new ResultadoJson();
            Gson gson = new Gson();
            FiltroCambio filtroCambio = gson.fromJson(json.getJson(), FiltroCambio.class);

            System.out.println("\nMoneda de origen: " + filtroCambio.getBase_code());
            System.out.print("Opciones: \n1 Continuar\n0 Salir\nDigite una opcion: ");
            eleccionMonedaOrigen = entrada.nextInt();

            if (eleccionMonedaOrigen == 1) {
                eleccionMonedaDestino = 1;
                while (eleccionMonedaDestino != 0) {
                    System.out.println("\nDenominaciones disponibles: ");
                    cambio.imprimirListaMonedas();
                    System.out.println("0 Salir");
                    System.out.print("Digite la moneda de destino: ");
                    eleccionMonedaDestino = entrada.nextInt();

                    if (eleccionMonedaDestino >= 1 && eleccionMonedaDestino <= 5) {
                        monedaConversion = cambio.seleccionar(eleccionMonedaDestino);
                        System.out.println("Se seleccionó: " + monedaConversion);
                        System.out.println("El cambio está en 1 " + filtroCambio.getBase_code() +
                                " a " + filtroCambio.getConversion_rates().get(monedaConversion) + " " +
                                monedaConversion);
                        continuarCantidad = 1;
                        while (continuarCantidad == 1) {
                            System.out.println("\nIngrese la cantidad: ");
                            cantidad = entrada.nextDouble();
                            System.out.println("El resultado para: " + cantidad + " " + filtroCambio.getBase_code() +
                                    " es de: " + (cantidad * filtroCambio.getConversion_rates().get(monedaConversion)) + " " + monedaConversion);
                            System.out.print("\n\nOpciones:\n1 Continuar\n2 Otra moneda de destino\n3 Otra moneda de origen\n0 Salir\nDigite la opción de su interés: ");
                            continuarCantidad = entrada.nextInt();

                            if (continuarCantidad == 0) {
                                break;
                            }
                        }
                    }

                    if (continuarCantidad == 0 || eleccionMonedaDestino == 0) {
                        break;
                    }

                    if (eleccionMonedaDestino < 0 || eleccionMonedaDestino > 5) {
                        System.out.println("\n¡Valor incorrecto!\nSeleccione una opción válida");
                    }
                }
            }

            if (continuarCantidad == 0 || eleccionMonedaDestino == 0 || eleccionMonedaOrigen == 0) {
                break;
            }

            if (eleccionMonedaOrigen < 0 || eleccionMonedaOrigen > 2) {
                System.out.println("\n¡Valor incorrecto!\nSeleccione una opción válida");
            }
        }

        System.out.println("\nFinalización del programa");
    }
}