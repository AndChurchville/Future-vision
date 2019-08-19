package liftoffproject.futurevision.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Entity
public class Client {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=55)
    private String firstname;

    @NotNull
    @Size(min=3, max=55)
    private String lastname;

    @NotNull
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private LocalDate lastvisit;

    @NotNull
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private LocalDate futurevisit;

    public Client(String firstname, String lastname, LocalDate lastvisit, LocalDate futurevisit) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.lastvisit = lastvisit;
        this.futurevisit = futurevisit;
    }

    public Client(){ }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
}
