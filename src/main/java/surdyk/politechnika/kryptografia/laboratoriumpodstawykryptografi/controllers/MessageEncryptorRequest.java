package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.controllers;

import lombok.Data;

import java.util.List;

@Data
public class MessageEncryptorRequest {
    final private List<Boolean> messageAscii;
    final private String messageString;
    final private String messageFileName;
    final private List<Boolean> key;
    final private String keyFileName;
}
