package view.console;

import java.util.Scanner;
import model.validation.UserDataValidations;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n--- Prueba de validaciones ---");
            System.out.println("1. Validar NIF");
            System.out.println("2. Validar codigo postal");
            System.out.println("3. Calcular edad");
            System.out.println("4. Validar Email"); 
            System.out.println("5. Validar Nombre"); 
            System.out.println("0. Salir");
            System.out.print("Elige una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1) {
                System.out.print("Introduce NIF: ");
                String nif = sc.nextLine();
                if (UserDataValidations.checkId(nif)) {//Entra dentro de userData... y dentro de checkId, si el resultado cumple las condiciones escorrect, else es incorrecto.
                    System.out.println("NIF Correcto");
                } else {
                    System.out.println("NIF Incorrecto");
                }
            }
            else if (opcion == 2) {
                System.out.print("Introduce Codigo Postal (5 numeros): ");
                String cp = sc.nextLine();
                if (UserDataValidations.checkPostalCode(cp)) {//Entra dentro de userData... y dentro de checkPostalCode, si el resultado cumple las condiciones escorrect, else es incorrecto.
                    System.out.println("Codigo postal correcto");
                } else {
                    System.out.println("Codigo postal incorrecto");
                }
            }
            else if (opcion == 3) {
                System.out.print("Introduce fecha de nacimiento (dd/mm/aaaa): ");
                String fecha = sc.nextLine();
                int edad = UserDataValidations.calculateAge(fecha);//Entra dentro de userData... y dentro de CalculateAge, si el resultado cumple las condiciones escorrect, else es incorrecto.
                if (edad != -1) {
                    System.out.println("Tu edad es: " + edad + " años.");
                } else {
                    System.out.println("La fecha no es valida.");
                }
            }
            else if (opcion == 4) {
                System.out.print("Introduce Email: ");
                String email = sc.nextLine();
                if (UserDataValidations.checkEmail(email)) {//Entra dentro de userData... y dentro de checkEmail, si el resultado cumple las condiciones escorrect, else es incorrecto.
                    System.out.println("Email correcto");
                } else {
                    System.out.println("Email incorrecto");
                }
            }
          
            else if (opcion == 5) {
                System.out.print("Introduce Nombre: ");
                String nombre = sc.nextLine();
                if (UserDataValidations.checkName(nombre))//Entra dentro de userData... y dentro de checkName, si el resultado cumple las condiciones escorrect, else es incorrecto.
                    System.out.println("Nombre correcto");
                } else {
                    System.out.println("Nombre incorrecto");
                }
                if (opcion == 0){
                 System.out.println("Practica finalizado");   
            }else{
                System.out.println("Error, no has elegido ninguna opcion valida");
            }
        }
         
    }
}