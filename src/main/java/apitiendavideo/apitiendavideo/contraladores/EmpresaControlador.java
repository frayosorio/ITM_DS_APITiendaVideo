package apitiendavideo.apitiendavideo.contraladores;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apitiendavideo.apitiendavideo.entidades.Empresa;
import apitiendavideo.apitiendavideo.entidades.Titulo;
import apitiendavideo.apitiendavideo.interfaces.IEmpresaServicio;

@RestController
@RequestMapping("/empresas")
public class EmpresaControlador {

    private IEmpresaServicio servicio;

    public EmpresaControlador(IEmpresaServicio servicio) {
        this.servicio = servicio;
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Empresa> listar() {
        return servicio.listar();
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public Empresa obtener(@PathVariable long id) {
        return servicio.obtener(id);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @RequestMapping(value = "/buscar/{nombre}", method = RequestMethod.GET)
    public List<Empresa> bsucar(@PathVariable String nombre) {
        return servicio.buscar(nombre);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public Empresa agregar(@RequestBody Empresa empresa) {
        empresa.setId(0);
        return servicio.guardar(empresa);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @RequestMapping(value = "/modificar", method = RequestMethod.PUT)
    public Empresa modificar(@RequestBody Empresa empresa) {
        if (servicio.obtener(empresa.getId()) != null) {
            return servicio.guardar(empresa);
        } else {
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public Boolean eliminar(@PathVariable long id) {
        return servicio.eliminar(id);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @RequestMapping(value = "/titulos/{nombre}", method = RequestMethod.GET)
    public List<Titulo> listarTitulos(@PathVariable String nombre) {
        return servicio.listarTitulos(nombre);
    }

}
