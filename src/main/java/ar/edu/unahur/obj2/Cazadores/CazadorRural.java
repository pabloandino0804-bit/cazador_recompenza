package ar.edu.unahur.obj2.Cazadores;

import ar.edu.unahur.obj2.Profugos.IProfugo;

public class CazadorRural extends Cazador {

    public CazadorRural(Integer experiencia) {
        super(experiencia);
    }

    @Override
    protected Boolean doPuedeCazar(IProfugo unProfugo) {
        return unProfugo.estaNervioso();
    }

    @Override
    protected void doIntimidarProfugo(IProfugo unProfugo) {
        unProfugo.volverseNervioso();
    }

}
