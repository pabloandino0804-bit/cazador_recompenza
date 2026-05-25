package ar.edu.unahur.obj2.lugares;

import java.util.List;
import java.util.ArrayList;

import ar.edu.unahur.obj2.Cazadores.Cazador;
import ar.edu.unahur.obj2.Profugos.IProfugo;

public class Agencia {
    private static Agencia instance = new Agencia();
    private  List<Cazador> cazadores = new ArrayList<>();
    
    public Agencia() {}

    public static Agencia getInstance() {
        return instance;
    }

    public List<Cazador> getCazadores() {
        return cazadores;
    }

    public void registrarCazador(Cazador unCazador) {
        cazadores.add(unCazador);
    }

    public void enviarCazadorAZona(Cazador unCazador, Zona unaZona){
        unCazador.realizarProcesoDeCaza(unaZona);
    }

    public List<IProfugo> getProfugosCapturados() {
        List<IProfugo> profugos = new ArrayList<>();
        cazadores.stream().flatMap(c -> c.getProfugosCapturados().stream()).forEach(p -> profugos.add(p));
        return profugos;
    }

    public IProfugo profugoMasHabilCapturado() {
        Integer numeroMax = cazadores.stream().flatMap(c -> c.getProfugosCapturados().stream()).mapToInt(p -> p.getNivelDeHabilidad()).max().orElse(0);
        return cazadores.stream().flatMap(c -> c.getProfugosCapturados().stream()).filter(p -> p.getNivelDeHabilidad() == numeroMax).findFirst().get();
    }

    public Cazador cazadorConMasCapturas() {
        Integer numeroMayor = cazadores.stream().mapToInt(c -> c.cantProfugosCapturados()).max().orElse(0);
        return cazadores.stream().filter(c -> c.cantProfugosCapturados() == numeroMayor).findFirst().get();
    }
}
