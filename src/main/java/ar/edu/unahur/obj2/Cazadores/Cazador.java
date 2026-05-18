package ar.edu.unahur.obj2.Cazadores;

import java.util.HashSet;
import java.util.Set;
import ar.edu.unahur.obj2.Profugos.IProfugo;
import ar.edu.unahur.obj2.Profugos.Profugo;
import ar.edu.unahur.obj2.lugares.Zona;

public abstract class Cazador{
    protected Integer experiencia;
    protected Set<Profugo> profugosCapturados = new HashSet<Profugo>();

    public Cazador(Integer experiencia){
        this.experiencia = experiencia;
    }

    public void realizarProcesoDeCaza(Zona unaZona) {
        unaZona.getProfugosEnLaZona().stream().forEach(p -> this.capturarProfugo(p));
        profugosCapturados.forEach(p -> unaZona.sacarProfugoSiPuede(p, profugosCapturados.contains(p)));
        experiencia += unaZona.profugoConMenorHabilidad() + (2 * this.getProfugos().size());
    }

    public void capturarProfugo(Profugo unProfugo) {
         if(puedeCazar(unProfugo)){
                cazar(unProfugo);
            }
            else{
                intimidarProfugo(unProfugo);
            }
    }

    public Set<Profugo> getProfugos() {
        return profugosCapturados;
    }

    public void cazar(Profugo unProfugo) {
            profugosCapturados.add(unProfugo);
    }
    protected Boolean puedeCazar(IProfugo unProfugo) {
        return this.experiencia > unProfugo.getNivelDeInocencia() && doPuedeCazar(unProfugo);
    }

    protected abstract Boolean doPuedeCazar(IProfugo unProfugo);

    protected void intimidarProfugo(IProfugo unProfugo) {
        unProfugo.disminuirInocencia();
        doIntimidarProfugo(unProfugo);
    }
    
    protected abstract void doIntimidarProfugo(IProfugo unProfugo);
}