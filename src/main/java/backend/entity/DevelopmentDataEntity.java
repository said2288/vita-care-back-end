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
public class DevelopmentDataEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    // Como é o sono?
    @NotBlank(message = "What is sleep like may not be empty or null")
    private String whatIsSleepLike;

    // Era um bebê agitado, chorava muito?
    @NotBlank(message = "He was a fussy baby, he cried a lot may not be empty or null")
    private String heWasFussyBaby_heCriedLot;

    // Controle cervical
    @NotBlank(message = "Cervical control may not be empty or null")
    private String cervicalControl;

    // Permanência de prono
    @NotBlank(message = "Prone stay may not be empty or null")
    private String proneStay;

    // Rolar
    @NotBlank(message = "Roll may not be empty or null")
    private String roll;

    // Sentar
    @NotBlank(message = "Sit may not be empty or null")
    private String sit;

    // Engatinhar
    @NotBlank(message = "Crawl may not be empty or null")
    private String crawl;

    // Caminhar sem apoio
    @NotBlank(message = "Walking without support may not be empty or null")
    private String walkingWithoutSupport;

    // Explora/explorava objetos com a boca?
    @NotBlank(message = "Explore/explore objects with your mouth may not be empty or null")
    private String exploreObjectsWithYourMouth;

    // Houve atraso no desenvolvimento da linguagem? Consegue se comunicar de maneira efetiva?
    @NotBlank(message = "There was a delay in language development, can communicate effectively may not be empty or null")
    private String thereWasDelayLanguageDevelopment_canCommunicateEffectively;

    @OneToOne
    @JoinColumn(name = "personalData_id")
    private PersonalDataEntity personalDataDevelopmentData;
}
