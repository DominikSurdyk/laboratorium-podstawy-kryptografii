package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.controllers.rsa;

public class RsaKesyGenerator {

    public int findKey(int e, int phi){
        int i = 0;
        while (true){
            int result = (e * i) % phi;
            if (result == 1){
                return i;
            }
            i++;
        }

    }
}
