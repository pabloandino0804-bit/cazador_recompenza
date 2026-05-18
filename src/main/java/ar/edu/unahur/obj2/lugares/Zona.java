package ar.edu.unahur.obj2.lugares;

import java.util.HashSet;
import java.util.Set;

import ar.edu.unahur.obj2.Profugos.Profugo;

public class Zona {
    private String nombre; 
    private Set<Profugo> profugosEnLaZona = new HashSet<>();

    public Zona(String nombre, Set<Profugo> conjProfugos){
        this.nombre = nombre;
        this.profugosEnLaZona = conjProfugos;
    }

    public String getNombre() {
        return nombre;
    }

    public Set<Profugo> getProfugosEnLaZona() {
        return profugosEnLaZona;
    }

    public Integer profugoConMenorHabilidad(){
        return profugosEnLaZona.stream().mapToInt(p -> p.getNivelDeHabilidad()).min().orElse(0);
    }

    public boolean noHayProfugos(){
        return profugosEnLaZona.isEmpty();
    }

    public void sacarProfugoSiPuede(Profugo unProfugo, Boolean condicion){
        if(condicion) {
            profugosEnLaZona.remove(unProfugo);
        }
    }
}
