package com.alura.challenge.principal;

import com.alura.challenge.modelos.ConsultarMonedas;
import com.alura.challenge.modelos.Monedas;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        ConsultarMonedas consulta = new ConsultarMonedas();
        double cantidad;
        String monedaConvertir = "";
        String monedaBase = "";

        int salir = 0;
        while (salir!=9){
            System.out.println("""
                    **Bienvenido al conversor de monedas**
                    Escribe el numero de la moneda base:
                    1. ARS - Peso argentinos                 
                    2. BOB - Boliviano boliviano                                                
                    3. BRL - Real brasileño                                                
                    4. CLP - Peso chileno                                                
                    5. COP - Peso colombiano
                    6. PEN - Sol peruano                                                
                    7. USD - Dólar estadounidense
                    8. Elegir otras monedas 
                    9. Salir
                    """);
            var numero = Integer.valueOf(scanner.nextLine());

            if (numero == 9) {
                salir = 9;
                System.out.println("El programa se cerrara");
                break;
            }
            if(numero != 8) {
                switch (numero) {
                    case 1:
                        monedaBase = "ARS";
                        break;
                    case 2:
                        monedaBase = "BOB";
                        break;
                    case 3:
                        monedaBase = "BRL";
                        break;
                    case 4:
                        monedaBase = "CLP";
                        break;
                    case 5:
                        monedaBase = "COP";
                        break;
                    case 6:
                        monedaBase = "PEN";
                        break;
                    case 7:
                        monedaBase = "USD";
                        break;
                    default:
                        System.out.println("Opcion invalida, intente de nuevo");
                        continue;
                }
                System.out.println("""
                        Ahora escribe el numero de la moneda a convertir:
                        1. ARS - Peso argentinos               
                        2. BOB - Boliviano boliviano                                            
                        3. BRL - Real brasileño                                                
                        4. CLP - Peso chileno                                                
                        5. COP - Peso colombiano                                                
                        7. USD - Dólar estadounidense
                        """);
                var numeroConvert = Integer.valueOf(scanner.nextLine());
                switch (numeroConvert) {
                    case 1:
                        monedaConvertir = "ARS";
                        break;
                    case 2:
                        monedaConvertir = "BOB";
                        break;
                    case 3:
                        monedaConvertir = "BRL";
                        break;
                    case 4:
                        monedaConvertir = "CLP";
                        break;
                    case 5:
                        monedaConvertir = "COP";
                        break;
                    case 6:
                        monedaConvertir = "PEN";
                        break;
                    case 7:
                        monedaConvertir = "USD";
                        break;
                    default:
                        System.out.println("Opcion invalida, intente de nuevo");
                        continue;
                }
                System.out.println("Escriba la cantidad a de " + monedaBase);
                cantidad = Double.parseDouble(scanner.nextLine());
                Monedas monedas = consulta.convertirMonedas(monedaBase, monedaConvertir, cantidad);
                System.out.println("La tasa de conversion hoy es \n 1" + monedaBase + " = " + monedas.conversion_rate() + monedaConvertir);
                System.out.println("El cambio seria = " + monedas.conversion_result() + " " + monedaConvertir);
            }else {
                System.out.println("Escribe el codigo de la moneda :");
                monedaBase = scanner.nextLine().toUpperCase();
                System.out.println("Escribe el codigo de la moneda a convertir :");
                monedaConvertir = scanner.nextLine().toUpperCase();
                System.out.println("Escriba la cantidad a de " + monedaBase);
                cantidad = Double.parseDouble(scanner.nextLine());
                Monedas monedas = consulta.convertirMonedas(monedaBase, monedaConvertir, cantidad);
                System.out.println("La tasa de conversion hoy es \n 1" + monedaBase + " = " + monedas.conversion_rate() + monedaConvertir);
                System.out.println("El cambio seria = " + monedas.conversion_result() + " " + monedaConvertir);
            }
        }
    }
}
