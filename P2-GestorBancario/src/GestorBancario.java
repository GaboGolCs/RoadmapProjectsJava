import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class  GestorBancario {

    ArrayList<Cliente> listaClientes= new ArrayList<>();
    ArrayList<Cuenta> listaCuentas = new ArrayList<>();

    public GestorBancario(){}


    public void realizarRetiro(Scanner scanner){
        Cuenta cuentaBuscada = buscaCuentaPorNumero(scanner);
        cuentaBuscada.retirar(scanner);
        //Buscar Cuenta
    }

    public Cliente buscarClientePorRut(String rut){
        for (Cliente cliente : listaClientes){
            if (Objects.equals(cliente.getRut(), rut)) {
                System.out.println("Cliente encontrado");
                return cliente;
            }
        }
        System.out.println("No existe cliente con rut: " + rut);
        return null;
    }


    public void realizarDeposito(Scanner scanner){
        Cuenta cuentaBuscada = buscaCuentaPorNumero(scanner);
        cuentaBuscada.depositar(scanner);
    }

    public Cliente existeClienteoCreaCliente(Scanner scanner){
        //Preguntamos si el cliente esta registrado

        System.out.println("Esta registrado en el banco? \n1.Si \n2.No");
        int opRegistro = Integer.parseInt(Main.stringScan(scanner));
        if(opRegistro == 1){
            //Ingresamos el rut a buscar
            System.out.println("Ingrese el rut para buscar el cliente: ");
            String rut = scanner.nextLine();
            //Buscamos el cliente por rut
            Cliente clienteEncontrado = buscarClientePorRut(rut);
            if (clienteEncontrado!=null){
                return clienteEncontrado;
            }else
            { System.out.println("Error al encontrar el cliente");}

            return null;
        }
        else if(opRegistro == 2){
            //creamos cliente y luego la cuenta con los datos
            Cliente nuevoCliente =  crearCliente(scanner);
            return nuevoCliente;
        }
        return null;
    }

    //seleccion de cuentas
    public void opcionesCrearCuenta(Scanner scanner, int opcion){
        Cliente clienteEncontrado = existeClienteoCreaCliente(scanner);

        if (opcion == 1) {
            if(clienteEncontrado!= null) {
                crearCuentaCorriente(scanner,clienteEncontrado);
            }
            else{
                System.out.println("Error al crear el cliente por lo tanto no se puede crear la cuenta corriente");
            }
        }
        else{
            if (clienteEncontrado !=null)
                crearCuentaAhorro(scanner,clienteEncontrado); //con cliente encontrado
            else
                System.out.println("Error al crear el cliente por lo tanto no se puede crear la cuenta de ahorro");
        }
    }

    // En caso de si existir cliente se crea la cuenta de ahorro con los datos del cliente
    private void crearCuentaAhorro(Scanner scanner, Cliente clienteEncontrado){
        int numeroCuenta = obtenerCantidadCuentas() + 1;
        CuentaAhorro nuevaCuentaA = new CuentaAhorro(numeroCuenta,0,clienteEncontrado.getNombre(), clienteEncontrado.getRut(), clienteEncontrado.getCorreo());
        listaCuentas.add(nuevaCuentaA);
        System.out.println("Cuenta creada con exito con los datos del cliente: " + clienteEncontrado.getRut());
        nuevaCuentaA.mostrarCuentaCompleta();
    }



    private void crearCuentaCorriente(Scanner scanner, Cliente clienteExistente){
        //creamos agregamos numero de cuenta y sobregiro
        int numeroCuenta = obtenerCantidadCuentas() + 1;
        System.out.println("Ingrese un maximo sobregiro: ");
        double maximoSobregiro =Double.parseDouble(Main.stringScan(scanner));
        //creamos cuenta corriente con los datos del cliente existente
        CuentaCorriente nuevaCuentaC = new CuentaCorriente(numeroCuenta,0,clienteExistente.getNombre(), clienteExistente.getRut(), clienteExistente.getCorreo(), maximoSobregiro);
        listaCuentas.add(nuevaCuentaC);
        System.out.println("Cuenta Creada con exito. A continuacion puedes ver el resumen: ");
        nuevaCuentaC.mostrarCuentaCompleta();

    }


    //Creamos un cliente
    public Cliente crearCliente(Scanner scanner){
        String nombre,rut,correo;
        System.out.println("Ingrese nombre completo:");
        nombre = Main.stringScan(scanner);
        System.out.println("Ingrese rut sin puntos y con guion. (Ejemplo: 21065981-1): ");
        rut = Main.stringScan(scanner);
        System.out.println("Ingrese correo: ");
        correo = Main.stringScan(scanner);

        //creamos cliente, lo agregamos a la lista y luego lo mostramos
        Cliente nuevoCliente = new Cliente(nombre,rut,correo);
        this.listaClientes.add(nuevoCliente);
        System.out.println("Cliente creado con exito. A continuacion se muestra un resumen: ");
        nuevoCliente.mostrarCliente();
        return nuevoCliente;
    }

    public void mostrarClientes(){
        if(!listaClientes.isEmpty()) {
            for (Cliente cliente : listaClientes) {
                cliente.mostrarCliente();
            }
        }
        else {
            System.out.println("No hay Clientes registrados por el momento");
        }
    }

    public void mostrarCuentas(){
        if(!listaCuentas.isEmpty()) {
            for (Cuenta cuenta : listaCuentas) {
                cuenta.mostrarCuentaCompleta();
            }
        }else{
            System.out.println("No hay Cuentas registradas por el momento");
        }
    }

    public void aplicarInteres(){
        int nCambios = 0;
        if(!listaCuentas.isEmpty()) {
            for (Cuenta cuenta : listaCuentas) {
                if(cuenta instanceof CuentaAhorro){
                    cuenta.generarIntereses();
                    nCambios++;
                }
            }
        System.out.println("Interes generado correctamente. Se actualizaron: " + nCambios + " Cuentas de ahorro");
        }else{
            System.out.println("No hay Cuentas registradas por el momento");
        }
    }




    private Cuenta buscaCuentaPorNumero(Scanner scanner){

            Cuenta cuentaBuscada = null;

            while (cuentaBuscada == null){
            System.out.println("Ingresa el numero de la cuenta: ");
            int numeroCuentaBuscada = Integer.parseInt(Main.stringScan(scanner));

            //Buscar cuenta
            for (Cuenta listaCuenta : listaCuentas) {
                if (listaCuenta.getNumeroCuenta() == numeroCuentaBuscada) {
                    cuentaBuscada = listaCuenta;
                }
            }

            }
        cuentaBuscada.mostrarCuentaCompleta();

        return cuentaBuscada;
    }

    public int obtenerCantidadCuentas(){
        return this.listaCuentas.size();
    }


}
