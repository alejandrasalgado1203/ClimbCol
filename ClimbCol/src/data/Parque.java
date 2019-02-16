
package data;

import java.util.TreeSet;

public class Parque {
                    
    private String nombre;        
    private String ubicacion;
    private String linkUbicacion;
    private String temperaturaPromedio;
    private String campeonato;
    private String linkParque;
    private String direccionImagen;
    private TreeSet<Zona> zonas;
    
    public Parque(String nombre, String ubicacion, String linkUbicacion, String temperaturaPromedio,
			String campeonato, String linkParque, String direccionImagen) {
        super();
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.linkUbicacion = linkUbicacion;
        this.temperaturaPromedio = temperaturaPromedio;
        this.campeonato = campeonato;
        this.linkParque = linkParque;
        this.direccionImagen = direccionImagen;
        zonas = new TreeSet<Zona>();
    }

    public String getNombre() {
            return nombre;
    }
    public void setNombre(String nombre) {
            this.nombre = nombre;
    }
    public String getUbicacion() {
            return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
            this.ubicacion = ubicacion;
    }
    public String getLinkUbicacion() {
            return linkUbicacion;
    }
    public void setLinkUbicacion(String linkUbicacion) {
            this.linkUbicacion = linkUbicacion;
    }
    public String getTemperaturaPromedio() {
            return temperaturaPromedio;
    }
    public void setTemperaturaPromedio(String temperaturaPromedio) {
            this.temperaturaPromedio = temperaturaPromedio;
    }
    public String getCampeonato() {
            return campeonato;
    }
    public void setCampeonato(String campeonato) {
            this.campeonato = campeonato;
    }
    public String getLinkParque() {
            return linkParque;
    }
    public void setLinkParque(String linkParque) {
            this.linkParque = linkParque;
    }
    public String getDireccionImagen() {
            return direccionImagen;
    }
    public void setDireccionImagen(String direccionImagen) {
            this.direccionImagen = direccionImagen;
    }
    
}
