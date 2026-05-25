package ar.edu.unahur.obj2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.Profugos.ArtesMarcialesAvanzadas;
import ar.edu.unahur.obj2.Profugos.EntrenamientoElite;
import ar.edu.unahur.obj2.Profugos.IProfugo;
import ar.edu.unahur.obj2.Profugos.Profugo;
import ar.edu.unahur.obj2.Profugos.ProteccionLegal;

public class ProfugoTest {
    private Profugo miProfugo;

    @BeforeEach 
    void setup(){
        miProfugo = new Profugo("Juan", 35, 25, true);
    }

    @AfterEach
    void tearDown(){
        miProfugo = null;
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
    void dadoUnProfugo_cuandoSePreguntaSiEstaNerviosoLeDevuelveElBoolean(){
        assertTrue(miProfugo.estaNervioso());
    }

    @Test
    void SiElNivInocenciaACambiarEsNuloOSobrepasaDel100LanzaraUnaException(){
        assertThrows(NullPointerException.class, () -> miProfugo.setNivelDeInocencia(null));
    }

    @Test
    void SIElNivelDeInocenciaNoEsDeEntre0y100LanzaraUnaExcepcionDeNivelInvalido(){
        assertThrows(NivInvalidoException.class, () -> miProfugo.setNivelDeInocencia(-10));
        assertThrows(NivInvalidoException.class, () -> miProfugo.setNivelDeInocencia(140));
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
    void siElProfugoDecoratorCreadoTieneUnProfugoNulo_LanzaraUnaExcepcionDeValorNulo(){
        assertThrows(NullPointerException.class, () -> new ArtesMarcialesAvanzadas(null));
    }

    @Test
    void cuandoUnProfugoEntrenaArtesMarcialesAdvSuHabilidadSeDuplica(){

        IProfugo profugoKarateca = new ArtesMarcialesAvanzadas(miProfugo); 
        assertEquals(profugoKarateca.getNivelDeHabilidad(), 50);
    }

    //Tests parte 2
    @Test
    void cuandoUnProfugoEntrenaEntrenamientoEliteNuncaSeConsideraraNervioso(){
        assertTrue(miProfugo.estaNervioso());
        IProfugo profugoElite = new EntrenamientoElite(miProfugo);
        assertEquals(profugoElite.getNombreProfugo(), "Juan");
        profugoElite.volverseNervioso();
        assertTrue(!profugoElite.estaNervioso());
    }

    @Test
    void cuandoUnProfugoEntrenaProteccionLegalSuInocenciaNuncaEstaraDebajoDe40(){
        IProfugo profugoProtegido = new ProteccionLegal(miProfugo);
        assertEquals(profugoProtegido.getNivelDeInocencia(),40);
    }

    @Test
    void unProfugo_PuedeAdquirirOtroEntrenamiento_SinPerderLosEntrenamientosPrevios(){
        IProfugo profugoProtegido = new ProteccionLegal(miProfugo);
        assertEquals(profugoProtegido.getNivelDeInocencia(),40);
        IProfugo profugoElite = new EntrenamientoElite(profugoProtegido);
        assertTrue(!profugoElite.estaNervioso());
        assertEquals(profugoElite.getNivelDeInocencia(),40);
    }
}
