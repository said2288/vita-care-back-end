package backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import backend.Enum.EnumPersonalData;
import backend.entity.PersonalDataEntity;
import backend.service.PersonalDataService;

/**
 *
 * @author mohamad
 */

@Api(tags = "Controller Paciente")
@RestController
@RequestMapping("/paciente")
public class PersonalDataController {
    
    private final PersonalDataService patientService;
    
    PersonalDataController(PersonalDataService patientService) {
        this.patientService = patientService;
    }

    @ApiOperation("Cria um novo paciente")
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public ResponseEntity creationFromPatient(@RequestBody PersonalDataEntity personalData) {

        EnumPersonalData returnEnum = patientService.creationFromPatient(personalData);

        if(returnEnum.getActive()) {
            return new ResponseEntity(String.format("%s", returnEnum.getDescription()), HttpStatus.CREATED);
        } else {
            return new ResponseEntity(String.format("%s", returnEnum.getDescription()), HttpStatus.BAD_REQUEST);
        }

    }

    @ApiOperation("Lista todos os pacientes")
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity listAllPatient() {
        
        if(patientService.listAllPatient().isEmpty()) {
            return new ResponseEntity("Dados de pacientes inexistentes",HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(patientService.listAllPatient(), HttpStatus.OK);
        }
        
    }

    @ApiOperation("Busca um paciente por ID")
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = {"/{id}"})
    public ResponseEntity listPatient(@PathVariable long id) {
                      
        if(patientService.listPatient(id) != null) {
            return new ResponseEntity(patientService.listPatient(id), HttpStatus.OK);
        } else {
            return new ResponseEntity("Dados de paciente inexistente", HttpStatus.NOT_FOUND);
        }
        
    }

    @ApiOperation("Edita os dados de um paciente")
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(path = {"/{id}"})
    public ResponseEntity editDataPatient(@PathVariable long id,
                                      @RequestBody PersonalDataEntity personalData) {

        EnumPersonalData returnEnum = patientService.editDataPatient(id, personalData);

        if(returnEnum.getActive()) {
            return new ResponseEntity(String.format("%s", returnEnum.getDescription()), HttpStatus.OK);
        } else {
            return new ResponseEntity(String.format("%s", returnEnum.getDescription()), HttpStatus.NOT_FOUND);
        }
        
    }

    @ApiOperation("Desabilita um paciente")
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(path = {"/desabilitar"})
    public ResponseEntity disablePatient(@RequestBody PersonalDataEntity personalData) {

        EnumPersonalData returnEnum = patientService.disablePatient(personalData);

        if(!returnEnum.getActive()) {
            return new ResponseEntity(String.format("%s", returnEnum.getDescription()), HttpStatus.OK);
        } else {
            return new ResponseEntity(String.format("%s", returnEnum.getDescription()), HttpStatus.NOT_MODIFIED);
        }
    }

}


