package org.greyes.ejerciciorepaso.lamdatarea;

public class TareaLambda {
    public static void main(String[] args) {

        ProcesarFrase convertir = frase -> frase
                .replace(" ", "")
                .replace(",", "")
                .replace(".", "")
                .toUpperCase();

        String texto = "Tarea repaso digital trainee, sabado 13 sept. ";
        String resultado = convertir.procesar(texto);

        System.out.println("Frase: " + resultado);
    }
}
