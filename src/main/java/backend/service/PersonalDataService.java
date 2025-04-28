package backend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import backend.Enum.EnumPersonalData;
import backend.dtos.DTOPersonalDataListResponse;
import backend.entity.*;
import backend.repository.*;

/**
 *
 * @author mohamad
 */

@Service
@Transactional
public class PersonalDataService {
    
   private final PersonalDataRepository personalDataRepository;
   private final PregnancyBirthRepository pregnancyBirthRepository;
   private final DevelopmentDataRepository developmentDataRepository;
   private final FoodRepository foodRepository;
   private final UnfurlRepository unfurlRepository;
   private final DailyLivingActivitiesRepository dailyLivingActivitiesRepository;

    PersonalDataService(PersonalDataRepository personalDataRepository,
                        PregnancyBirthRepository pregnancyBirthRepository,
                        DevelopmentDataRepository developmentDataRepository,
                        UnfurlRepository unfurlRepository,
                        DailyLivingActivitiesRepository dailyLivingActivitiesRepository,
                        FoodRepository foodRepository) {
       this.personalDataRepository = personalDataRepository;
       this.pregnancyBirthRepository = pregnancyBirthRepository;
       this.developmentDataRepository = developmentDataRepository;
       this.foodRepository = foodRepository;
       this.unfurlRepository = unfurlRepository;
       this.dailyLivingActivitiesRepository = dailyLivingActivitiesRepository;
    }

    public EnumPersonalData creationFromPatient(PersonalDataEntity personalData) {

        if(personalDataRepository.existsByName(personalData.getChildsName())) {
            return EnumPersonalData.PATIENT_NOT_CREATED;
        }

        PersonalDataEntity personal = new PersonalDataEntity();
        personal.setChildsName(personalData.getChildsName());
        personal.setDateBirth(personalData.getDateBirth());
        personal.setParentsName(personalData.getParentsName());
        personal.setWithWhomLive(personalData.getWithWhomLive());
        personal.setAllergy(personalData.getAllergy());
        personal.setMedication(personalData.getMedication());
        personal.setProfessionalsWhoAccompany(personalData.getProfessionalsWhoAccompany());
        personal.setSchool(personalData.getSchool());
        personal.setReligion(personalData.getReligion());
        personal.setFamilyComplaints(personalData.getFamilyComplaints());
        personal.setActive(personalData.isActive());
        personal.setPregnancyBirth(personalData.getPregnancyBirth());

        personalDataRepository.save(personal);

        PregnancyBirthEntity pregnancyBirth = new PregnancyBirthEntity();
        pregnancyBirth.setHowWasThePregnancy(personalData.getPregnancyBirth().getHowWasThePregnancy());
        pregnancyBirth.setHowWasTheBirth(personalData.getPregnancyBirth().getHowWasTheBirth());
        pregnancyBirth.setApgar(personalData.getPregnancyBirth().getApgar());
        pregnancyBirth.setHowWasBreastfeedingDidYouHaveAnySuckingDifficulties(personalData.getPregnancyBirth()
                .getHowWasBreastfeedingDidYouHaveAnySuckingDifficulties());
        pregnancyBirth.setPersonalDataPregnancyBirth(personal);

        pregnancyBirthRepository.save(pregnancyBirth);

        DevelopmentDataEntity developmentData = new DevelopmentDataEntity();
        developmentData.setWhatIsSleepLike(personalData.getDevelopmentData().getWhatIsSleepLike());
        developmentData.setHeWasFussyBaby_heCriedLot(personalData.getDevelopmentData().getHeWasFussyBaby_heCriedLot());
        developmentData.setCervicalControl(personalData.getDevelopmentData().getCervicalControl());
        developmentData.setProneStay(personalData.getDevelopmentData().getProneStay());
        developmentData.setRoll(personalData.getDevelopmentData().getRoll());
        developmentData.setSit(personalData.getDevelopmentData().getSit());
        developmentData.setCrawl(personalData.getDevelopmentData().getCrawl());
        developmentData.setWalkingWithoutSupport(personalData.getDevelopmentData().getWalkingWithoutSupport());
        developmentData.setExploreObjectsWithYourMouth(personalData.getDevelopmentData().getExploreObjectsWithYourMouth());
        developmentData.setThereWasDelayLanguageDevelopment_canCommunicateEffectively(personalData.getDevelopmentData()
                .getThereWasDelayLanguageDevelopment_canCommunicateEffectively());
        developmentData.setPersonalDataDevelopmentData(personal);

        developmentDataRepository.save(developmentData);

        FoodEntity food = new FoodEntity();
        food.setHowWasFoodIntroduction(personalData.getFood().getHowWasFoodIntroduction());
        food.setChokingOnFoodOrLiquids(personalData.getFood().getChokingOnFoodOrLiquids());
        food.setPersonalDataFood(personal);

        foodRepository.save(food);

        UnfurlEntity unfurl = new UnfurlEntity();
        unfurl.setUseDiapers(personalData.getUnfurl().getUseDiapers());
        unfurl.setHaveYouAlreadyGoneThroughPottyTrainingProcess(personalData.getUnfurl()
                .getHaveYouAlreadyGoneThroughPottyTrainingProcess());
        unfurl.setPersonalDataUnfurl(personal);

        unfurlRepository.save(unfurl);

        DailyLivingActivitiesEntity dailyLivingActivities = new DailyLivingActivitiesEntity();
        dailyLivingActivities.setFeeding(personalData.getDailyLivingActivities().getFeeding());
        dailyLivingActivities.setDressing_undressing(personalData.getDailyLivingActivities().getDressing_undressing());
        dailyLivingActivities.setBrushYourTeeth(personalData.getDailyLivingActivities().getBrushYourTeeth());
        dailyLivingActivities.setHaveBath(personalData.getDailyLivingActivities().getHaveBath());
        dailyLivingActivities.setPersonalCleanliness(personalData.getDailyLivingActivities().getPersonalCleanliness());
        dailyLivingActivities.setPersonalDataDailyLivingActivities(personal);

        dailyLivingActivitiesRepository.save(dailyLivingActivities);

        return EnumPersonalData.CREATED_PATIENT;
    }

