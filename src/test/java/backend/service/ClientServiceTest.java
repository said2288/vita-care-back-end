//package backend.service;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import backend.entity.PersonalDataEntity;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//
//import static org.mockito.BDDMockito.given;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import backend.entity.PersonEntity;
//import backend.repository.PersonRepository;
//
//@ExtendWith(MockitoExtension.class)
//class ClientServiceTest {
//
//	@Mock
//    private PersonRepository personRepository;
//
//	@InjectMocks
//	private ClientService clientService;
//
//	/* ==================== Setting the scene ==================== */
//	// Creating a list of client
//	List<PersonalDataEntity> testList = new ArrayList<PersonalDataEntity>();
//	// Creating customers
//	PersonalDataEntity personData0 = new PersonalDataEntity(
//			(long) 1, "Mohamad Montalbo", "777777777", "said2288@hotmail.com", "983999224", true, null);
//	PersonalDataEntity personData1 = new PersonalDataEntity(
//			(long) 2, "Aaid Montalbo", "888888888", "montalbo005@gmail.com", "983999224", true, null);
//
//	// Customer with Optional
//	Optional<PersonalDataEntity> personEntityOptional = Optional.ofNullable(new PersonalDataEntity(
//					(long) 1, "Mohamad Montalbo", "999999999", "said2288@hotmail.com", "983999224", true, null));
//
//	/* ======================== Execution ======================== */
//	@Test
//	void testListAllCustomers() {
//
//		// Add customers to a list
//		testList.add(personData0);
//		testList.add(personData1);
//
//		/* ==================== Verification ==================== */
//		given(personRepository.findAllByOrderByOrderByChildsNameAsc()).willReturn(testList);
//
//		List customerList = clientService.listAllCustomers();
//
//		assertNotNull(customerList);
//		assertThat(customerList.size()).isEqualTo(2);
//	}
//
//	@Test
//	void testListCustomer() {
//
//		// Creating variable for id control
//		long id = 1;
//
//		/* ==================== Verification ==================== */
//		given(personRepository.findById(id)).willReturn(personEntityOptional);
//
//		Optional<PersonalDataEntity> personIdFindOrNot = clientService.listCustomer(id);
//
//		assertNotNull(personIdFindOrNot);
//	}
//
////	@Test
////	void testCreationFromCustomer() {
////
////		/* ==================== Verification ==================== */
////		given(personRepository.save(personEntity0)).willReturn(personEntity0);
////
////		PersonEntity responsePerson = clientService.creationFromCustomer(personEntity0);
////
////		assertNotNull(responsePerson);
////	}
//
//	@Test
//	void testEditData() {
//
//		// Creating variable for id control
//		long id = 1;
//
//		// Fields update only in "name" and "email".
//		personData0.setChildsName("Montalbo");
//		personData1.setEmail("montalbo@gmail.com");
//
//		/* ==================== Verification ==================== */
//		given(personRepository.findById(id)).willReturn(personEntityOptional);
//		given(personRepository.save(personData0)).willReturn(personData0);
//
//		Optional<PersonalDataEntity> gettingUpdatedCustomer = clientService.editData(id, personData0);
//
//		assertEquals(gettingUpdatedCustomer.get().getChildsName(), "Montalbo");
//		assertEquals(gettingUpdatedCustomer.get().getEmail(), "montalbo@gmail.com");
//	}
//
//	@Test
//	void testDisableClient() {
//
//		// Creating variable for id control
//		long id = 1;
//
//		// Fields update only in "active = false".
//		personData0.setActive(false);
//
//		/* ==================== Verification ==================== */
//		assertEquals(personData0.isActive(), false);
//	}
//
//}
