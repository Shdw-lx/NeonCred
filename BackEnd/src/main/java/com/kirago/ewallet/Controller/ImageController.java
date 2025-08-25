package com.kirago.ewallet.Controller;

import com.kirago.ewallet.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController // C'est un Controller REST (API)
@RequestMapping("/image") // URL de base pour toutes les routes images
@CrossOrigin(origins = "*") // Autorise ton front Vue.js à appeler l'API
public class ImageController {

    @Autowired
    private ImageService imageService;

    /**
     * Upload d'une image utilisateur
     * Endpoint : POST http://localhost:8080/api/images/upload/utilisateur
     */
    @PostMapping("/utilisateur")
    public ResponseEntity<String> uploadUserImage(@RequestParam("file") MultipartFile file) {
        try {
            // Sauvegarde dans "imageUtilisateur"
            String imageUrl = imageService.saveImage(file, "imageUtilisateur");
            return ResponseEntity.ok("http://localhost:8080" + imageUrl);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Erreur lors de l’upload : " + e.getMessage());
        }
    }

    /**
     * Upload d'une image produit
     * Endpoint : POST http://localhost:8080/api/images/upload/produit
     */
    @PostMapping("/produit")
    public ResponseEntity<String> uploadProductImage(@RequestParam("file") MultipartFile file) {
        try {
            // Sauvegarde dans "imageProduit"
            String imageUrl = imageService.saveImage(file, "imageProduit");
            return ResponseEntity.ok("http://localhost:8080" + imageUrl);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Erreur lors de l’upload : " + e.getMessage());
        }
    }
}