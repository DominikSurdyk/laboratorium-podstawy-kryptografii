package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.controllers.aes;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.aes.CbcService;
import surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.aes.EcbService;
import surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.aes.PbcService;
import surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.writefile.SaveLocallyService;

@RestController
@RequiredArgsConstructor
public class AesController {

    private final EcbService ecbService;
    private final CbcService cbcService;
    private final PbcService pbcService;
    private final SaveLocallyService saveLocallyService;

    @PostMapping("/aes/ecb/encrypt")
    @ResponseBody
    @CrossOrigin(origins = {"*"})
    public AesResponse ecbEncrypt(@RequestBody AesEncryptRequest request) {
        return new AesResponse(ecbService.encrypt(request.getMessage(), request.getSecret()));
    }

    @PostMapping("/aes/ecb/decrypt")
    @ResponseBody
    @CrossOrigin(origins = {"*"})
    public AesResponse ecbDecrypt(@RequestBody AesEncryptRequest request) {
        return new AesResponse(ecbService.decrypt(request.getMessage(), request.getSecret()));
    }

    @PostMapping("/aes/cbc/encrypt")
    @ResponseBody
    @CrossOrigin(origins = {"*"})
    public AesResponse cbcEncrypt(@RequestBody AesEncryptRequest request) {
        final String encryptedMessage = cbcService.encrypt(request.getMessage(), request.getSecret(), request.getInitVector());
        saveLocallyService.saveEncryptedCbcMessage(encryptedMessage, request.getSecret(), request.getInitVector());
        return new AesResponse(encryptedMessage);
    }

    @PostMapping("/aes/cbc/decrypt")
    @ResponseBody
    @CrossOrigin(origins = {"*"})
    public AesResponse cbcDecrypt(@RequestBody AesEncryptRequest request) {
        return new AesResponse(cbcService.decrypt(request.getMessage(), request.getSecret(), request.getInitVector()));
    }

    @PostMapping("/aes/pbc/encrypt")
    @ResponseBody
    @CrossOrigin(origins = {"*"})
    public AesResponse pbcEncrypt(@RequestBody AesEncryptRequest request) {
        return new AesResponse(pbcService.encrypt(request.getMessage(), request.getSecret(), request.getInitVector()));
    }

    @PostMapping("/aes/pbc/decrypt")
    @ResponseBody
    @CrossOrigin(origins = {"*"})
    public AesResponse pbcDecrypt(@RequestBody AesEncryptRequest request) {
        return new AesResponse(pbcService.decrypt(request.getMessage(), request.getSecret(), request.getInitVector()));
    }
}
