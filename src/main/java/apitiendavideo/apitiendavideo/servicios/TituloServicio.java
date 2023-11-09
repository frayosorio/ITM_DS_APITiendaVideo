package apitiendavideo.apitiendavideo.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import apitiendavideo.apitiendavideo.entidades.Titulo;
import apitiendavideo.apitiendavideo.interfaces.ITituloServicio;
import apitiendavideo.apitiendavideo.repositorios.TituloRepositorio;

@Service
public class TituloServicio implements ITituloServicio{
    
    private TituloRepositorio repositorio;

    public TituloServicio(TituloRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Titulo> listar() {
        return repositorio.findAll();
    }

    @Override
    public Titulo obtener(long id) {
        var Titulo = repositorio.findById(id);
        return Titulo.isEmpty() ? null : Titulo.get();
    }

    @Override
    public List<Titulo> buscar(String nombre) {
        return repositorio.buscar(nombre);
    }

    @Override
    public Titulo guardar(Titulo Titulo) {
        return repositorio.save(Titulo);
    }

    @Override
    public boolean eliminar(Long id) {
        try {
            repositorio.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
