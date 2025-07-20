import java.util.Scanner;
import java.text.DecimalFormat;


public class Main {
    public static void main(String[] args) {
        double res; //guarda los resultados
        int opcion = 0; //opcion del menu
        boolean salir = false; // Mantiene el menu abierto
        Scanner scanner = new Scanner(System.in);//creamos el scanner
        //Incializamos instancia para formatear decimales
        DecimalFormat formato = new DecimalFormat("#.00"); //si no existen mas decimales agrega hasta 2 ceros, solo sirve para imprimir no cambia el res


        System.out.println("Bienvenido a la calculadora de GaboGol");
        do{
        System.out.println("\nElija una de las siguientes opciones:");
        System.out.println("1.Suma de dos numeros reales");
        System.out.println("2.Resta de dos numeros reales");
        System.out.println("3.Multiplicacion de dos numeros reales");
        System.out.println("4.Division de dos numeros reales");
        System.out.println("->Ingrese cualquier otra tecla para salir");

        opcion = scanner.nextInt();



        switch (opcion){
            case 1:
                System.out.println("Bienvenido al sumador");
                res = sumar(scanner);
                System.out.println("El resultado de la suma es: "+ formato.format(res));
                break;
            case 2:
                System.out.println("Bienvenido al restador");
                res = restar(scanner);
                System.out.println("El resultado de la resta es: "+ formato.format(res));
                break;

            case 3:
                System.out.println("Bienvenido a el Multiplicador");
                res = multiplicar(scanner);
                System.out.println("El resultado de la multiplicacion es: " + formato.format(res));
                break;
            case 4:
                System.out.println("Bienvenido al Divisor");
                res = dividir(scanner);
                System.out.println("El resultado de la division es: " + formato.format(res));
                break;
            default:
                System.out.println("Salida exitosa");
                salir = true;
                scanner.close(); //cerramos el scanner
                break;
        }
        }while (!salir); //Mientras salir = true mantenemos le ciclo


    }

    public static double sumar (Scanner scanner){
        double a,b;
        System.out.println("Ingrese el primer numero a sumar");
        a = scannerCatcher(scanner);
        System.out.println("Ingrese el segundo numero a sumar");
        b = scannerCatcher(scanner);
        return a+b;

    }

    public static double restar(Scanner scanner){
        double a,b;
        System.out.println("Ingrese el primer numero a restar");
        a = scannerCatcher(scanner);
        System.out.println("Ingrese el segundo numero a restar");
        b = scannerCatcher(scanner);
        return a-b;
    }

    public static double multiplicar(Scanner scanner){
        double a,b;
        System.out.println("Ingrese el primer numero a Multiplicar");
        a = scannerCatcher(scanner);
        System.out.println("Ingrese el segundo numero a Multiplicar");
        b = scannerCatcher(scanner);
        return a*b;
    }

    public static double dividir(Scanner scanner){
        double a,b = 0.0;
        System.out.println("Ingrese un dividendo");
        a = scannerCatcher(scanner);
        System.out.println("Ingrese un divisor");
        do {
            b = scannerCatcher(scanner);
            if(b == 0.0){
                System.out.println("Error: No existe la division por 0" + "\nIngrese un divisor valido:");
            }
        }while (b == 0.0);

        return a/b;

    }

    public static double scannerCatcher(Scanner scanner){
        double x= 0;
        boolean err = false;

        do{
            try {
                x = (double) scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("Error: " + e);
                System.out.println("Ingrese un numero decimal valido");
                err = true;
            }
        }while (err);


        return x;
    }
}