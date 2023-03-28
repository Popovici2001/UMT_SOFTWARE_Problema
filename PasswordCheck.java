package com.company;

public class PasswordCheck {
    public void CheckPassword(String[] array){

        int Cifre = 0;  // numara cifre
        int LitMica = 0; // numara literele mici
        int LitMare = 0; // numara literele mari
        int Lungime = 0;  // verifica daca lungimea este potrivita sau nu
        int verificare = 0; // verifica daca parola are sau nu toate 3 tipurile cerute
        int verificare12;  // primele 2 caracrere
        int verificare23;  // urmatoarele 2 caractere
        int treiLaFel = 0; // numara ciclurile de cate 3 caractere identice consecutive
        int n; // numarul de caractere in lipsa sau in exces

        // numararea fiecarui tip de caracter

        if (array.length >= 6 && array.length <= 20)
            Lungime++;
        for (String s : array) {
            if (Character.isLowerCase(s.charAt(0)))
                LitMica++;
            if (Character.isUpperCase(s.charAt(0)))
                LitMare++;
            if (Character.isDigit(s.charAt(0)))
                Cifre++;
        }

        // verificarea ciclurilor de 3 caractere consecutive

        if (Cifre > 0 && LitMare > 0 && LitMica > 0)
            verificare++;
        for (int i = 0; i < array.length - 2; i++) {
            verificare12 = Character.compare(array[i].charAt(0), array[i + 1].charAt(0));
            verificare23 = Character.compare(array[i + 1].charAt(0), array[i + 2].charAt(0));
            if ((verificare12 == 0) && (verificare23 == 0)) {
                treiLaFel++;
                i++;
            }
        }

        // verificarea parolei

        if (Lungime > 0 && treiLaFel==0 && verificare > 0)
            System.out.println("Password is strong");
        else
            System.out.println("Password is weak");

        // in cazul in care parola nu este strong, se calculeaza numarul minim de modificari necesare
        // se ia cazuri separate

        if (Lungime > 0) {  // cazul in care lungimea este buna
                if (treiLaFel == 0) {  // cazul in care nu avem cicluri de 3 caractere identice consecutive
                    if (Cifre > 0 && LitMica > 0 && LitMare == 0)
                        System.out.println("We need 1 changes to make a strong password");
                    else if (Cifre > 0 && LitMica == 0 && LitMare > 0)
                        System.out.println("We need 1 changes to make a strong password");
                    else if (Cifre == 0 && LitMica > 0 && LitMare > 0)
                        System.out.println("We need 1 changes to make a strong password");
                    else if (Cifre == 0 && LitMica == 0 && LitMare > 0)
                        System.out.println("We need 2 changes to make a strong password");
                    else if (Cifre == 0 && LitMica > 0 && LitMare == 0)
                        System.out.println("We need 2 changes to make a strong password");
                    else if (Cifre > 0 && LitMica == 0 && LitMare == 0)
                        System.out.println("We need 2 changes to make a strong password");
                }
                else {     // cazul in care avem un ciclu sau 2 de 3 caractere identice consecutive
                    if (Cifre > 0 && LitMica > 0 && LitMare == 0)
                        System.out.println("We need 1 changes to make a strong password");
                    else if (Cifre > 0 && LitMica == 0 && LitMare > 0)
                        System.out.println("We need 1 changes to make a strong password");
                    else if (Cifre == 0 && LitMica > 0 && LitMare > 0)
                        System.out.println("We need 1 changes to make a strong password");
                    else if (Cifre == 0 && LitMica == 0 && LitMare > 0)
                        System.out.println("We need 2 changes to make a strong password");
                    else if (Cifre == 0 && LitMica > 0 && LitMare == 0)
                        System.out.println("We need 2 changes to make a strong password");
                    else if (Cifre > 0 && LitMica == 0 && LitMare == 0)
                        System.out.println("We need 2 changes to make a strong password");
                    else
                        System.out.println("We need 1 changes to make a strong password");
                }
            }
        else { // cazul in care lungimea nu este corecta
            if (array.length < 6) { // cazul in care lungimea este prea mica
                n = 6 - array.length;
                if (treiLaFel > n) { // cazul in care avem 2 cicluri in 5 litere
                    if (Cifre == 0 && LitMica == 0 && LitMare > 0)
                            System.out.println("We need " + treiLaFel + " changes to make a strong password");
                    else if (Cifre == 0 && LitMica > 0 && LitMare == 0)
                            System.out.println("We need " + treiLaFel + " changes to make a strong password");
                    else if (Cifre > 0 && LitMica == 0 && LitMare == 0)
                            System.out.println("We need " + treiLaFel + " changes to make a strong password");
                    else
                            System.out.println("We need " + treiLaFel + " changes to make a strong password");
                    }
                else { //cazul in care avem unul sau nici un ciclu
                    if (Cifre > 0 && LitMica > 0 && LitMare == 0)
                            System.out.println("We need " + n + " changes to make a strong password");
                    else if (Cifre > 0 && LitMica == 0 && LitMare > 0)
                            System.out.println("We need " + n + " changes to make a strong password");
                    else if (Cifre == 0 && LitMica > 0 && LitMare > 0)
                            System.out.println("We need " + n + " changes to make a strong password");
                    else if (Cifre == 0 && LitMica == 0 && LitMare > 0)
                        if (n > 1)
                                System.out.println("We need " + n + " changes to make a strong password");
                        else
                                System.out.println("We need 2 changes to make a strong password");
                    else if (Cifre == 0 && LitMica > 0 && LitMare == 0)
                            if (n > 1)
                                System.out.println("We need " + n + " changes to make a strong password");
                            else
                                System.out.println("We need 2 changes to make a strong password");
                    else if (Cifre > 0 && LitMica == 0 && LitMare == 0)
                            if (n > 1)
                                System.out.println("We need " + n + " changes to make a strong password");
                            else
                                System.out.println("We need 2 changes to make a strong password");
                    else
                            System.out.println("We need " + n + " changes to make a strong password");
                }
            }
            else { // cazul in care lungimea este prea mare
                    n = array.length - 20;
                    if (treiLaFel > n) { // cazul in care numarul de cicluri este mai mare decat numarul de caractere care trebuie sterse
                        if (Cifre > 0 && LitMica > 0 && LitMare == 0)
                            System.out.println("We need " + (treiLaFel - 1) + " changes to make a strong password");
                        else if (Cifre > 0 && LitMica == 0 && LitMare > 0)
                            System.out.println("We need " + (treiLaFel - 1) + " changes to make a strong password");
                        else if (Cifre == 0 && LitMica > 0 && LitMare > 0)
                            System.out.println("We need " + (treiLaFel - 1) + " changes to make a strong password");
                        else if (Cifre == 0 && LitMica == 0 && LitMare > 0) {
                            if (treiLaFel - n > 1)
                                System.out.println("We need " + (treiLaFel - 2) + " changes to make a strong password");
                            else
                                System.out.println("We need " + (treiLaFel + 1) + " changes to make a strong password");
                        } else if (Cifre == 0 && LitMica > 0 && LitMare == 0) {
                            if (treiLaFel - n > 1)
                                System.out.println("We need " + (treiLaFel - 2) + " changes to make a strong password");
                            else
                                System.out.println("We need " + (treiLaFel + 1) + " changes to make a strong password");
                        } else if (Cifre > 0 && LitMica == 0 && LitMare == 0) {
                            if (treiLaFel - n > 1)
                                System.out.println("We need " + (treiLaFel - 2) + " changes to make a strong password");
                            else
                                System.out.println("We need " + (treiLaFel + 1) + " changes to make a strong password");
                        } else
                            System.out.println("We need " + treiLaFel + " changes to make a strong password");
                    }
                    else { // cazul in care numarul de cicluri este mai mic decat numarul de caractere care trebuie sterse
                        if (Cifre > 0 && LitMica > 0 && LitMare == 0)
                            System.out.println("We need " + (n + 1) + " changes to make a strong password");
                        else if (Cifre > 0 && LitMica == 0 && LitMare > 0)
                            System.out.println("We need " + (n + 1) + " changes to make a strong password");
                        else if (Cifre == 0 && LitMica > 0 && LitMare > 0)
                            System.out.println("We need " + (n + 1) + " changes to make a strong password");
                        else if (Cifre == 0 && LitMica == 0 && LitMare > 0)
                            System.out.println("We need " + (n + 2) + " changes to make a strong password");
                        else if (Cifre == 0 && LitMica > 0 && LitMare == 0)
                            System.out.println("We need " + (n + 2) + " changes to make a strong password");
                        else if (Cifre > 0 && LitMica == 0 && LitMare == 0)
                            System.out.println("We need " + (n + 2) + " changes to make a strong password");
                        else
                            System.out.println("We need " + n + " changes to make a strong password");
                    }
                }
            }
        }
    }

