package ar.edu.unahur.obj2.Profugos;

public class ProfugoDecorator implements IProfugo{
    protected final IProfugo profugo;

    public ProfugoDecorator(IProfugo unProfugo) {
        if (unProfugo == null) throw new NullPointerException();
        this.profugo = unProfugo;
    }

    @Override
    public String getNombreProfugo() {
        return profugo.getNombreProfugo();
    }

    @Override
    public Integer getNivelDeInocencia() {
        return profugo.getNivelDeInocencia();
    }

    @Override
    public Integer getNivelDeHabilidad() {
        return profugo.getNivelDeHabilidad();
    }

    @Override
    public Boolean estaNervioso() {
        return profugo.estaNervioso();
    }

    @Override
    public void volverseNervioso() {
        profugo.volverseNervioso();
    }

    @Override
    public void dejarSerNervioso() {
        profugo.dejarSerNervioso();
    }

    @Override
    public void reducirHabilidad() {
        profugo.reducirHabilidad();
    }

    @Override
    public void disminuirInocencia() {
        profugo.reducirHabilidad();
    }
}
