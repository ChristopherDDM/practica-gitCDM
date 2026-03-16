package model.validation;

import java.time.LocalDate;
import java.time.Period;

public class UserDataValidations {

    public static boolean checkId(String id) {
        if (id.length() == 9) {//hay un condicional en el que pregunta si hay 9 nums
            return isNumeric(id.substring(0, 8)) && isAlphabetic(id.substring(8));//el substring corta el texto y se queda con los 8 primero carácteres
            //índices del 0 al 7, es decir, solo se queda con el los números.
        }
        return false;// si no mide 9 ni lo intenta validar.
    }

    public static boolean checkPostalCode(String cp) {
        return cp.length() == 5 && isNumeric(cp); // si es númerico y hay 5 números es correcto si no, no es válido
    }

    public static boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) { //si no es un número devuelve falso 
                return false;
            }
        }
        return true;//si el bucle termina y no encuentra nada raro, todos som números.
    }

    public static boolean isAlphabetic(String str) {
        for (int i = 0; i < str.length(); i++) { //
            char letra = str.charAt(i);
            if (!Character.isLetter(letra) && letra != ' ') {
                return false;
            }
        }
        return true;
    }

    public static int calculateAge(String birthDate) {
        if (!checkFormatDate(birthDate)) {
            return -1;
        }
        try { // try en un seguro para el código, nos dice " voy a ejecutarlo pero sé que algo podría salir mal."
            String[] partes = birthDate.split("/");
            int d = Integer.parseInt(partes[0]); //almacena en arrays 
            int m = Integer.parseInt(partes[1]); //almacena en arrays 
            int a = Integer.parseInt(partes[2]); //almacena en arrays 

            LocalDate nacimiento = LocalDate.of(a, m, d);//LocalDate entiende los número proporcionados y los transforma en una fecha.
            return Period.between(nacimiento, LocalDate.now()).getYears(); //con period between calculamos la edad que tenemos y lo compara con LocalDate.now. Por último con el get years solo recopila el valor de años.
        } catch (Exception e) {// el catch coge el error y lo gestiona, nos dice algo así como " si algo falla quí dentro, no rompas el programa, salta directamente a esta sección y maneja el error.
            return -1; //sirve para no romper el programa y hacer que se repita este.
        }
    }

    public static boolean checkFormatDate(String date) {
        String[] partes = date.split("/"); // usamos / para separar entre fechas. 
        if (partes.length != 3) { // si las la medida de las partes es diferente a 3 es falso 
            return false;
        }
        try { // en este caso el try está funcionando como un if, 
            int d = Integer.parseInt(partes[0]); // toma los trozos de texto y trata de convertirlos en números (int)
            int m = Integer.parseInt(partes[1]);//si escribes algo que no es un número el parseint se alarmará y lanza un error (NumberFormatException).
             if (m == 2 && d > 28) { // si en el mes dos el día es más alto que 28 devuelve falso.
                return false;    
             }
            int a = Integer.parseInt(partes[2]);// si haces lo que hemos dicho anteriormente salta directamente al catch y devuelve false.
            return (d >= 1 && d <= 31) && (m >= 1 && m <= 12) && (a > 1900);//aquí se evalua que los números del mes y día tengan sentido.

        } catch (Exception e) { //e es la variable donde se guarda la informacióon del error. Aun que no aparezca en el código, java necesita ponerle un nombre paa poder manejarla.
            return false;

        }
    }

    

    

    public static boolean checkEmail(String email) {
        boolean tieneArroba = email.contains("@");//creamos tres variables booleanas
        boolean terminaCom = email.endsWith(".com");
        boolean terminaEs = email.endsWith(".es");

        if (tieneArroba && (terminaCom || terminaEs)) { //si tiene estas características return true, si no, return false.
            return true;
        } else {
            return false;

        }
    }

    public static boolean checkName(String name) {
        if (name.length() < 3) {// si el nombre es menor de 3 letras return falso 
            return false;
        }
        if (isAlphabetic(name)) { //si son letras de la A a la Z devuelve verdadero, si no devuelve falso.
            return true;
        } else {
            return false;
        }
    }

}
