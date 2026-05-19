package ar.edu.unahur.obj2.Profugos;

import java.util.HashSet;
import java.util.Set;

import ar.edu.unahur.obj2.NivInvalidoException;

public class Profugo implements IProfugo{
    private String nombre;
    private Integer nivelInocencia = 0;
    private Integer nivelHabilidad;
    private Boolean estaNervioso;
    private Set<String> entrenamientos = new HashSet<>();

    public Profugo(String nombre, Integer nivelInocencia, Integer nivelHabilidad, Boolean estaNervioso) {
        this.nombre = nombre;
        setNivelDeInocencia(nivelInocencia);
        this.nivelHabilidad = nivelHabilidad;
        this.estaNervioso = estaNervioso;
    }

    public String getNombreProfugo(){
        return nombre;
    }

    @Override
    public Integer getNivelDeInocencia() {
        return nivelInocencia;
    }

    @Override
    public Integer getNivelDeHabilidad() {
        return nivelHabilidad;
    }

    @Override
    public Boolean estaNervioso() {
        return estaNervioso;
    }

    public Set<String> getEntrenamientos() {
        return entrenamientos;
    }

    @Override
    public void volverseNervioso() {
        this.estaNervioso = true;
    }

    @Override
    public void dejarSerNervioso() {
        this.estaNervioso = false;
    }

    @Override
    public void reducirHabilidad() {
        this.setNivelDeHabilidad(this.nivelHabilidad-5);
    }

    @Override
    public void disminuirInocencia() {
        if(entrenamientos.contains("proteccionLegal")){
            this.setNivelDeInocencia(Math.max(this.nivelInocencia-2, 40));
        }
        else {
            this.setNivelDeInocencia(this.nivelInocencia-2);
        }
    }

    public void setNivelDeInocencia(Integer nivInocencia) {
        if(nivInocencia == null){
            throw new NullPointerException("El nivel de inocencia no debe ser nulo");
        }
        if(!validarInocencia(nivInocencia)){
            throw new NivInvalidoException("El nivel de inocencia debe estar entre 0 y 100.");
        }
        this.nivelInocencia = nivInocencia;
    }

    private Boolean validarInocencia(Integer nivInocencia) {
        return (nivInocencia >= 0 && nivInocencia <= 100);
    }
    
    private Boolean validarHabilidad(Integer nivHabilidad) {
        return nivHabilidad <= 100;
    }

    @Override
    public void artesMarcialesAvanzadas() {
        this.setNivelDeHabilidad(Math.min(this.nivelHabilidad*2,100));
        entrenamientos.add("artesMarcialesAvanzadas");
    }

    public void setNivelDeHabilidad(Integer nivHabilidad) {
        if(nivHabilidad == null){
            throw new NullPointerException("El nivel de habilidad no debe ser nulo");
        }
        if(!validarHabilidad(nivHabilidad)){
            throw new NivInvalidoException("El nivel de habilidad debe ser mayor a 100.");
        }
        this.nivelHabilidad = Integer.max(nivHabilidad,0);
    }

    @Override
    public void entrenamientoDeElite() {
        this.dejarSerNervioso();
        entrenamientos.add("entrenamientoDeElite");
    }

    @Override
    public void proteccionLegal() {
        if (nivelInocencia < 40){
            setNivelDeInocencia(40);
        }
        entrenamientos.add("proteccionLegal");
    }
}
