package fr.m2i.api.controllers;

// Importation des assertions JUnit pour vérifier les résultats des tests
import static org.junit.jupiter.api.Assertions.assertEquals;



import org.junit.jupiter.api.Test; // Annotation JUnit pour marquer une méthode comme un test
import org.springframework.beans.factory.annotation.Autowired; // Annotation Spring pour injecter des dépendances
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc; // Annotation Spring pour configurer automatiquement MockMvc
import org.springframework.boot.test.context.SpringBootTest; // Annotation pour indiquer que les tests exécutent un contexte Spring
import org.springframework.test.web.servlet.MockMvc; // Classe utilisée pour simuler des requêtes HTTP dans les tests
import org.springframework.test.web.servlet.MvcResult; // Classe pour stocker le résultat d'une requête
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders; // Utilisée pour construire des requêtes HTTP dans les tests
import org.springframework.test.web.servlet.result.MockMvcResultMatchers; // Utilisée pour vérifier les résultats des requêtes

// Annotation pour indiquer que la classe est un test de contexte Spring
@SpringBootTest
// Annotation pour configurer et utiliser automatiquement MockMvc
@AutoConfigureMockMvc
public class HelloControllerTest {

    // Injection automatique d'une instance de MockMvc pour simuler les requêtes HTTP
	@Autowired
	private MockMvc mockMvc;
	
	// Définition d'un test pour le point de terminaison GET "/hello"
	@Test
	public void testGetHello() throws Exception {
        // Exécution d'une requête GET sur le point de terminaison "/hello" et attente d'un statut HTTP 200 (OK)
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
                                  .andExpect(MockMvcResultMatchers.status().isOk()) // Vérifie que le statut de la réponse est 200 OK
                                  .andReturn(); // Récupère le résultat de la requête
		
        // Récupération de la réponse sous forme de chaîne de caractères
		String resultStr = result.getResponse().getContentAsString();
		
        // Vérification que la réponse est bien "Hello World"
		assertEquals("Hello World", resultStr);

	}
	
	@Test
	public void testGetHome() throws Exception {
	    // Exécution d'une requête GET sur le point de terminaison racine "/" et vérification que le statut HTTP renvoyé est 200 (OK)
	    MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/"))
	                              .andExpect(MockMvcResultMatchers.status().isOk()) // Vérifie que la réponse a un statut HTTP 200 (OK)
	                              .andReturn(); // Récupère le résultat de la requête pour le traitement

	    // Extraction du contenu de la réponse sous forme de chaîne de caractères
	    String resultStr = result.getResponse().getContentAsString();

	    // Vérification que la réponse est bien la chaîne de caractères "home"
	    assertEquals("home", resultStr);
	}
	
}
