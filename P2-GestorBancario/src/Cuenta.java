import java.util.Scanner;

public abstract class  Cuenta {
    int numeroCuenta;
    double saldo;
    Cliente  titularCuenta;

    public Cuenta(int numeroCuenta, double saldo, String nombre, String rut, String correo ){
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.titularCuenta = new Cliente(nombre, rut, correo);
    }

    public void depositar(Scanner scanner){
        System.out.println("\nIngrese el saldo a depositar");
        double saldoDepositar = Double.parseDouble(Main.stringScan(scanner));
        sumarSaldo(saldoDepositar);
        System.out.println("Saldo de " + saldoDepositar + "$ Depositado Correctamente");
        System.out.println("Saldo existente en la cuenta actualizado a: "+ saldo);

    }



    public void retirar(Scanner scanner){
        boolean deposito = false;
        while (!deposito){
            System.out.println("\nIngrese el saldo a retirar");
            double saldoRetirar = Double.parseDouble(Main.stringScan(scanner));
            if(saldo>= saldoRetirar){
                sumarSaldo(-saldoRetirar);
                System.out.println("Saldo de " + saldoRetirar + " Retirado Correctamente");
                deposito = true;//Deposito realizado
            }
            else{
                System.out.println("Saldo insuficiente solo puede retirar hasta: " + saldo + "\n Reintente nuevamente");
            }
            System.out.println("Saldo existente en la cuenta: "+ saldo);
    }
    }

    public abstract void mostrarCuentaCompleta();
    public abstract void  generarIntereses(); // metodo abstracto


    public void sumarSaldo(double saldo) {
        this.saldo = this.saldo + saldo;
    }

    public Cliente getTitualarCuenta(){
        return this.titularCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setTitularCuenta(Cliente titularCuenta) {
        this.titularCuenta = titularCuenta;
    }

    public  String getNombreTitular() {
        return this.titularCuenta.getNombre();
    }

    public  String getRutTitular() {
        return this.titularCuenta.getRut();
    }

    public  String getCorreoTitular() {
        return this.titularCuenta.getCorreo();
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }






}
