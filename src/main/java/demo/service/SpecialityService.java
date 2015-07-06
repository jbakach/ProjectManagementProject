package demo.service;

import demo.model.Speciality;
import demo.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by poo2 on 29/06/2015.
 */
@Service
public class SpecialityService {
    @Autowired
    private SpecialityRepository specialityRepository;
    public void initializeSpecialties() {
        Speciality android = new Speciality();
        android.setName("Android");

        Speciality spring = new Speciality();
        spring.setName("Spring");

        Speciality hibernate = new Speciality();
        hibernate.setName("Hibernate");

        specialityRepository.save(android);
        specialityRepository.save(spring);
        specialityRepository.save(hibernate);
    }
}
