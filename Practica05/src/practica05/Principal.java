/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica05;

import java.util.Scanner;
import paqueteuno.Porcentajes;
/**
 *
 * @author Junior Aguilar
 */
public class Principal {
    public static void main(String[] args) {
        // Declaramos las variables
        double matriculaI = 1330;
        double descCiudad = 0;
        double descEdad = 0;
        double descEstadoCivil = 0;
        double descFamilia = 0;
        String ciudad;
        int edad;
        String estado;
        int cargaFamilia;
        double matriculaFinal;
        double costoFinal;
        
        Scanner entrada = new Scanner(System.in);
        
        // Solicitamos la informacion del estudiante por teclado
        
        System.out.println("Ingrese su ciudad de origen: ");
        ciudad = entrada.nextLine();
        System.out.println("Ingrese su edad: ");
        edad = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Ingrese su estado Civil: ");
        estado = entrada.nextLine();
        System.out.println("¿Cuantas cargas familiares tiene?: ");
        cargaFamilia = entrada.nextInt();
        
       // Si proviene de Loja o Zamora se le realiza un descuento
        if ( (ciudad.equals("Loja")) || ("Zamora".equals(ciudad)) ){
            descCiudad = matriculaI * Porcentajes.porcentajeCiudad;
        }
        // Si es mayor o igual a 17 y menor a 20 años, se le hace un descuento
        if (edad >= 17 && edad < 20){
            descEdad = matriculaI * Porcentajes.porcentajeEdad;
        }
        // Si su estado civil es Casado se le realiza otro descuento
        if ("casado".equals(estado) ){
            descEstadoCivil = matriculaI * Porcentajes.porcentajeEstadoCivil;
        }
        // Si tiene una carga familiar se le realiza otro descuento
        if (cargaFamilia > 0){
            descFamilia = matriculaI * Porcentajes.porcentajeCargaFamilia;
        }
        // Se resta los descuentos a la matricula inicial
        matriculaFinal = matriculaI - descCiudad - descEdad - descEstadoCivil
                - descFamilia;
        // Se aumenta un 2% por gastos administrativos
        costoFinal = matriculaFinal + 
                (matriculaFinal * Porcentajes.porcentajeAdministrativo);
        
        // Mostramos el costo final a pagar de la matricula
        System.out.printf("El Costo final es: %.2f \n", costoFinal);
    }
    
}
