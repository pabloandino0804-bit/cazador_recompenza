package ar.edu.unahur.obj2;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import ar.edu.unahur.obj2.Cazadores.Cazador;
import ar.edu.unahur.obj2.Cazadores.CazadorRural;
import ar.edu.unahur.obj2.Cazadores.CazadorSigiloso;
import ar.edu.unahur.obj2.Cazadores.CazadorUrbano;
import ar.edu.unahur.obj2.Profugos.Profugo;
import ar.edu.unahur.obj2.lugares.Zona;

public class CazadorTest {
    private Profugo profugo1;
    private Profugo profugo2;
    private Profugo profugo3;
    private Set<Profugo> grupo;

    @BeforeEach
    void setup(){
        profugo1 = new Profugo("matias", 23, 45, false);
        profugo2 = new Profugo("sebastian", 30, 49, false);
        profugo3 = new Profugo("fred", 40, 48, false);

        grupo = new HashSet<>();
    }

    //Tests parte 1
    @Test
    void unCazadorSigilosoRealizaElProcesoDeCaptraEnUnaZonaCapturandoLosProfugosSinDejarNada() {
        Cazador elCazador = new CazadorSigiloso(50);
        grupo.add(profugo1);
        grupo.add(profugo2);
        grupo.add(profugo3);
        Zona baseProfugo = new Zona("base", grupo);
        elCazador.realizarProcesoDeCaza(baseProfugo);
        assertTrue(baseProfugo.noHayProfugos());
    }

    @Test
    void unCazadorRuralRealizaElProcesoDeCaptraEnUnaZonaCapturandoLosProfugosSinDejarNada(){
        Cazador elCazador = new CazadorRural(50);
        grupo.add(profugo1);
        grupo.add(profugo2);
        grupo.add(profugo3);
        Zona baseProfugo = new Zona("base", grupo);
        elCazador.realizarProcesoDeCaza(baseProfugo);
        elCazador.realizarProcesoDeCaza(baseProfugo);
        assertTrue(baseProfugo.noHayProfugos());
    }

    @Test
    void unCazadorUrbanoRealizaElProcesoDeCaptraEnUnaZonaCapturandoLosProfugosSinDejarNada(){
        Cazador elCazador = new CazadorUrbano(50);
        grupo.add(profugo1);
        grupo.add(profugo2);
        grupo.add(profugo3);
        Zona baseProfugo = new Zona("base", grupo);
        elCazador.realizarProcesoDeCaza(baseProfugo);
        assertTrue(baseProfugo.noHayProfugos());
    }
}
