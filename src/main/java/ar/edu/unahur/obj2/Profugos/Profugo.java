package ar.edu.unahur.obj2.Profugos;

public class Profugo implements IProfugo{
    protected Integer nivelInocencia;
    protected Integer nivelHabilidad;
    protected Boolean estaNervioso;

    public Profugo(Integer nivelInocencia, Integer nivelHabilidad, Boolean estaNervioso) {
        setNivelDeInocencia(nivelInocencia);
        this.nivelHabilidad = nivelHabilidad;
        this.estaNervioso = estaNervioso;
    }

    @Override
    public Integer getNivelDeInocencia() {
        return nivelInocencia;
    }

    @Override
    public Integer getNivelDeHabilidad() {
        return nivelHabilidad;
    }

    @Override
    public Boolean estaNervioso() {
        return estaNervioso.equals(true);
    }

    @Override
    public void volverseNervioso() {
        this.estaNervioso = true;
    }

    @Override
    public void dejarSerNervioso() {
        this.estaNervioso = false;
    }

    @Override
    public void reducirHabilidad() {
        if(this.getNivelDeHabilidad() < 0) {
            throw new NullPointerException("El nivel de habilidad no debe disminuirse mucho");
        }
        this.nivelHabilidad -= 5;
    }

    @Override
    public void disminuirInocencia() {
        this.nivelInocencia -= 2;
    }

    public void setNivelDeInocencia(Integer nivInocencia) {
        if(nivInocencia == null){
            throw new NullPointerException("El nivel de inocencia no debe ser nulo");
        }
        if(!validarInocencia(nivInocencia)){
            throw new IllegalArgumentException("El nivel de inocencia " + nivInocencia + " no es valido."
            );
        }
        this.nivelInocencia = nivInocencia;
    }

    private Boolean validarInocencia(Integer nivInocencia) {
        return (nivInocencia >= 0 && nivInocencia <= 100);
    }
}
