package ar.edu.unahur.obj2.lugares;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.Profugos.IProfugo;

public class Zona {
    private String nombre; 
    private List<IProfugo> profugosEnLaZona = new ArrayList<>();

    public Zona(String nombre, List<IProfugo> grupo){
        this.nombre = nombre;
        this.profugosEnLaZona = grupo;
    }

    public String getNombre() {
        return nombre;
    }

    public List<IProfugo> getProfugosEnLaZona() {
        return profugosEnLaZona;
    }

    public Integer profugoConMenorHabilidad(){
        return profugosEnLaZona.stream().mapToInt(p -> p.getNivelDeHabilidad()).min().orElse(0);
    }

    public boolean noHayProfugos(){
        return profugosEnLaZona.isEmpty();
    }

    public void sacarProfugo(IProfugo unProfugo){
            profugosEnLaZona.remove(unProfugo);
    }
}