    public List listAllPatient() {
        
        List<PersonalDataEntity> listPersonalData = personalDataRepository.findAllByOrderByChildsNameAsc();

        List<DTOPersonalDataListResponse> dtoPersonalDataList = new ArrayList<>();

        for(PersonalDataEntity personal : listPersonalData) {
            DTOPersonalDataListResponse dtoPersonalData = new DTOPersonalDataListResponse();
            dtoPersonalData.setId_personalData(personal.getId());
            dtoPersonalData.setChildsName(personal.getChildsName());
            dtoPersonalData.setDateBirth(personal.getDateBirth());
            dtoPersonalData.setParentsName(personal.getParentsName());
            dtoPersonalData.setWithWhomLive(personal.getWithWhomLive());
            dtoPersonalData.setAllergy(personal.getAllergy());
            dtoPersonalData.setMedication(personal.getMedication());
            dtoPersonalData.setProfessionalsWhoAccompany(personal.getProfessionalsWhoAccompany());
            dtoPersonalData.setSchool(personal.getSchool());
            dtoPersonalData.setReligion(personal.getReligion());
            dtoPersonalData.setFamilyComplaints(personal.getFamilyComplaints());

            dtoPersonalData.setId_pregnancyBirth(personal.getPregnancyBirth().getPersonalDataPregnancyBirth().getId());
            dtoPersonalData.setHowWasThePregnancy(personal.getPregnancyBirth().getHowWasThePregnancy());
            dtoPersonalData.setHowWasTheBirth(personal.getPregnancyBirth().getHowWasTheBirth());
            dtoPersonalData.setApgar(personal.getPregnancyBirth().getApgar());
            dtoPersonalData.setHowWasBreastfeedingDidYouHaveAnySuckingDifficulties(personal.getPregnancyBirth()
                    .getHowWasBreastfeedingDidYouHaveAnySuckingDifficulties());

            dtoPersonalData.setId_developmentData(personal.getDevelopmentData().getPersonalDataDevelopmentData().getId());
            dtoPersonalData.setWhatIsSleepLike(personal.getDevelopmentData().getWhatIsSleepLike());
            dtoPersonalData.setHeWasFussyBaby_heCriedLot(personal.getDevelopmentData().getHeWasFussyBaby_heCriedLot());
            dtoPersonalData.setCervicalControl(personal.getDevelopmentData().getCervicalControl());
            dtoPersonalData.setProneStay(personal.getDevelopmentData().getProneStay());
            dtoPersonalData.setRoll(personal.getDevelopmentData().getRoll());
            dtoPersonalData.setSit(personal.getDevelopmentData().getSit());
            dtoPersonalData.setCrawl(personal.getDevelopmentData().getCrawl());
            dtoPersonalData.setWalkingWithoutSupport(personal.getDevelopmentData().getWalkingWithoutSupport());
            dtoPersonalData.setExploreObjectsWithYourMouth(personal.getDevelopmentData().getExploreObjectsWithYourMouth());
            dtoPersonalData.setThereWasDelayLanguageDevelopment_canCommunicateEffectively(personal.getDevelopmentData()
                    .getThereWasDelayLanguageDevelopment_canCommunicateEffectively());

            dtoPersonalData.setId_food(personal.getFood().getPersonalDataFood().getId());
            dtoPersonalData.setHowWasFoodIntroduction(personal.getFood().getHowWasFoodIntroduction());
            dtoPersonalData.setChokingOnFoodOrLiquids(personal.getFood().getChokingOnFoodOrLiquids());

            dtoPersonalData.setId_unfurl(personal.getUnfurl().getPersonalDataUnfurl().getId());
            dtoPersonalData.setUseDiapers(personal.getUnfurl().getUseDiapers());
            dtoPersonalData.setHaveYouAlreadyGoneThroughPottyTrainingProcess(personal.getUnfurl()
                    .getHaveYouAlreadyGoneThroughPottyTrainingProcess());

            dtoPersonalData.setId_dailyLivingActivities(personal.getDailyLivingActivities().getPersonalDataDailyLivingActivities().getId());
            dtoPersonalData.setFeeding(personal.getDailyLivingActivities().getFeeding());
            dtoPersonalData.setDressing_undressing(personal.getDailyLivingActivities().getDressing_undressing());
            dtoPersonalData.setBrushYourTeeth(personal.getDailyLivingActivities().getBrushYourTeeth());
            dtoPersonalData.setHaveBath(personal.getDailyLivingActivities().getHaveBath());
            dtoPersonalData.setPersonalCleanliness(personal.getDailyLivingActivities().getPersonalCleanliness());

            dtoPersonalDataList.add(dtoPersonalData);
        }

        return dtoPersonalDataList;

    }

