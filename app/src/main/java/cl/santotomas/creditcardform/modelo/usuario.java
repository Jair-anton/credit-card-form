package cl.santotomas.creditcardform.modelo;


public class usuario {



    private Integer id;
    private String nombre;
    private String apellido;
    private String tarjeta;
    private String mes;
    private String ano;
    private String codigo;
    private String calle;
    private String ciudad;
    private String estado;
    private String codigopostal;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }





    public boolean esVacio(){
        if( this.tarjeta.isEmpty() ||this.mes.isEmpty() || this.ano.isEmpty() || this.codigo.isEmpty() )
            return true;
        return false;
    }





    @Override
    public String toString() {
        return "usuario{" +
                "id=" + id +
                ",nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", tarjeta='" + tarjeta + '\'' +
                ", mes='" + mes + '\'' +
                ", ano='" + ano + '\'' +
                ", codigo='" + codigo + '\'' +
                ", calleynumero='" + calle + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", estado='" + estado + '\'' +
                ", codigopostal='" + codigopostal + '\'' +
                '}';
    }
}
