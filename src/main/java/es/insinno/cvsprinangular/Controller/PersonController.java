package es.insinno.cvsprinangular.Controller;

    import es.insinno.cvsprinangular.Entity.Person;
    import es.insinno.cvsprinangular.Repository.PersonRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.Optional;

    @RestController
    @RequestMapping("/api/person")
    public class PersonController {

        @Autowired
        private final PersonRepository personRepository;

        public PersonController(PersonRepository personRepository) {
            this.personRepository = personRepository;
        }

        @GetMapping("/view/{id}")
        public ResponseEntity<Person> viewPersonById(@PathVariable Long id) {
            Optional<Person> person = personRepository.findById(id);
            if (person.isPresent()) {
                return new ResponseEntity<>(person.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        @PostMapping("/add")
        public ResponseEntity<Person> addPerson(@RequestBody Person person) {
            try {
                if (person.getName() == null || person.getSurname() == null) {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
                Person savedPerson = personRepository.save(person);
                return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }