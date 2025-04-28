package backend.dtos;

import lombok.Data;

@Data
public class DTOPersonalDataListResponse {

    private Long id_personalData;

    // Nome da criança
    private String childsName;

    // Data de nascimento
    private String dateBirth;

    // Nome dos pais
    private String parentsName;

    // Com quem mora?
    private String withWhomLive;

    // Apresenta alguma alergia?
    private String allergy;

    // Utiliza ou já utilizou alguma medicação?
    private String medication;

    // Equipe de profissionais que acompanham a criança
    private String professionalsWhoAccompany;

    // Escola
    private String school;

    // Religião
    private String religion;

    // Queixas da família
    private String familyComplaints;


    private Long id_pregnancyBirth;

    // Como foi a gestação?
    private String howWasThePregnancy;

    // Como foi o nascimento?
    private String howWasTheBirth;

    // Apgar
    private String apgar;

    // Como foi a amamentação, apresentou dificuldades de sucção?
    private String howWasBreastfeedingDidYouHaveAnySuckingDifficulties;


    private Long id_developmentData;

    // Como é o sono?
    private String whatIsSleepLike;

    // Era um bebê agitado, chorava muito?
    private String heWasFussyBaby_heCriedLot;

    // Controle cervical
    private String cervicalControl;

    // Permanência de prono
    private String proneStay;

    // Rolar
    private String roll;

    // Sentar
    private String sit;

    // Engatinhar
    private String crawl;

    // Caminhar sem apoio
    private String walkingWithoutSupport;

    // Explora/explorava objetos com a boca?
    private String exploreObjectsWithYourMouth;

    // Houve atraso no desenvolvimento da linguagem? Consegue se comunicar de maneira efetiva?
    private String thereWasDelayLanguageDevelopment_canCommunicateEffectively;


    private Long id_food;

    // Como foi a introdução alimentar? Como a família ofertava os alimentos - inteiros, batidos, amassados? Com qual idade?
    private String howWasFoodIntroduction;

    // Engasgava com os alimentos ou líquidos?
    private String chokingOnFoodOrLiquids;


    private Long id_unfurl;

    // Usa fralda?
    private String useDiapers;

    // Já realizou o processo de desfralde?
    private String haveYouAlreadyGoneThroughPottyTrainingProcess;


    private Long id_dailyLivingActivities;

    // Alimentar-se
    private String feeding;

    // Vestir-se/despir-se
    private String dressing_undressing;

    // Escovar os dentes
    private String brushYourTeeth;

    // Tomar banho
    private String haveBath;

    // Asseio pessoal: Resistência ou irritabilidade excessivas para pentear e cortar cabelos, cortar unhas, lavar ou limpar o rosto, lavar as mãos
    private String personalCleanliness;

}
