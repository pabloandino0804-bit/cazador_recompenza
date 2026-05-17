package ar.edu.unahur.obj2.Profugos;

public abstract class ProfugoDecorator implements IProfugo{
    protected final IProfugo profugo;

    public ProfugoDecorator(IProfugo unProfugo) {
        if (unProfugo == null) throw new NullPointerException();
        this.profugo = unProfugo;
    }
}
