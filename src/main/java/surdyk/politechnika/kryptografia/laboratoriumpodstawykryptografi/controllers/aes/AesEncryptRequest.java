package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.controllers.aes;

import lombok.Data;

@Data
public class AesEncryptRequest {
    final private String message;
    final private String secret;
    final private String initVector;
}
