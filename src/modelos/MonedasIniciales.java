package modelos;


import java.util.*;

public class MonedasIniciales {
    private List<String> listaMonedas = new ArrayList<>();

    public MonedasIniciales(){
        this.listaMonedas.add("ARS");
        this.listaMonedas.add("BOB");
        this.listaMonedas.add("BRL");
        this.listaMonedas.add("CLP");
        this.listaMonedas.add("COP");
    }
    public void imprimirListaMonedas() {
        int indice = 1;
        for (String moneda : listaMonedas) {
            System.out.println(indice + " " + moneda);
            indice++;
        }
    }

    public String seleccionar(int indice){
        return listaMonedas.get(indice-1);
    }

}
