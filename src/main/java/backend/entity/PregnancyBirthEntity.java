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
public class PregnancyBirthEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    // Como foi a gestação?
    @NotBlank(message = "How was the pregnancy may not be empty or null")
    private String howWasThePregnancy;

    // Como foi o nascimento?
    @NotBlank(message = "How was the birth may not be empty or null")
    private String howWasTheBirth;

    // Apgar
    @NotBlank(message = "Apgar may not be empty or null")
    private String apgar;

    // Como foi a amamentação, apresentou dificuldades de sucção?
    @NotBlank(message = "How was breastfeeding, did you have any sucking difficulties may not be empty or null")
    private String howWasBreastfeedingDidYouHaveAnySuckingDifficulties;

    @OneToOne
    @JoinColumn(name = "personalData_id")
    private PersonalDataEntity personalDataPregnancyBirth;
}