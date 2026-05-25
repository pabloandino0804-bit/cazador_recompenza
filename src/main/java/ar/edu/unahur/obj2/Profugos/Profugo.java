package ar.edu.unahur.obj2.Profugos;

import ar.edu.unahur.obj2.NivInvalidoException;

public class Profugo implements IProfugo{
    private String nombre;
    private Integer nivelInocencia = 0;
    private Integer nivelHabilidad;
    private Boolean estaNervioso;

    public Profugo(String nombre, Integer nivelInocencia, Integer nivelHabilidad, Boolean estaNervioso) {
        this.nombre = nombre;
        setNivelDeInocencia(nivelInocencia);
        this.nivelHabilidad = nivelHabilidad;
        this.estaNervioso = estaNervioso;
    }

    @Override
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
        this.setNivelDeInocencia(this.nivelInocencia-2);
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
        return nivInocencia >= 0 && nivInocencia <= 100;
    }
    
    private Boolean validarHabilidad(Integer nivHabilidad) {
        return nivHabilidad <= 100;
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
}
