package fr.m2i.api.controllers;

// Importation des annotations de Spring pour la gestion des points de terminaison HTTP
import org.springframework.web.bind.annotation.GetMapping; // Utilisé pour définir une route GET
import org.springframework.web.bind.annotation.RestController; // Marque la classe comme un contrôleur REST

// Annotation @RestController indique que cette classe est un contrôleur Spring qui gère des requêtes RESTful
@RestController
public class HelloController {
	
    // Annotation @GetMapping pour définir le point de terminaison HTTP GET pour la route "/hello"
    @GetMapping("/hello")
    public String getHello(){
        // Méthode qui sera appelée lorsqu'une requête GET est envoyée à "/hello"
        // Retourne une simple chaîne de caractères "Hello World" comme réponse
        return "Hello World";
    }
    
 // Annotation @GetMapping pour associer cette méthode à une requête HTTP GET sur le chemin racine "/"
    @GetMapping("/")
    public String home() {
        // Méthode qui sera exécutée lorsqu'une requête GET est envoyée à "/"
        // Retourne une chaîne de caractères "home" comme réponse
        return "home";
    }

    
}