    public DTOPersonalDataListResponse listPatient(long id) {
        
        Optional<PersonalDataEntity> personalData = personalDataRepository.findById(id)
                .filter(dc -> dc.isActive());

        if(personalData.isPresent()) {
            PersonalDataEntity personal = personalData.get();

            DTOPersonalDataListResponse dtoPersonalData = new DTOPersonalDataListResponse();
            dtoPersonalData.setId_personalData(personal.getId());
            dtoPersonalData.setChildsName(personal.getChildsName());
            dtoPersonalData.setDateBirth(personal.getDateBirth());
            dtoPersonalData.setParentsName(personal.getParentsName());
            dtoPersonalData.setWithWhomLive(personal.getWithWhomLive());
            dtoPersonalData.setAllergy(personal.getAllergy());
            dtoPersonalData.setMedication(personal.getMedication());
            dtoPersonalData.setProfessionalsWhoAccompany(personal.getProfessionalsWhoAccompany());
            dtoPersonalData.setSchool(personal.getSchool());
            dtoPersonalData.setReligion(personal.getReligion());
            dtoPersonalData.setFamilyComplaints(personal.getFamilyComplaints());

            dtoPersonalData.setId_pregnancyBirth(personal.getPregnancyBirth().getPersonalDataPregnancyBirth().getId());
            dtoPersonalData.setHowWasThePregnancy(personal.getPregnancyBirth().getHowWasThePregnancy());
            dtoPersonalData.setHowWasTheBirth(personal.getPregnancyBirth().getHowWasTheBirth());
            dtoPersonalData.setApgar(personal.getPregnancyBirth().getApgar());
            dtoPersonalData.setHowWasBreastfeedingDidYouHaveAnySuckingDifficulties(personal.getPregnancyBirth()
                    .getHowWasBreastfeedingDidYouHaveAnySuckingDifficulties());

            dtoPersonalData.setId_developmentData(personal.getDevelopmentData().getPersonalDataDevelopmentData().getId());
            dtoPersonalData.setWhatIsSleepLike(personal.getDevelopmentData().getWhatIsSleepLike());
            dtoPersonalData.setHeWasFussyBaby_heCriedLot(personal.getDevelopmentData().getHeWasFussyBaby_heCriedLot());
            dtoPersonalData.setCervicalControl(personal.getDevelopmentData().getCervicalControl());
            dtoPersonalData.setProneStay(personal.getDevelopmentData().getProneStay());
            dtoPersonalData.setRoll(personal.getDevelopmentData().getRoll());
            dtoPersonalData.setSit(personal.getDevelopmentData().getSit());
            dtoPersonalData.setCrawl(personal.getDevelopmentData().getCrawl());
            dtoPersonalData.setWalkingWithoutSupport(personal.getDevelopmentData().getWalkingWithoutSupport());
            dtoPersonalData.setExploreObjectsWithYourMouth(personal.getDevelopmentData().getExploreObjectsWithYourMouth());
            dtoPersonalData.setThereWasDelayLanguageDevelopment_canCommunicateEffectively(personal.getDevelopmentData()
                    .getThereWasDelayLanguageDevelopment_canCommunicateEffectively());

            dtoPersonalData.setId_food(personal.getFood().getPersonalDataFood().getId());
            dtoPersonalData.setHowWasFoodIntroduction(personal.getFood().getHowWasFoodIntroduction());
            dtoPersonalData.setChokingOnFoodOrLiquids(personal.getFood().getChokingOnFoodOrLiquids());

            dtoPersonalData.setId_unfurl(personal.getUnfurl().getPersonalDataUnfurl().getId());
            dtoPersonalData.setUseDiapers(personal.getUnfurl().getUseDiapers());
            dtoPersonalData.setHaveYouAlreadyGoneThroughPottyTrainingProcess(personal.getUnfurl()
                    .getHaveYouAlreadyGoneThroughPottyTrainingProcess());

            dtoPersonalData.setId_dailyLivingActivities(personal.getDailyLivingActivities().getPersonalDataDailyLivingActivities().getId());
            dtoPersonalData.setFeeding(personal.getDailyLivingActivities().getFeeding());
            dtoPersonalData.setDressing_undressing(personal.getDailyLivingActivities().getDressing_undressing());
            dtoPersonalData.setBrushYourTeeth(personal.getDailyLivingActivities().getBrushYourTeeth());
            dtoPersonalData.setHaveBath(personal.getDailyLivingActivities().getHaveBath());
            dtoPersonalData.setPersonalCleanliness(personal.getDailyLivingActivities().getPersonalCleanliness());

            return dtoPersonalData;
        } else {
            return null;
        }
    }

