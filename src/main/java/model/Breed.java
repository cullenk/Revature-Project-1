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
@Table(name="all_breeds")
@JsonIdentityInfo(
        //this is to stop recursive hibernate joins
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
//Lombok annotations
@Getter
@Setter
public class Breed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "breed_id", updatable = false, nullable = false)
    public int breed_id;
    public String breed;
    public String temperament;
    public String size;
    public String sheds;
    public String image_url;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "breedObject", fetch = FetchType.EAGER)
    private Collection<AdoptionRecord> adoptionRecords = new ArrayList<>();


}