package com.kirago.ewallet.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionRequest {
    // Cas formulaire
    private String sourceId;       // Id de l’utilisateur qui paie
    private String destinationId;   // Id du commerçant qui reçoit (utilisé si pas QR)
    private Long montant;        // Montant de la transaction
    private String password;       // Mot de passe du client
    private String type;

    // Cas QR code
    private String qrCodeData;     // Contient toutes les infos encodées dans le QR
}