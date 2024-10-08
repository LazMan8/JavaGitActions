package fr.m2i.api.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest

@AutoConfigureMockMvc
public class UserControllerTest {
	// Injection automatique d'une instance de MockMvc pour simuler les requêtes HTTP
	@Autowired
	private MockMvc mockMvc;

	  @Test
	  void testPostUser() throws Exception {
	    // Exécution d'une requête GET sur le point de terminaison "/user" et attente d'un statut HTTP 200 (OK)
	    MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/user").content("Laza"))
	      .andExpect(MockMvcResultMatchers.status().isOk()) // Vérifie que le statut de la réponse est 200 OK
	      .andReturn(); // Récupère le résultat de la requête
	
	    // Récupération de la réponse sous forme de chaîne de caractères
	    String resultStr = result.getResponse().getContentAsString();
	
	    // Vérification que la réponse est bien "Hello World"
	    assertEquals("Ok", resultStr);
	  }
	
	  @Test
	  void testGetUserPage() throws Exception {
	    // Exécution d'une requête GET sur le point de terminaison "/user/{username}"
	    MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/user/Laza"))
	      .andExpect(MockMvcResultMatchers.status().isOk()) // Vérifie que le statut de la réponse est 200 OK
	      .andReturn(); // Récupère le résultat de la requête
	
	    // Récupération de la réponse sous forme de chaîne de caractères
	    String resultStr = result.getResponse().getContentAsString();
	
	    // Vérification que la réponse est bien "Ok"
	    assertEquals("Ok", resultStr);
  }

}