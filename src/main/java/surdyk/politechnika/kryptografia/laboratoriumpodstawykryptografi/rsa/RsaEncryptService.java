package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.rsa;

import java.util.List;

public interface RsaEncryptService {

    public List<String> encrypt(final String message, final String eParamPublic, final String nParamCommon);

    public String decrypt(final List<String> message, final String dParamPrivate, final String nParamCommon);

}
