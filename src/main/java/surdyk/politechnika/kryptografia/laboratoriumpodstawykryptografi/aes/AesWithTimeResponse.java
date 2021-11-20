package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.aes;

import lombok.Data;

@Data
public class AesWithTimeResponse {
    private final byte[] message;
    private final long processTimeMiliSec;
}
