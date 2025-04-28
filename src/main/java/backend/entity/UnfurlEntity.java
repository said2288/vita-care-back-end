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
public class UnfurlEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    // Usa fralda?
    @NotBlank(message = "Use diapers may not be empty or null")
    private String useDiapers;

    // Já realizou o processo de desfralde?
    @NotBlank(message = "Have you already gone through the potty training process may not be empty or null")
    private String haveYouAlreadyGoneThroughPottyTrainingProcess;

    @OneToOne
    @JoinColumn(name = "personalData_id")
    private PersonalDataEntity personalDataUnfurl;
}
