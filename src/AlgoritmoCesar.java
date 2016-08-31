/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo-Ideapad
 */
public class AlgoritmoCesar {

    int Cesar = 3;

    public String descifrar(String mensaje) {
        String cadena1 = "";
        String cadena2 = "";
        String cadena3 = "";
        String msjDescifrado = "";
        String cadena = mensaje;
//        cadena1 = cadena.substring(0, cadena.length() / 3 * 1);
//            cadena2 = cadena.substring(cadena.length() / 3 * 1+(cadena.length() % 3), cadena.length() / 3 * 2);
//            cadena3 = cadena.substring(cadena.length() / 3 * 2, cadena.length());
     
        if (cadena.length() % 3 == 0) {
            cadena1 = cadena.substring(0, cadena.length() / 3 * 1);
            cadena2 = cadena.substring(cadena.length() / 3 * 1, cadena.length() / 3 * 2);
            cadena3 = cadena.substring(cadena.length() / 3 * 2, cadena.length());
        } else if (cadena.length() % 3 == 1) {
            cadena1 = cadena.substring(0, (cadena.length() / 3) * 1 + 1);
            cadena2 = cadena.substring((cadena.length() / 3) * 1 + 1, (cadena.length() / 3) * 2 + 1);
            cadena3 = cadena.substring((cadena.length() / 3) * 2 + 1, cadena.length());

        } else if (cadena.length() % 3 == 2) {
            cadena1 = cadena.substring(0, (cadena.length() / 3) * 1 + 1);
            cadena2 = cadena.substring((cadena.length() / 3 * 1) + 1, (cadena.length() / 3) * 2 + 2);
            cadena3 = cadena.substring((cadena.length() / 3) * 2 + 2, cadena.length());
        }
        for (int i = 0; i < cadena1.length(); i++) {
            if (i < cadena1.length()) {
                msjDescifrado = msjDescifrado + caracter(String.valueOf((char) (cadena1.codePointAt(i) - this.Cesar)));
            }
            if (i < cadena2.length()) {
                msjDescifrado = msjDescifrado + caracter(String.valueOf((char) (cadena2.codePointAt(i) - this.Cesar)));
            }
            if (i < cadena3.length()) {
                msjDescifrado = msjDescifrado + caracter(String.valueOf((char) (cadena3.codePointAt(i) - this.Cesar)));
            }
        }
        return msjDescifrado;
    }

    public String cifrar(String mensaje) {
        String msjCifrado = "";
        String cadena1 = "";
        String cadena2 = "";
        String cadena3 = "";
        String cadena = mensaje;

        for (int i = 0; i < cadena.length(); i++) {
            msjCifrado = msjCifrado + caracter(String.valueOf((char) (cadena.codePointAt(i) + this.Cesar)));
        }

        for (int i = 0; i < msjCifrado.length(); i++) {
            int div = i % 3;
            switch (div) {
                case 0:
                    cadena1 = cadena1 + caracter2(msjCifrado.substring(i, i + 1));
                    break;
                case 1:
                    cadena2 = cadena2 + caracter2(msjCifrado.substring(i, i + 1));
                    break;
                case 2:
                    cadena3 = cadena3 + caracter2(msjCifrado.substring(i, i + 1));
            }
        }
        return cadena1 + cadena2 + cadena3;
    }

    private String caracter(String sCaracter) {
        switch (sCaracter) {
            case "?":
                sCaracter = "Y";
                break;
            case "\\":
                sCaracter = " ";
                break;
            case ">":
                sCaracter = "X";
                break;
            case "#":
                sCaracter = "_";
                break;
            default:
                break;
        }
        return sCaracter;
    }

    private String caracter2(String sCaracter) {
        switch (sCaracter) {
            case " ":
                sCaracter = "B";
                break;
            case "#":
                sCaracter = "_";
                break;
            case "]":
                sCaracter = "C";
                break;
            case "[":
                sCaracter = "A";
                break;
            default:
                break;
        }
        return sCaracter;
    }
}
