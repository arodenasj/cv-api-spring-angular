package es.insinno.cvsprinangular.Controller;


import es.insinno.cvsprinangular.Entity.Person;
import es.insinno.cvsprinangular.Repository.PersonRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

  @GetMapping("/view")
    public Person viewPersonbyId() {
        return personRepository.findById(1L).orElse(null);
    }

    @PostMapping("/add")
    public Person addPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

}
