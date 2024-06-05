package carmenromano;

import carmenromano.dao.EventDao;
import carmenromano.dao.LocationDAO;
import carmenromano.dao.PartecipazioniDAO;
import carmenromano.dao.PersonaDAO;
import carmenromano.entities.Event;
import carmenromano.entities.Location;
import carmenromano.entities.Partecipazioni;
import carmenromano.entities.Persona;
import carmenromano.enums.EventType;
import carmenromano.enums.GenderType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    //questo metodo ci consente di creare oggetti entity manager per poter interagire con il db
    private static final EntityManagerFactory entity_final = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {
        // Creazione dell'EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
        // Creazione dell'EntityManager
        EntityManager em = emf.createEntityManager();
        // Creazione dei DAO
        PersonaDAO personaDAO = new PersonaDAO(em);
        LocationDAO locationDAO = new LocationDAO(em);
        EventDao eventDAO = new EventDao(em);
        PartecipazioniDAO partecipazioniDAO = new PartecipazioniDAO(em);

        // Salvataggio di una Persona
     //   Persona persona = new Persona(GenderType.M, "Mario", "Rossi",
      //          "mario.rossi@example.com", LocalDate.of(1980, 1, 1), );
       // personaDAO.save(persona);

        // Salvataggio di una Location
        Location location = new Location("villa", "Milano");
      //  locationDAO.save(location);


        // Salvataggio di un Evento associato alla Location
        Location locationDB = locationDAO.findById("74946ad9-9531-4973-81c2-69ad3b0e1e51");
       Event evento = new Event("Evento 1", LocalDate.of(2023, 5, 1),
             "Descrizione dell'evento", EventType.PUBBLICO, 100, locationDB);

       Persona persona1 = new Persona(GenderType.F,);
       eventDAO.save(evento);


    }
}
