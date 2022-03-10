package model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Collection;

// POJO
@Entity
@Table(name="adoption_history")

@JsonIdentityInfo(
        //this is to stop recursive hibernate joins
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)

//Lombok annotations
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AdoptionRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adoption_id", updatable = false, nullable = false)
    public int adoption_id;
    public String firstName;
    public String lastName;
    public String breed;
    public String gender;
    public String puppy_name;
    @ManyToOne(fetch=FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name="breed_id")
    private Breed breedObject;

    public AdoptionRecord(String firstName, String lastName, String breed, String gender, String puppy_name) {
    }
}

