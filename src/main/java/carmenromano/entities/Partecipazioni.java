package carmenromano.entities;

import carmenromano.enums.StateType;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "partecipazione") //nome tabella
public class Partecipazioni {

    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "stato")
    @Enumerated(EnumType.STRING)
    private StateType stateType;

        @ManyToOne
        @JoinColumn(name = "persona_id")
        private Persona persona;

        @ManyToOne
        @JoinColumn(name = "event_id")
        private Event event;

public Partecipazioni(){}

    public Partecipazioni(StateType stateType, String nome, Persona persona, Event event) {
        this.stateType = stateType;
        this.nome = nome;
        this.persona = persona;
        this.event = event;
    }

    public StateType getStateType() {
        return stateType;
    }

    public void setStateType(StateType stateType) {
        this.stateType = stateType;
    }

    public UUID getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Partecipazioni{" +
                "id=" + id +
                ", stateType=" + stateType +
                ", nome='" + nome + '\'' +
                ", persona=" + persona +
                '}';
    }
}
