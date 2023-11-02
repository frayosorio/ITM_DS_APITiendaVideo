package apitiendavideo.apitiendavideo.interfaces;

import java.util.List;

import apitiendavideo.apitiendavideo.entidades.Empresa;
import apitiendavideo.apitiendavideo.entidades.Titulo;

public interface IEmpresaServicio {
    
    public List<Empresa> listar();

    public Empresa obtener(long id);

    public List<Empresa> buscar(String nombre);

    public Empresa guardar(Empresa empresa);

    public boolean eliminar(Long id);

    public List<Titulo> listarTitulos(String nombre);

}
