package backend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.*;

/**
 *
 * @author mohamad
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class FoodEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    // Como foi a introdução alimentar? Como a família ofertava os alimentos - inteiros, batidos, amassados? Com qual idade?
    @NotBlank(message = "How was the food introduction? How did the family offer food – whole, mixed, mashed? what age? may not be empty or null")
    private String howWasFoodIntroduction;

    // Engasgava com os alimentos ou líquidos?
    @NotBlank(message = "Choking on food or liquids may not be empty or null")
    private String chokingOnFoodOrLiquids;

    @OneToOne
    @JoinColumn(name = "personalData_id")
    private PersonalDataEntity personalDataFood;

}
