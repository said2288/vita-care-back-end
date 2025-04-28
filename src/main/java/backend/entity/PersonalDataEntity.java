package backend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

/**
 *
 * @author mohamad
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class PersonalDataEntity {
    
   @Id 
   @GeneratedValue(strategy=GenerationType.AUTO)
   private Long id;

   // Nome da criança
   @NotBlank(message = "Child's may not be empty or null")
   private String childsName;

   // Data de nascimento
   @NotBlank(message = "Date of birth may not be empty or null")
   private String dateBirth;

   // Nome dos pais
   @NotBlank(message = "Parent's may not be empty or null")
   private String parentsName;

   // Com quem mora?
   @NotBlank(message = "With whom you live may not be empty or null")
   private String withWhomLive;

   // Apresenta alguma alergia?
   @NotBlank(message = "Allergy may not be empty or null")
   private String allergy;

   // Utiliza ou já utilizou alguma medicação?
   @NotBlank(message = "Do you use or have you ever used any medication may not be empty or null")
   private String medication;

   // Equipe de profissionais que acompanham a criança
   @NotBlank(message = "Team of professionals who accompany the child may not be empty or null")
   private String professionalsWhoAccompany;

   // Escola
   @NotBlank(message = "School may not be empty or null")
   private String school;

   // Religião
   @NotBlank(message = "Religion may not be empty or null")
   private String religion;

   // Queixas da família
   @NotBlank(message = "Family complaints may not be empty or null")
   private String familyComplaints;
   
   private boolean active = true;

   //@JsonIgnore
   @OneToOne(mappedBy = "personalDataPregnancyBirth")
   private PregnancyBirthEntity pregnancyBirth;

   //@JsonIgnore
   @OneToOne(mappedBy = "personalDataDevelopmentData")
   private DevelopmentDataEntity developmentData;

   //@JsonIgnore
   @OneToOne(mappedBy = "personalDataFood")
   private FoodEntity food;

   //@JsonIgnore
   @OneToOne(mappedBy = "personalDataUnfurl")
   private UnfurlEntity unfurl;

   //@JsonIgnore
   @OneToOne(mappedBy = "personalDataDailyLivingActivities")
   private DailyLivingActivitiesEntity dailyLivingActivities;
}


