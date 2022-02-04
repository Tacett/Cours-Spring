package monprojet.entity;
import javax.persistence.*;

import org.hibernate.annotations.Proxy;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

// Un exemple d'entité
// On utilise Lombok pour auto-générer getter / setter / toString...
// cf. https://examples.javacodegeeks.com/spring-boot-with-lombok/
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Proxy(lazy = false)
@Entity // Une entité JPA
public class Country {



    // Lombok https://www.projectlombok.org/features/ToString
    @ToString.Exclude // On ne veut pas inclure la liste des villes dans le toString
    // Sinon récursivité infinie
    @OneToMany(mappedBy="country", cascade = CascadeType.REMOVE)
    private List<City> cities = new ArrayList<>();


    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @Column(unique=true)
    @NonNull
    private String code;
    
    @Column(unique=true)
    @NonNull
    private String name;
}
