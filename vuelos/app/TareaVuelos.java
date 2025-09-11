package org.digital.vuelos.app;

import org.digital.vuelos.modelo.Vuelo;


import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TareaVuelos {
    public static void main(String[] args) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        List<Vuelo> llegadas = cargarVuelos(formatter);


        System.out.println("=== Listado ordenado por fecha de llegada ascendente ===");
        imprimirOrdenadosPorFecha(llegadas);


        System.out.println("\n=== Último vuelo en llegar ===");
        Vuelo ultimo = obtenerUltimoVuelo(llegadas);

        System.out.printf("El último vuelo en llegar es: %s : %s, aterriza el %s%n",
                ultimo.getNombre(), ultimo.getOrigen(), ultimo.getFechaLLegada().format(formatter));


        System.out.println("\n=== Vuelo con menor número de pasajeros ===");
        Vuelo menor = obtenerVueloMenosPasajeros(llegadas);
        System.out.printf("El vuelo con menor número de pasajeros es: %s : %s, con %d pasajeros.%n",
                menor.getNombre(), menor.getOrigen(), menor.getPasajeros());
    }

    private static List<Vuelo> cargarVuelos(DateTimeFormatter f) {
        return Arrays.asList(
                new Vuelo("AAL 933","New York","Santiago", LocalDateTime.parse("2021-08-29 05:39",f),62),
                new Vuelo("LAT 755","Sao Paulo","Santiago",LocalDateTime.parse("2021-08-31 04:45",f),47),
                new Vuelo("SKU 621","Rio De Janeiro","Santiago",LocalDateTime.parse("2021-08-30 16:00",f),52),
                new Vuelo("DAL 147","Atlanta","Santiago",LocalDateTime.parse("2021-08-29 13:22",f),59),
                new Vuelo("AVA 241","Bogota","Santiago",LocalDateTime.parse("2021-08-31 14:05",f),25),
                new Vuelo("AMX 10","Mexico City","Santiago",LocalDateTime.parse("2021-08-31 05:20",f),29),
                new Vuelo("IBE 6833","Londres","Santiago",LocalDateTime.parse("2021-08-30 08:45",f),55),
                new Vuelo("LAT 2479","Frankfurt","Santiago",LocalDateTime.parse("2021-08-29 07:41",f),51),
                new Vuelo("SKU 803","Lima","Santiago",LocalDateTime.parse("2021-08-30 10:35",f),48),
                new Vuelo("LAT 533","Los Ángeles","Santiago",LocalDateTime.parse("2021-08-29 09:14",f),59),
                new Vuelo("LAT 1447","Guayaquil","Santiago",LocalDateTime.parse("2021-08-31 08:33",f),31),
                new Vuelo("CMP 111","Panama City","Santiago",LocalDateTime.parse("2021-08-31 15:15",f),29),
                new Vuelo("LAT 705","Madrid","Santiago",LocalDateTime.parse("2021-08-30 08:14",f),47),
                new Vuelo("AAL 957","Miami","Santiago",LocalDateTime.parse("2021-08-29 22:53",f),60),
                new Vuelo("ARG 5091","Buenos Aires","Santiago",LocalDateTime.parse("2021-08-31 09:57",f),32),
                new Vuelo("LAT 1283","Cancún","Santiago",LocalDateTime.parse("2021-08-31 04:00",f),35),
                new Vuelo("LAT 579","Barcelona","Santiago",LocalDateTime.parse("2021-08-29 07:45",f),61),
                new Vuelo("AAL 945","Dallas-Fort Worth","Santiago",LocalDateTime.parse("2021-08-30 07:12",f),58),
                new Vuelo("LAT 501","París","Santiago",LocalDateTime.parse("2021-08-29 18:29",f),49),
                new Vuelo("LAT 405","Montevideo","Santiago",LocalDateTime.parse("2021-08-30 15:45",f),39)
        );
    }

    private static void imprimirOrdenadosPorFecha(List<Vuelo> vuelos) {
        vuelos.stream()
                .sorted(Comparator.comparing(Vuelo::getFechaLLegada))
                .forEach(System.out::println);
    }

    private static Vuelo obtenerUltimoVuelo(List<Vuelo> vuelos) {
        return vuelos.stream()
                .max(Comparator.comparing(Vuelo::getFechaLLegada))
                .orElseThrow();
    }

    private static Vuelo obtenerVueloMenosPasajeros(List<Vuelo> vuelos) {
        return vuelos.stream()
                .min(Comparator.comparing(Vuelo::getPasajeros))
                .orElseThrow();
    }
}
