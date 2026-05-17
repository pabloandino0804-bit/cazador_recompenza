package ar.edu.unahur.obj2.Cazadores;

import java.util.HashSet;
import java.util.Set;

import ar.edu.unahur.obj2.Profugos.IProfugo;
import ar.edu.unahur.obj2.Profugos.Profugo;
import ar.edu.unahur.obj2.lugares.Zona;

public abstract class Cazador {
    protected Integer experiencia = 0;
    protected Set<Profugo> profugos = new HashSet<Profugo>();

    public void realizarProcesoDeCaza(Zona unaZona){
        unaZona.getProfugosEnLaZona().stream().forEach(unProfugo -> this.capturarProfugo(unProfugo));
    }

    public Set<Profugo> getProfugos(){
        return profugos;
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
            profugos.add(unProfugo);
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