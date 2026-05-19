package ar.edu.unahur.obj2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.Cazadores.Cazador;
import ar.edu.unahur.obj2.Cazadores.CazadorRural;
import ar.edu.unahur.obj2.Cazadores.CazadorSigiloso;
import ar.edu.unahur.obj2.Cazadores.CazadorUrbano;
import ar.edu.unahur.obj2.Profugos.Profugo;
import ar.edu.unahur.obj2.lugares.Agencia;
import ar.edu.unahur.obj2.lugares.Zona;

public class AgenciaTest {
    private Profugo romeo;
    private Profugo jeckyll;
    private Profugo matias;
    private Profugo pisso;
    private Profugo fernando;
    private Profugo martin;
    private Cazador cazadorPro = new CazadorSigiloso("pistolero con sombrero",65);
    private Cazador cazadorUrbano = new CazadorUrbano("mario Lopez",30);
    private Cazador cazadorRural = new CazadorRural("gato con pistolas", 47);
    private Zona baseProfugo;
    private Agencia agencia;
    private Set<Profugo> grupo;

    @BeforeEach
    void setUp() {
        romeo = new Profugo("romeo", 23, 57, false);
        jeckyll = new Profugo("jeckyll", 30, 40, true);
        matias = new Profugo("matias", 41, 51, false);
        matias.proteccionLegal();
        pisso = new Profugo("pisso", 50, 25, true);
        fernando = new Profugo("fernando", 60, 25, true);
        martin = new Profugo("martin", 70, 60, true);
        jeckyll.entrenamientoDeElite();
        grupo = new HashSet<>();
        grupo.add(romeo);
        grupo.add(jeckyll);
        grupo.add(pisso);
        grupo.add(fernando);
        grupo.add(matias);
        grupo.add(martin);
        baseProfugo = new Zona("base", grupo);

        Set<Cazador> cazadores = new HashSet<>();
        cazadores.add(cazadorPro);
        cazadores.add(cazadorUrbano);
        cazadores.add(cazadorRural);
        agencia = new Agencia("comisaria", cazadores);
    }

    //Tests de Zona
    @Test
    void cuandoLePreguntaElNombreALaZonaLaMismaDevuelveSuNombre(){
        assertEquals(baseProfugo.getNombre(), "base");
    }

    @Test 
    void cuandoLePideQuitarUnMiembroPorCondicionEntoncesLoElimina(){
        baseProfugo.sacarProfugoSiPuede(fernando, true);
        assertTrue(!baseProfugo.getProfugosEnLaZona().contains(fernando));
    }

    //Tests de Agencia
    @Test
    void cuandoLePreguntaElNombreDeAgenciaDevuelveSuNombre(){
        assertEquals(agencia.getNombre(), "comisaria");
    }

    @Test
    void cuandoLePreguntaLosCazadoresDeAgenciaDevuelveUnConjuntoDeCazadores(){
        assertEquals(agencia.getCazadores().size(), 3);
    }

    @Test
    void laAgenciacontaraTodosLosLadronesCapturadosTotalEnCadaCazador() {
        agencia.enviarCazadorAZona(cazadorUrbano, baseProfugo);
        agencia.enviarCazadorAZona(cazadorPro, baseProfugo);
        agencia.enviarCazadorAZona(cazadorRural, baseProfugo);
        agencia.enviarCazadorAZona(cazadorRural, baseProfugo);
        assertEquals(agencia.getProfugosCapturados().size(), 6);
    }

    @Test
    void CuandoSePreguntaElProfugoMasHabilidosoDevuelveElUnicoHabilidoso() {
        agencia.enviarCazadorAZona(cazadorUrbano, baseProfugo);
        agencia.enviarCazadorAZona(cazadorPro, baseProfugo);
        agencia.enviarCazadorAZona(cazadorRural, baseProfugo);
        agencia.enviarCazadorAZona(cazadorRural, baseProfugo);
        assertEquals(agencia.profugoMasHabilCapturado().getNombreProfugo(), "romeo");
    }

    @Test
    void cuandoLaAgenciaPreguntaAlCazadorConMasCapturasDevuelveElMismo() {
        agencia.enviarCazadorAZona(cazadorUrbano, baseProfugo);
        agencia.enviarCazadorAZona(cazadorPro, baseProfugo);
        agencia.enviarCazadorAZona(cazadorRural, baseProfugo);
        agencia.enviarCazadorAZona(cazadorRural, baseProfugo);
        assertEquals(agencia.cazadorConMasCapturas().getNombre(), "pistolero con sombrero");
    }

}
