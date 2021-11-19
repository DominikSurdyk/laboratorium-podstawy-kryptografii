package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.controllers.rsa;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.common.StringHelper;
import surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.rsa.RsaEncryptService;
import surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.writefile.SaveLocallyService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RsaController {
    private final RsaEncryptService rsaEncryptService;
    private final SaveLocallyService saveLocallyService;
    private final StringHelper stringHelper = new StringHelper();


    @PostMapping("/rsa/encrypt")
    @ResponseBody
    @CrossOrigin(origins = {"*"})
    public RsaResponse rsaEncrypt(@RequestBody RsaRequest request) {
        final List<String> encryptedMessage = rsaEncryptService.encrypt(request.getMessage(), request.getEParamPublic(), request.getNParamCommon());
        final String responseMessage = stringHelper.join(encryptedMessage);
        saveLocallyService.saveEncryptedRsaMessage(responseMessage, request.getEParamPublic(), request.getDParamPrivate(), request.getNParamCommon());
        return new RsaResponse(responseMessage);
    }

    @PostMapping("/rsa/decrypt")
    @ResponseBody
    @CrossOrigin(origins = {"*"})
    public RsaResponse rsaDecrypt(@RequestBody RsaRequest request) {
        final List<String> message = stringHelper.toArray(request.getMessage());
        final String decrypted = rsaEncryptService.decrypt(message, request.getEParamPublic(), request.getNParamCommon());
        return new RsaResponse(decrypted);
    }
}
