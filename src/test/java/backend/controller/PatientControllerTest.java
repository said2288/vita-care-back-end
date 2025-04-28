//package backend.controller;

//import static org.hamcrest.Matchers.containsString;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import backend.Enum.EnumPersonalData;
//import backend.entity.PersonalDataEntity;
//import backend.service.PersonalDataService;
//import org.hamcrest.Matchers;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@WebMvcTest
//class PatientControllerTest {
//
//    @Autowired
//	private MockMvc mockMvc;
//
//	@MockBean
//	private PersonalDataService patientService;
//
//	private ObjectMapper mapper = new ObjectMapper();
	
	/* ==================== Setting the scene ==================== */
	// Creating a list of client
//	List<PersonalDataEntity> children = new ArrayList<PersonalDataEntity>();

	// Creating customers
//	PersonalDataEntity child = new PersonalDataEntity(
//			(long) 1, "Junior", "01/01/2006", "Roberto e Andressa", "Com os pais.", "não", "não", "não", "sim", "sim", "nenhuma", true);
//
//	PersonalDataEntity childWithActiveFalse = new PersonalDataEntity(
//			(long) 1, "Junior", "01/01/2006", "Roberto e Andressa", "Com os pais.", "não", "não", "não", "sim", "sim", "nenhuma", true);
//
//	// Customer with Optional
//	Optional<PersonalDataEntity> personalDataOptional = Optional.of(new PersonalDataEntity(
//			(long) 1, "Junior", "01/01/2006", "Roberto e Andressa", "Com os pais.", "não", "não", "não", "sim", "sim", "nenhuma", true)
//	);
//
//	/* ======================== Execution ======================== */
//	@Test
//	void listAllPatientTest() throws Exception {
//
//		// Add customer to a list
//		children.add(child);
//
//		// Creation of mock
//		Mockito.when(patientService.listAllPatient()).thenReturn(children);
//
//		//Verification
//	    mockMvc.perform(get("/paciente"))
//	    	.andExpect(status().isOk())
//	    	.andExpect(jsonPath("$", Matchers.hasSize(1)))
//			.andExpect(jsonPath("$[0]", Matchers.hasEntry("id", 1)))
//			.andExpect(jsonPath("$[0]", Matchers.hasEntry("childsName", "Junior")))
//		    .andExpect(jsonPath("$[0]", Matchers.hasEntry("dateBirth", "01/01/2006")))
//			.andExpect(jsonPath("$[0]", Matchers.hasEntry("parentsName", "Roberto e Andressa")))
//		    .andExpect(jsonPath("$[0]", Matchers.hasEntry("withWhomLive", "Com os pais.")))
//		    .andExpect(jsonPath("$[0]", Matchers.hasEntry("allergy", "não")))
//			.andExpect(jsonPath("$[0]", Matchers.hasEntry("medication", "não")))
//			.andExpect(jsonPath("$[0]", Matchers.hasEntry("professionalsWhoAccompany", "não")))
//			.andExpect(jsonPath("$[0]", Matchers.hasEntry("school", "sim")))
//			.andExpect(jsonPath("$[0]", Matchers.hasEntry("religion", "sim")))
//			.andExpect(jsonPath("$[0]", Matchers.hasEntry("familyComplaints", "nenhuma")))
//			.andExpect(jsonPath("$[0]", Matchers.hasEntry("active", true)))
//			.andExpect(jsonPath("$[0].addressEntity", Matchers.hasEntry("id", 1)))
//			.andExpect(jsonPath("$[0].addressEntity", Matchers.hasEntry("state", "SP")))
//			.andExpect(jsonPath("$[0].addressEntity", Matchers.hasEntry("city", "Campinas")))
//			.andExpect(jsonPath("$[0].addressEntity", Matchers.hasEntry("zipCode", "13034100")))
//			.andExpect(jsonPath("$[0].addressEntity", Matchers.hasEntry("neighborhood", "Centro")))
//			.andExpect(jsonPath("$[0].addressEntity", Matchers.hasEntry("address", "Rua Campos Salles")))
//			.andExpect(jsonPath("$[0].addressEntity", Matchers.hasEntry("number", "500")));
//	}
//
//	@Test
//	void listAllCustomers_empty_patient_list_Test() throws Exception {
//
//		//Verification
//		mockMvc.perform(get("/paciente"))
//			.andExpect(status().isNotFound());
//	}
//
//	@Test
//	void listPatientTest() throws Exception {
//
//		// Creating variable for id control
//		long id = 1;
//
//		// Creation of mock
//		Mockito.when(patientService.listPatient(id)).thenReturn(personalDataOptional);
//
//		//Verification
//	    mockMvc.perform(get("/paciente/{id}", id))
//	    	.andExpect(status().isOk())
//			.andExpect(jsonPath("$", Matchers.hasEntry("childsName", "Junior")))
//			.andExpect(jsonPath("$", Matchers.hasEntry("dateBirth", "01/01/2006")))
//			.andExpect(jsonPath("$", Matchers.hasEntry("parentsName", "Roberto e Andressa")))
//			.andExpect(jsonPath("$", Matchers.hasEntry("withWhomLive", "Com os pais.")))
//			.andExpect(jsonPath("$", Matchers.hasEntry("allergy", "não")))
//			.andExpect(jsonPath("$", Matchers.hasEntry("medication", "não")))
//			.andExpect(jsonPath("$", Matchers.hasEntry("professionalsWhoAccompany", "não")))
//			.andExpect(jsonPath("$", Matchers.hasEntry("school", "sim")))
//			.andExpect(jsonPath("$", Matchers.hasEntry("religion", "sim")))
//			.andExpect(jsonPath("$", Matchers.hasEntry("familyComplaints", "nenhuma")))
//			.andExpect(jsonPath("$", Matchers.hasEntry("active", true)))
//			.andExpect(jsonPath("$", Matchers.hasEntry("addressEntity", null)));
//	}
//
//	@Test
//	void listPatient_patient_not_exist_Test() throws Exception {
//
//		// Creating variable for id control
//		long id = 1;
//
//		//Verification
//		mockMvc.perform(get("/paciente/{id}", id))
//			.andExpect(status().isNotFound())
//		    .andExpect(content().string("Dados de paciente inexistente"));
//	}
//
//	@Test
//	void creationFromPatientTest() throws Exception {
//
//		// Creation of mock
//		Mockito.when(patientService.creationFromPatient(child)).thenReturn(EnumPersonalData.CREATED_PATIENT);
//		String json = mapper.writeValueAsString(child);
//
//	    // Verification
//	    mockMvc.perform(post("/paciente")
//	    	.contentType(org.springframework.http.MediaType.APPLICATION_JSON)
//	    	.characterEncoding("utf-8")
//	        .content(json)
//	        .accept(org.springframework.http.MediaType.APPLICATION_JSON))
//			.andExpect(status().isCreated())
//			.andExpect(content().string(containsString("Paciente criado com sucesso")));
//
//	}
//
//	@Test
//	void creationFromPatient_existing_patient_Test() throws Exception {
//
//		// Creation of mock
//		Mockito.when(patientService.creationFromPatient(child)).thenReturn(EnumPersonalData.PATIENT_NOT_CREATED);
//		String json = mapper.writeValueAsString(child);
//
//		// Verification
//		mockMvc.perform(post("/paciente")
//			.contentType(org.springframework.http.MediaType.APPLICATION_JSON)
//			.characterEncoding("utf-8")
//			.content(json)
//			.accept(org.springframework.http.MediaType.APPLICATION_JSON))
//			.andExpect(status().isBadRequest())
//			.andExpect(content().string(containsString("Dados existentes ou servidor instÃ¡vel")));
//	}
//
//	@Test
//	void editDataPatientTest() throws Exception {
//
//		// Creating variable for id control
//		long id = 1;
//
//		// Creation of mock
//		Mockito.when(patientService.editDataPatient(id, child)).thenReturn(EnumPersonalData.PATIENT_EDITED);
//		String json = mapper.writeValueAsString(child);
//
//		//Verification
//	    mockMvc.perform(put("/paciente/{id}", id)
//	    	.contentType(org.springframework.http.MediaType.APPLICATION_JSON)
//	    	.characterEncoding("utf-8")
//	        .content(json)
//	        .accept(org.springframework.http.MediaType.APPLICATION_JSON))
//			.andExpect(status().isOk())
//			.andExpect(content().string(containsString("Paciente alterado com sucesso")));
//	}
//
//	@Test
//	void editDataPatient_patient_not_found_Test() throws Exception {
//
//		// Creating variable for id control
//		long id = 1;
//
//		// Creation of mock
//		Mockito.when(patientService.editDataPatient(id, child)).thenReturn(EnumPersonalData.UNEDITED_PATIENT);
//		String json = mapper.writeValueAsString(child);
//
//		//Verification
//		mockMvc.perform(put("/paciente/{id}", id)
//			.contentType(org.springframework.http.MediaType.APPLICATION_JSON)
//			.characterEncoding("utf-8")
//			.content(json)
//			.accept(org.springframework.http.MediaType.APPLICATION_JSON))
//			.andExpect(status().isNotFound())
//			.andExpect(content().string(containsString("Paciente nÃ£o encontrado")));
//	}
//
//	@Test
//	void disablePatientTest() throws Exception {
//
//		// Creation of mock
//		Mockito.when(patientService.disablePatient(child)).thenReturn(EnumPersonalData.DISABLED_PATIENT);
//		String json = mapper.writeValueAsString(child);
//
//		// Verification
//		mockMvc.perform(put("/paciente/desabilitar")
//			.contentType(org.springframework.http.MediaType.APPLICATION_JSON)
//			.characterEncoding("utf-8")
//			.content(json)
//			.accept(org.springframework.http.MediaType.APPLICATION_JSON))
//			.andExpect(status().isOk())
//			.andExpect(content().string(containsString("Paciente desabilitado com sucesso")));
//	}
//
//	@Test
//	void disablePatient_previously_disabled_client_Test() throws Exception {
//
//		// Creation of mock
//		Mockito.when(patientService.disablePatient(child)).thenReturn(EnumPersonalData.PREVIOUSLY_DISABLED_PATIENT);
//		String json = mapper.writeValueAsString(child);
//
//		// Verification
//		mockMvc.perform(put("/paciente/desabilitar")
//			.contentType(org.springframework.http.MediaType.APPLICATION_JSON)
//			.characterEncoding("utf-8")
//			.content(json)
//			.accept(org.springframework.http.MediaType.APPLICATION_JSON))
//			.andExpect(status().isOk())
//			.andExpect(content().string(containsString("Anteriormente, paciente jÃ¡ foi desabilitado")));
//	}
//
//	@Test
//	void disablePatient_unstable_service_Test() throws Exception {
//
//		// Creation of mock
//		Mockito.when(patientService.disablePatient(child)).thenReturn(EnumPersonalData.UNSTABLE_SERVICE);
//		String json = mapper.writeValueAsString(child);
//
//		// Verification
//		mockMvc.perform(put("/paciente/desabilitar")
//						.contentType(org.springframework.http.MediaType.APPLICATION_JSON)
//						.characterEncoding("utf-8")
//						.content(json)
//						.accept(org.springframework.http.MediaType.APPLICATION_JSON))
//				.andExpect(status().isNotModified())
//				.andExpect(content().string(containsString("ServiÃ§o instÃ¡vel, tente novamente")));
//	}
//}
