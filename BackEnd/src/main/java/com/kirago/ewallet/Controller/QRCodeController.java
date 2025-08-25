package com.kirago.ewallet.Controller;

import com.kirago.ewallet.Service.QRCodeService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller pour générer un QR Code pour une transaction.
 */
@RestController
@RequestMapping("/qrcode")
public class QRCodeController {

    private final QRCodeService qrCodeService;

    public QRCodeController(QRCodeService qrCodeService) {
        this.qrCodeService = qrCodeService;
    }

    /**
     * Génère un QR Code à partir du texte envoyé
     * Exemple : /api/qrcode/generate?data=Transaction#12345
     */
    @GetMapping(value = "/generate", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> generateQRCode(@RequestParam String data) {
        byte[] qrImage = qrCodeService.generateQRCodeImage(data, 250, 250);
        return ResponseEntity.ok(qrImage);
    }
}