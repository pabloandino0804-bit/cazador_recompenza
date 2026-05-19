package ar.edu.unahur.obj2.Cazadores;

import java.util.HashSet;
import java.util.Set;
import ar.edu.unahur.obj2.Profugos.IProfugo;
import ar.edu.unahur.obj2.Profugos.Profugo;
import ar.edu.unahur.obj2.lugares.Zona;

public abstract class Cazador{
    protected String nombre;
    protected Integer experiencia;
    protected Set<Profugo> profugosCapturados = new HashSet<Profugo>();

    public Cazador(String nombre, Integer experiencia){
        this.nombre = nombre;
        this.experiencia = experiencia;
    }

    public String getNombre(){
        return nombre;
    }

    public Set<Profugo> getProfugosCapturados() {
        return profugosCapturados;
    }

    public Integer cantProfugosCapturados() {
        return profugosCapturados.size();
    }

    public void realizarProcesoDeCaza(Zona unaZona) {
        unaZona.getProfugosEnLaZona().stream().forEach(p -> this.capturarProfugo(p));
        profugosCapturados.forEach(p -> unaZona.sacarProfugoSiPuede(p));
        experiencia += unaZona.profugoConMenorHabilidad() + (2 * this.cantProfugosCapturados());
    }

    public void capturarProfugo(Profugo unProfugo) {
         if(puedeCazar(unProfugo)){
                cazar(unProfugo);
            }
            else{
                intimidarProfugo(unProfugo);
            }
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