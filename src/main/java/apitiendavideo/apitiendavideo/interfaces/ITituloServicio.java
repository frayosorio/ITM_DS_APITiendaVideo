package apitiendavideo.apitiendavideo.interfaces;

import java.util.List;

import apitiendavideo.apitiendavideo.entidades.Titulo;

public interface ITituloServicio {

     public List<Titulo> listar();

    public Titulo obtener(long id);

    public List<Titulo> buscar(String nombre);

    public Titulo guardar(Titulo Titulo);

    public boolean eliminar(Long id);

}