    public EnumPersonalData editDataPatient(long id, PersonalDataEntity personalData) {

         Optional<PersonalDataEntity> returnPersonal = personalDataRepository.findById(id)
                 .map(record -> {
                record.setChildsName(personalData.getChildsName());
                record.setDateBirth(personalData.getDateBirth());
                record.setParentsName(personalData.getParentsName());
                record.setWithWhomLive(personalData.getWithWhomLive());
                record.setAllergy(personalData.getAllergy());
                record.setMedication(personalData.getMedication());
                record.setProfessionalsWhoAccompany(personalData.getProfessionalsWhoAccompany());
                record.setSchool(personalData.getSchool());
                record.setReligion(personalData.getReligion());
                record.setFamilyComplaints(personalData.getFamilyComplaints());
                record.setActive(personalData.isActive());

                PersonalDataEntity updatePersonalData = personalDataRepository.save(record);

                return updatePersonalData;
            });

        if(returnPersonal == null) {
            return EnumPersonalData.UNEDITED_PATIENT;
        }

        return EnumPersonalData.PATIENT_EDITED;
    }

    public EnumPersonalData disablePatient(PersonalDataEntity personalData) {
        PersonalDataEntity disabledPatient = personalDataRepository.findById(personalData.getId()).get();

        if(!disabledPatient.isActive()) {
            return EnumPersonalData.PREVIOUSLY_DISABLED_PATIENT;
        }
        disabledPatient.setActive(false);
        PersonalDataEntity checkingDisabling = personalDataRepository.save(disabledPatient);
        if (!checkingDisabling.isActive()) {
            return EnumPersonalData.DISABLED_PATIENT;
        }

        return EnumPersonalData.UNSTABLE_SERVICE;
    }

}