package model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.persistence.Id;

// POJO
@Entity
@Table(name="adoption_history")

@JsonIdentityInfo(
        //this is to stop recursive hibernate joins
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)

//Lombok annotations
@Getter
@Setter
@ToString
public class AdoptionRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adoption_id", updatable = false, nullable = false)
    public int adoption_id;
    //Can also use @Column to define column name, or @Transient to ignore this data value and not create a column
    public String firstName;
    public String lastName;
    public String breed;
    public String gender;
    public String puppy_name;


}