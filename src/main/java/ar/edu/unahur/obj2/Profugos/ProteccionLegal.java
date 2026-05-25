package ar.edu.unahur.obj2.Profugos;

public class ProteccionLegal extends ProfugoDecorator{

    public ProteccionLegal(IProfugo unProfugo) {
        super(unProfugo);
    }

    @Override
    public Integer getNivelDeInocencia() {
        return Integer.max(profugo.getNivelDeInocencia(),40);
    }

}
