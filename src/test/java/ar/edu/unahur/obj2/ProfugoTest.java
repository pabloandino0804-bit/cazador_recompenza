package ar.edu.unahur.obj2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.Profugos.Profugo;

public class ProfugoTest {
    private Profugo miProfugo;

    @BeforeEach 
    void setup(){
        miProfugo = new Profugo("Juan", 35, 25, true);
    }

    @Test
    void cuandoSePreguntaElNivelInocenciaDevuelveSuInocencia(){
        assertEquals(miProfugo.getNivelDeInocencia(), 35);
    }

    @Test
    void cuandoSePreguntaElNivelHabilidadDevuelveSuHabilidad(){
        assertEquals(miProfugo.getNivelDeHabilidad(), 25);
    }

    @Test
    void SiElNivInocenciaACambiarEsNuloOSobrepasaDel100LanzaraUnaException(){
        assertThrows(NullPointerException.class, () -> miProfugo.setNivelDeInocencia(null));
    }

    @Test
    void SIElNivelDeInocenciaNoEsDeEntre0y100LanzaraUnaExcepcionDeNivelInvalido(){
        assertThrows(NivInvalidoException.class, () -> miProfugo.setNivelDeInocencia(-10));
    }

    @Test
    void SiElNivHabilidadACambiarEsNuloOSobrepasaDel100LanzaraUnaException(){
        assertThrows(NullPointerException.class, () -> miProfugo.setNivelDeHabilidad(null));
    }

    @Test
    void SiElNivelDeHabilidadACambiarSePasaDe100EntoncesLanzaraUnaNivelInvalido(){
        assertThrows(NivInvalidoException.class, () -> miProfugo.setNivelDeHabilidad(1000));
    }

    @Test
    void cuandoUnProfugoEntrenaArtesMarcialesAdvSuHabilidadSeDuplica(){
        miProfugo.artesMarcialesAvanzadas();
        assertEquals(miProfugo.getNivelDeHabilidad(), 50);
        assertTrue(miProfugo.getEntrenamientos().contains("artesMarcialesAvanzadas"));
    }

    @Test
    void cuandoUnProfugoEntrenaEntrenamientoEliteNuncaSeConsideraraNervioso(){
        assertTrue(miProfugo.estaNervioso());
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
