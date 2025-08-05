public class Cliente{
    protected String nombre;
    protected String rut;
    protected String correo;

    public Cliente(String nombre, String rut, String correo){
        this.nombre = nombre;
        this.rut = rut;
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }



    public void mostrarCliente(){
        System.out.println("Informacion del cliente");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Rut: " + getRut());
        System.out.println("Correo : " + getCorreo());
    }
}
