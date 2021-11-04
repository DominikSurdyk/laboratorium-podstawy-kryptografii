package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi;

public class BlumFinderVerifier {
    public static boolean isBlumInteger(int n)
    {
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i < n; i++)
            prime[i] = true;

        // to store prime numbers from 2 to n
        for (int i = 2; i * i <= n; i++) {

            // If prime[i] is not changed,
            // then it is a prime
            if (prime[i] == true) {

                // Update all multiples of p
                for (int j = i * 2; j <= n; j += i)
                    prime[j] = false;
            }
        }

        // to check if the given odd integer
        // is Blum Integer or not
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {

                // checking the factors are
                // of 4t + 3 form or not
                if ((n % i == 0) && ((i - 3) % 4) == 0) {
                    int q = n / i;
                    return (q != i && prime[q] &&
                            (q - 3) % 4 == 0);
                }
            }
        }
        return false;
    }
}
