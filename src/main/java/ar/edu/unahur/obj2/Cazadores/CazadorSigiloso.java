package ar.edu.unahur.obj2.Cazadores;

import ar.edu.unahur.obj2.Profugos.IProfugo;

public class CazadorSigiloso extends Cazador {

    public CazadorSigiloso(Integer experiencia) {
        super(experiencia);
    }

    @Override
    protected Boolean doPuedeCazar(IProfugo unProfugo) {
        return unProfugo.getNivelDeHabilidad() < 50;
    }

    @Override
    protected void doIntimidarProfugo(IProfugo unProfugo) {
        unProfugo.reducirHabilidad();
    }


}
