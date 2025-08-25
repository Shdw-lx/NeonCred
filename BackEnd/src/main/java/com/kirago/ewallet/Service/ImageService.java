package com.kirago.ewallet.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service // Service = logique métier (ici, gestion des fichiers)
public class ImageService {

    // Chemin vers le dossier "static" où tu stockes les images
    private final String staticDir = "src/main/resources/static/";

    /**
     * Sauvegarde une image dans le dossier spécifié (utilisateur ou produit)
     * @param file l'image envoyée (via POSTMAN ou Vue.js)
     * @param folder dossier cible ("imageUtilisateur" ou "imageProduit")
     * @return l'URL publique de l'image
     * @throws IOException si un problème survient lors de l'écriture du fichier
     */
    public String saveImage(MultipartFile file, String folder) throws IOException {
        // Vérifie si le dossier existe, sinon il le crée
        File directory = new File(staticDir + folder);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Nom unique pour éviter que deux images écrasent la même
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

        // Chemin complet du fichier
        Path filePath = Paths.get(staticDir + folder, fileName);

        // Sauvegarde le fichier sur le disque
        Files.write(filePath, file.getBytes());

        // Retourne l’URL accessible publiquement
        return "/" + folder + "/" + fileName;
    }
}