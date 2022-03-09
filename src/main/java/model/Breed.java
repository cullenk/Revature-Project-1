package model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Collection;

// POJO
@Entity
@Table(name="breeds")

@JsonIdentityInfo(
        //this is to stop recursive hibernate joins
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)

//Lombok annotations
@Getter
@Setter
@ToString
public class Breed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "breed_id", updatable = false, nullable = false)
    public int breed_id;
    //Can also use @Column to define column name, or @Transient to ignore this data value and not create a column
    public String breed;
    public String temperament;
    public String size;
    public String sheds;
    public String image_url;
    //Multiplicity to show that a certain breed could have many adoption records. Indicates popularity of the breed.
    @OneToMany
    @JoinColumn(name="breed_id")
    private Collection<AdoptionRecord> adoptionRecords = new ArrayList<>();



}