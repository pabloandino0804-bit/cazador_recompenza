package ar.edu.unahur.obj2.lugares;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;

import ar.edu.unahur.obj2.Cazadores.Cazador;
import ar.edu.unahur.obj2.Profugos.Profugo;

public class Agencia {
    private String nombre;
    private  Set<Cazador> cazadores;
    
    public Agencia(String nombre, Set<Cazador> cazadores) {
        this.nombre = nombre;
        this.cazadores = cazadores;
    }

    public String getNombre() {
        return nombre;
    }

    public Set<Cazador> getCazadores() {
        return cazadores;
    }

    public void enviarCazadorAZona(Cazador unCazador, Zona unaZona){
        unCazador.realizarProcesoDeCaza(unaZona);
    }

    public List<Profugo> getProfugosCapturados() {
        List<Profugo> profugos = new ArrayList<>();
        cazadores.stream().flatMap(c -> c.getProfugosCapturados().stream()).forEach(p -> profugos.add(p));
        return profugos;
    }

    public Profugo profugoMasHabilCapturado() {
        Integer numeroMax = cazadores.stream().flatMap(c -> c.getProfugosCapturados().stream()).mapToInt(p -> p.getNivelDeHabilidad()).max().orElse(0);
        return cazadores.stream().flatMap(c -> c.getProfugosCapturados().stream()).filter(p -> p.getNivelDeHabilidad() == numeroMax).findFirst().get();
    }

    public Cazador cazadorConMasCapturas() {
        Integer numeroMayor = cazadores.stream().mapToInt(c -> c.cantProfugosCapturados()).max().orElse(0);
        Cazador cazadorMasCapturas = cazadores.stream().filter(c -> c.cantProfugosCapturados() == numeroMayor).findFirst().get();
        return cazadorMasCapturas;
    }
}
