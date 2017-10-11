package jorgemedina.practicasqlite_v1;

import java.io.Serializable;

/**
 * Created by jlmgm on 09/10/2017.
 */

public class Pojo_Contact implements Serializable {

    int id;
    String nombre;
    String correo_electronico;
    String twitter;
    String telefono;
    String fecha_nacimiento;

    public Pojo_Contact() {


    }

    public int getId() {

        return id;

    }

    public Pojo_Contact(int id, String nombre, String correo_electronico, String twitter, String telefono, String fecha_nacimiento) {

        this.id = id;
        this.nombre = nombre;
        this.correo_electronico = correo_electronico;
        this.twitter = twitter;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;

    }

    public void setId(int id) {

        this.id = id;

    }

    public String getNombre() {

        return nombre;

    }

    public void setNombre(String nombre) {

        this.nombre = nombre;

    }

    public String getCorreo_electronico() {

        return correo_electronico;

    }

    public void setCorreo_electronico(String correo_electronico) {

        this.correo_electronico = correo_electronico;

    }

    public String getTwitter() {

        return twitter;

    }

    public void setTwitter(String twitter) {

        this.twitter = twitter;

    }

    public String getTelefono() {

        return telefono;

    }

    public void setTelefono(String telefono) {

        this.telefono = telefono;

    }

    public String getFecha_nacimiento() {

        return fecha_nacimiento;

    }

    public void setFecha_nacimiento(String fecha_nacimiento) {

        this.fecha_nacimiento = fecha_nacimiento;

    }



    @Override
    public String toString() {

        return "\nID:"+this.id + "\nNombre:" + this.nombre + "\nCorreo:" + this.correo_electronico+ "\nTwiter:" + this.twitter+ "\nTelefono:" + this.telefono+ "\nFecha_nac:" + this.fecha_nacimiento+"\n";

    }



}
