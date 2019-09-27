package liftoffproject.futurevision.models;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Bookvisits {
    @Id
    @GeneratedValue
    private int id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastvisit;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate futurevisit;

    @ManyToOne
    private Client client;

    public Bookvisits(){ }

    public Bookvisits(LocalDate lastvisit){
        this.lastvisit = lastvisit;}


    public int getId() {
        return id;
    }

    public LocalDate getLastvisit() {
        return lastvisit;
    }

    public void setLastvisit(LocalDate lastvisit) {
        this.lastvisit = lastvisit;
    }

    public LocalDate getFuturevisit() {
        return futurevisit;
    }

    public void setFuturevisit(LocalDate futurevisit) {
        this.futurevisit = futurevisit;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
