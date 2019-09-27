package liftoffproject.futurevision.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min=3, max=55)
    private String firstname;

    @NotNull
    @Size(min=3, max=55)
    private String lastname;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastvisit;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate futurevisit;

    @ManyToOne
    @JoinColumn
    private User user;

    @OneToMany
    @JoinColumn(name = "bookvisits_id")
    private List <Bookvisits> bookvisits = new ArrayList<>();




    public Client(){ }


    public Client(String firstname, String lastname, LocalDate lastvisit) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.lastvisit = lastvisit;
    }

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
