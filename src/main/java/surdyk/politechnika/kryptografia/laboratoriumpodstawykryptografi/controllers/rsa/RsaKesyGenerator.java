package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.controllers.rsa;

public class RsaKesyGenerator {

    public int findKey(int e, int q){
        int i = 0;
        while (true){
            int result = (e * i) % q;
            if (result == 1){
                return i;
            }
            i++;
        }

    }
}
