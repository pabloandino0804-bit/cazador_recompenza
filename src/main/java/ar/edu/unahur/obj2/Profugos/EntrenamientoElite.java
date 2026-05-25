package ar.edu.unahur.obj2.Profugos;

public class EntrenamientoElite extends ProfugoDecorator {
    
    public EntrenamientoElite(IProfugo unProfugo) {
        super(unProfugo);
    }

    @Override
    public Boolean estaNervioso() {
        return false;
    }

    @Override
    public void volverseNervioso() {
        profugo.dejarSerNervioso();
    }
}
