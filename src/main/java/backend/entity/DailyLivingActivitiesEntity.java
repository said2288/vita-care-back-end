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
public class DailyLivingActivitiesEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    // Alimentar-se
    @NotBlank(message = "Feeding may not be empty or null")
    private String feeding;

    // Vestir-se/despir-se
    @NotBlank(message = "Dressing/undressing may not be empty or null")
    private String dressing_undressing;

    // Escovar os dentes
    @NotBlank(message = "Brush your teeth may not be empty or null")
    private String brushYourTeeth;

    // Tomar banho
    @NotBlank(message = "Have a bath may not be empty or null")
    private String haveBath;

    // Asseio pessoal: Resistência ou irritabilidade excessivas para pentear e cortar cabelos, cortar unhas, lavar ou limpar o rosto, lavar as mãos
    @NotBlank(message = "Personal cleanliness: Excessive resistance or irritability when combing and cutting hair, cutting nails, washing or cleaning the face, washing hands may not be empty or null")
    private String personalCleanliness;

    @OneToOne
    @JoinColumn(name = "personalData_id")
    private PersonalDataEntity personalDataDailyLivingActivities;
}
