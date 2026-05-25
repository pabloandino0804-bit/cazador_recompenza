package ar.edu.unahur.obj2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.Cazadores.Cazador;
import ar.edu.unahur.obj2.Cazadores.CazadorRural;
import ar.edu.unahur.obj2.Cazadores.CazadorSigiloso;
import ar.edu.unahur.obj2.Cazadores.CazadorUrbano;
import ar.edu.unahur.obj2.Profugos.ArtesMarcialesAvanzadas;
import ar.edu.unahur.obj2.Profugos.EntrenamientoElite;
import ar.edu.unahur.obj2.Profugos.IProfugo;
import ar.edu.unahur.obj2.Profugos.Profugo;
import ar.edu.unahur.obj2.lugares.Agencia;
import ar.edu.unahur.obj2.lugares.Zona;

public class AgenciaTest {
    private Profugo romeo;
    private Profugo jeckyll;
    private IProfugo matias;
    private IProfugo pisso;
    private Profugo fernando;
    private Profugo martin;
    private Cazador cazadorPro = new CazadorSigiloso("pistolero con sombrero",65);
    private Cazador cazadorUrbano = new CazadorUrbano("mario Lopez",30);
    private Cazador cazadorRural = new CazadorRural("gato con pistolas", 47);
    private Zona baseProfugo;
    private Agencia agencia;
    private List<IProfugo> grupo;

    @BeforeEach
    void setUp() {
        romeo = new Profugo("romeo", 23, 57, false);
        jeckyll = new Profugo("jeckyll", 30, 40, true);
        matias = new EntrenamientoElite(new Profugo("matias", 41, 50, false));
        pisso = new ArtesMarcialesAvanzadas(new Profugo("pisso", 25, 25, false));
        fernando = new Profugo("fernando", 60, 50, true);
        martin = new Profugo("martin", 70, 40, true);
        grupo = new ArrayList<IProfugo>();
        grupo.add(romeo);
        grupo.add(jeckyll);
        grupo.add(pisso);
        grupo.add(fernando);
        grupo.add(matias);
        grupo.add(martin);
        baseProfugo = new Zona("base", grupo);

        agencia = Agencia.getInstance();
        Agencia.getInstance().registrarCazador(cazadorPro);
        Agencia.getInstance().registrarCazador(cazadorUrbano);
        Agencia.getInstance().registrarCazador(cazadorRural);

        agencia.enviarCazadorAZona(cazadorPro, baseProfugo);
        agencia.enviarCazadorAZona(cazadorRural, baseProfugo);
        agencia.enviarCazadorAZona(cazadorRural, baseProfugo);
        agencia.enviarCazadorAZona(cazadorUrbano, baseProfugo);
        agencia.enviarCazadorAZona(cazadorUrbano, baseProfugo);
    }

    @AfterEach
    void tearDown(){
        Agencia.getInstance().getCazadores().clear();
        cazadorPro.getProfugosCapturados().clear();
        cazadorUrbano.getProfugosCapturados().clear();
        cazadorRural.getProfugosCapturados().clear();
    }

    //Tests Parte 3
    //Tests de Zona
    @Test
    void cuandoLePreguntaElNombreDeZonaDevuelveSuNombre(){
        assertEquals(baseProfugo.getNombre(), "base");
    }

    @Test 
    void cuandoLePideQuitarUnMiembroPorCondicionEntoncesLoElimina(){
        baseProfugo.sacarProfugo(fernando);
        assertTrue(!baseProfugo.getProfugosEnLaZona().contains(fernando));
    }

    //Tests de Agencia
    @Test
    void cuandoLePreguntaLosCazadoresDeAgenciaDevuelveUnConjuntoDeCazadores(){
        assertEquals(agencia.getCazadores().size(), 3);
    }

    @Test
    void laAgenciacontaraTodosLosLadronesCapturadosTotalEnCadaCazador() {
        assertEquals(agencia.getProfugosCapturados().size(), 6);
    }

    @Test
    void CuandoSePreguntaElProfugoMasHabilidosoDevuelveElUnicoHabilidoso() {
        assertEquals(agencia.profugoMasHabilCapturado().getNombreProfugo(), "romeo");
    }

    @Test
    void cuandoLaAgenciaPreguntaAlCazadorConMasCapturasDevuelveElMismo() {
        assertEquals(agencia.cazadorConMasCapturas().getNombre(), "gato con pistolas");
    }
}
