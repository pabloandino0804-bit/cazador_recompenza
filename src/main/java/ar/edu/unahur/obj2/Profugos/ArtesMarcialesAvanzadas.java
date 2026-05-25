package ar.edu.unahur.obj2.Profugos;

public class ArtesMarcialesAvanzadas extends ProfugoDecorator {

    public ArtesMarcialesAvanzadas(IProfugo unProfugo) {
        super(unProfugo);
    }

    @Override
    public Integer getNivelDeHabilidad() {
        return Math.min(profugo.getNivelDeHabilidad()*2,100);
    }
}
