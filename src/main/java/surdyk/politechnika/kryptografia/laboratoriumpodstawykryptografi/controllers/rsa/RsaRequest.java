package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.controllers.rsa;

import lombok.Data;

@Data
public class RsaRequest {
    private final String message;
    private final String eParamPublic;
    private final String dParamPrivate;
    private final String nParamCommon;
}
