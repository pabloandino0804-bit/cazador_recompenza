package ar.edu.unahur.obj2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.Profugos.Profugo;

public class ProfugoTest {
    private Profugo miProfugo;

    @BeforeEach 
    void setup(){
        miProfugo = new Profugo("martin", 35, 25, true);
    }

    @Test
    void cuandoUnProfugoEntrenaArtesMarcialesAdvSuHabilidadSeDuplica(){
        miProfugo.artesMarcialesAvanzadas();
        assertEquals(miProfugo.getNivelDeHabilidad(), 50);
        assertTrue(miProfugo.getEntrenamientos().contains("artesMarcialesAvanzadas"));
    }

    @Test
    void cuandoUnProfugoEntrenaEntrenamientoEliteNuncaSeConsideraraNervioso(){
        miProfugo.entrenamientoDeElite();
        assertTrue(!miProfugo.estaNervioso());
        assertTrue(miProfugo.getEntrenamientos().contains("entrenamientoDeElite"));
    }

    @Test
    void cuandoUnProfugoEntrenaProteccionLegalSuInocenciaNuncaEstaraDebajoDe40(){
        miProfugo.proteccionLegal();
        assertEquals(miProfugo.getNivelDeInocencia(),40);
        assertTrue(miProfugo.getEntrenamientos().contains("proteccionLegal"));
    }
}
