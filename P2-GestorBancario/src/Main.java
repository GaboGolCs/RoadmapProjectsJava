import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int opcionMenu = -1;


        Scanner scanner = new Scanner(System.in); //scanner para trabajar
        boolean salir = false;

        GestorBancario banco = new GestorBancario();

        System.out.println("BIENVENIDO AL SISTEMA BANCARIO DE GABRIEL");
        do{

            System.out.println("\nSeleccione mediante su teclado la opcion a utilizar");
            System.out.println("1.Crear cliente");
            System.out.println("2.Abrir cuenta");
            System.out.println("3.Mostrar cuentas existentes y su saldo");
            System.out.println("4.Depositar en una cuenta");
            System.out.println("5.Retirar de una cuenta");
            System.out.println("6.Aplicar Interes en toda cuenta de ahorro");
            System.out.println("0.Salir");
            System.out.print("---->");
            opcionMenu =  Integer.parseInt(scanner.nextLine());
            System.out.println(opcionMenu);

            switch (opcionMenu){
                case 1:
                    banco.crearCliente(scanner);
                    banco.mostrarClientes();
                    break;
                case 2:
                    int opcionCuenta =-1;
                    boolean listo = false;

                    while (!listo){
                        System.out.println("\nElija el tipo de cuenta a crear:");
                        System.out.println("1.Cuenta Corriente");
                        System.out.println("2.Cuenta Ahorro");
                        opcionCuenta =  Integer.parseInt(stringScan(scanner));

                        if(opcionCuenta == 1 || opcionCuenta == 2){
                            listo = true;
                            banco.opcionesCrearCuenta(scanner,opcionCuenta);
                        }
                        else {
                            System.out.println("Error: Ingrese una opcion valida");
                        }
                    }

                    break;
                case 3:
                    System.out.println("\nA continuacion se muestran todas las cuentas:");
                    banco.mostrarCuentas();

                    break;
                case 4:
                    banco.realizarDeposito(scanner);
                    break;
                case 5:
                    banco.realizarRetiro(scanner);
                    break;
                case 6:
                    banco.aplicarInteres();
                    break;
                case 0:

                    salir = true;
                    break;
            }

        }while (!salir);


    }

    public static String stringScan(Scanner scanner){
        boolean listo = false; //bandera
        String res = "";
        while (!listo){
            try {
                res =  scanner.nextLine();
                listo = true;
                return res;

            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Error al ingresar el dato. Reintente nuevamente:");
        }

        return res;
    }


}


