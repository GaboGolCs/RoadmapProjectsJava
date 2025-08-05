import java.util.Scanner;

public class CuentaAhorro extends Cuenta{

    static double tasaInteres = 1.1;


    @Override
    public void generarIntereses() {
        sumarSaldo(getSaldo() * getTasaInteres());
    }

    public CuentaAhorro(int numeroCuenta, double saldo, String nombre, String rut, String correo){
        super(numeroCuenta, saldo, nombre, rut, correo);
    }


    @Override
    public void mostrarCuentaCompleta() {
        System.out.println("----------------------------------------------");
        System.out.println("Numero de cuenta: " + getNumeroCuenta());
        System.out.println("Saldo : " + getSaldo() + "$");
        System.out.println("Tasa de Interes Anual: " + getTasaInteres()*10 + "%");
        System.out.println("Nombre del titular de la cuenta: " + getNombreTitular());
        System.out.println("Rut del titular de la cuenta: " + getRutTitular());
        System.out.println("Correo del titular de la cuenta: " + getCorreoTitular());

    }

    public double getTasaInteres(){
        return this.tasaInteres;
    }

    public void setTasaInteres(double nuevaTasa){
        this.tasaInteres = nuevaTasa;
    }



}
