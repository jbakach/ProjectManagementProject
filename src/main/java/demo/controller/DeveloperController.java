package demo.controller;

import demo.exception.DeveloperException;
import demo.model.Developer;
import demo.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by poo2 on 29/06/2015.
 */
@RestController //Dices a Spring que esta clase es un controlador.
@RequestMapping ("/developers")//esta es la ruta de acceso http mediante el cual haces las acciones pertinentes
public class DeveloperController {

    @Autowired
    private DeveloperRepository developerRepository;

    @RequestMapping (method=RequestMethod.POST)//El metodo para la creacion de contenido
    @ResponseStatus(HttpStatus.CREATED)//Determinas el codigo que devuelve al hacer una operacion
    public Developer save (@RequestBody Developer developer) {
        return developerRepository.save(developer);
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Developer> findAll(){
        List <Developer> developers=new ArrayList<Developer>();
        Iterator<Developer> iterator=developerRepository.findAll().iterator();//Se utiliza un Iterator ya que al tener tantos developers
        //es aconsejable hacerlo en este metodo, ya que facilitat la paginacion y es un metodo muy efectivo, en cambio si lo guardas en una lista
        //al tener tanto volumen de datos al hacer el get, podria haber riesgo de quedarse sin memoria, y no es aconsejable, este metodo
        //es el mas viable y eficaz en cuanto a rendimiento y agilidad al hacer operaciones
        while(iterator.hasNext()){
            developers.add(iterator.next());
        }
        return developers;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Developer getById(@PathVariable Long id)//@PathVariable se utiliza para decir a Spring que coja el parametro que se pasa por la URL
            //y la guarde en una variable que es Long, el nombre de la variable ha de ser el mismo que el del RequestMapping.
    {
        Developer developer = developerRepository.findOne(id);
        if (developer == null)
            throw new DeveloperException(id);
        return developer;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteById (@PathVariable Long id){
        Developer developer = developerRepository.findOne(id);
        if (developer == null)
            throw new DeveloperException(id);
        developerRepository.delete(developer);
        return "Developer con ID "+id+" borrado con éxito de la base de datos";
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Developer updateById (@PathVariable Long id,@RequestBody Developer developer1){
        if (developerRepository.findOne(id) == null)
            throw new DeveloperException(id);
        developer1= developerRepository.save(developer1);
        return developer1;
    }

}
