package apitiendavideo.apitiendavideo.contraladores;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apitiendavideo.apitiendavideo.entidades.Titulo;
import apitiendavideo.apitiendavideo.interfaces.ITituloServicio;

@RestController
@RequestMapping("/titulos")
public class TituloControlador {
    
    private ITituloServicio servicio;

    public TituloControlador(ITituloServicio servicio) {
        this.servicio = servicio;
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Titulo> listar() {
        return servicio.listar();
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public Titulo obtener(@PathVariable long id) {
        return servicio.obtener(id);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @RequestMapping(value = "/buscar/{nombre}", method = RequestMethod.GET)
    public List<Titulo> bsucar(@PathVariable String nombre) {
        return servicio.buscar(nombre);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public Titulo agregar(@RequestBody Titulo titulo) {
        titulo.setId(0);
        return servicio.guardar(titulo);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @RequestMapping(value = "/modificar", method = RequestMethod.PUT)
    public Titulo modificar(@RequestBody Titulo titulo) {
        if (servicio.obtener(titulo.getId()) != null) {
            return servicio.guardar(titulo);
        } else {
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public Boolean eliminar(@PathVariable long id) {
        return servicio.eliminar(id);
    }


}
