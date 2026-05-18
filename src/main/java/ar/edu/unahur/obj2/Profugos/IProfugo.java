package ar.edu.unahur.obj2.Profugos;

public interface IProfugo {
    Integer getNivelDeInocencia();

    Integer getNivelDeHabilidad();

    Boolean estaNervioso();

    void volverseNervioso();

    void dejarSerNervioso();

    void reducirHabilidad();

    void disminuirInocencia();

    void artesMarcialesAvanzadas();

    void entrenamientoDeElite();

    void proteccionLegal();
}
