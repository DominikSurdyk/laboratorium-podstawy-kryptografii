package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.encryption.EncryptorService;
import surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.writefile.SaveLocallyService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MessageEncryptorController {

    private final EncryptorService encryptorService;
    private final SaveLocallyService saveLocallyService;

    @PostMapping("/encrypt/ascii")
    @ResponseBody
    @CrossOrigin(origins = {"*"})
    public List<Boolean> encryptAscii(final @RequestBody MessageEncryptorRequest request) {
        final List<Boolean> result = encryptorService.encryptFromAscii(request.getMessageAscii(), request.getKey());
        saveLocallyService.saveEncryptedMessage(request.getMessageFileName(), request.getKeyFileName(), result);
        return result;
    }

    @PostMapping("/encrypt/string")
    @ResponseBody
    @CrossOrigin(origins = {"*"})
    public List<Boolean> encryptString(final @RequestBody MessageEncryptorRequest request) {
        final List<Boolean> result = encryptorService.encryptFromString(request.getMessageString(), request.getKey());
        saveLocallyService.saveEncryptedMessage(request.getMessageFileName(), request.getKeyFileName(), result);
        return result;
    }

    @PostMapping("/decrypt/string")
    @ResponseBody
    @CrossOrigin(origins = {"*"})
    public DecryptionResponse decryptToString(final @RequestBody MessageEncryptorRequest request) {
        return new DecryptionResponse(
                encryptorService.decryptToString(request.getMessageAscii(), request.getKey()),
                null);
    }

    @PostMapping("/decrypt/ascii")
    @ResponseBody
    @CrossOrigin(origins = {"*"})
    public DecryptionResponse decryptToAscii(final @RequestBody MessageEncryptorRequest request) {
        return new DecryptionResponse(
                null,
                encryptorService.decryptToAscii(request.getMessageAscii(), request.getKey()));
    }
}
