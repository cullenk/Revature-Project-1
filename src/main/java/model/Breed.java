package model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.persistence.Id;

// POJO
@Entity
@Table(name="breeds")

@JsonIdentityInfo(
        //this is to stop recursive hibernate joins
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
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


    //Getters and Setters

    public int getId() {
        return breed_id;
    }

    public void setId(int id) {
        this.breed_id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSheds() {
        return sheds;
    }

    public void setSheds(String sheds) {
        this.sheds = sheds;
    }

    @Override
    public String toString() {
        return "Breed{" +
                "id=" + breed_id +
                ", breed='" + breed + '\'' +
                ", temperament='" + temperament + '\'' +
                ", size='" + size + '\'' +
                ", sheds='" + sheds + '\'' +
                '}';
    }
}
