package com.mycompany.laboratorio2_oyecutey;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yecut
 */
import java.io.*;
import java.util.*;

public class ArchivoActividades {

    private static final String RUTA = "actividades.txt";

    public static void guardarActividad(String[] actividad) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(RUTA, true))) {
            pw.println(String.join("|", actividad));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String[]> cargarActividades() {
        List<String[]> lista = new ArrayList<>();

        File archivo = new File(RUTA);

        if (!archivo.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(RUTA))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                lista.add(linea.split("\\|"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lista;
    }
    public static void eliminarActividad(int index) {
    List<String[]> lista = cargarActividades();

    if (index >= 0 && index < lista.size()) {
        lista.remove(index);

        try (PrintWriter pw = new PrintWriter(new FileWriter(RUTA))) {
            for (String[] a : lista) {
                pw.println(String.join("|", a));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
    public static void guardarLista(List<String[]> lista) {
    try (PrintWriter pw = new PrintWriter(new FileWriter(RUTA))) {
        for (String[] a : lista) {
            pw.println(String.join("|", a));
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}

