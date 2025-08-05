import java.util.Scanner;

public class CuentaCorriente extends Cuenta {

    private double sobreGiro = 10000;


    //constructor
    public CuentaCorriente(int numeroCuenta, double saldo, String nombre, String rut, String correo, double sobreGiro){
        super(numeroCuenta, saldo, nombre, rut, correo);
        this.sobreGiro = sobreGiro;
    }



    @Override
    public void retirar(Scanner scanner){
        System.out.println("Saldo existente en la cuenta: "+ getSaldo());
        boolean deposito = false;
        while (!deposito){
            System.out.println("\nIngrese el saldo a retirar");
            double saldoRetirar = Double.parseDouble(Main.stringScan(scanner));
            double maximoPosibleRetirar =  getSobreGiro() + getSaldo();
            if(maximoPosibleRetirar  >= saldoRetirar){
                sumarSaldo(-saldoRetirar);
                System.out.println("Saldo de " + saldoRetirar + " Retirado Correctamente");
                deposito = true;//Deposito realizado
            }
            else{
                System.out.println("Saldo insuficiente solo puede retirar hasta: " + getSaldo() + " + " +  getSobreGiro() + " De sobregiro" +  "\nReintente nuevamente");
            }

        }

        System.out.println("Saldo existente en la cuenta despues de la transferencia: "+ getSaldo());
    }


    @Override
    public void mostrarCuentaCompleta() {
        System.out.println("----------------------------------------------");
        System.out.println("Numero de cuenta: " + getNumeroCuenta());
        System.out.println("Saldo : " + getSaldo() + "$");
        System.out.println("Sobregiro Maximo Permitido: " + getSobreGiro() + "$");
        System.out.println("Nombre del titular de la cuenta: " + getNombreTitular());
        System.out.println("Rut del titular de la cuenta: " + getRutTitular());
        System.out.println("Correo del titular de la cuenta: " + getCorreoTitular());


    }

    @Override
    public void generarIntereses() {
        System.out.println("No puede generar intereses este tipo de cuenta");
    }


    public double getSobreGiro(){
        return this.sobreGiro;
    }
    public void setSobreGiro(double ingSobreGiro){
        this.sobreGiro = ingSobreGiro;
    }


}
