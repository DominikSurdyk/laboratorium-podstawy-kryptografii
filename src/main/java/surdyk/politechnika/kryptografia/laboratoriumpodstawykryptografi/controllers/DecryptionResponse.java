package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.controllers;

import lombok.Data;

import java.util.List;

@Data
public class DecryptionResponse {
    private final String resultString;
    private final List<Boolean> resultAscii;
}
