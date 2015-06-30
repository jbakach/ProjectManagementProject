package demo.controller;

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
        Iterator<Developer> iterator=developerRepository.findAll().iterator();
        while(iterator.hasNext()){
            developers.add(iterator.next());
        }
        return developers;
    }
    

}
