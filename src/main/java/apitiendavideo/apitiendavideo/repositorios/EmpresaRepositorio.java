package apitiendavideo.apitiendavideo.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import apitiendavideo.apitiendavideo.entidades.Empresa;

public interface EmpresaRepositorio extends JpaRepository<Empresa, Long>{
    
    @Query("SELECT e FROM Empresa e WHERE e.nombre LIKE '%' || ?1 || '%'")
    public List<Empresa> buscar(String nombre);
    
}
