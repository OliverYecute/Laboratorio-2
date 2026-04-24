/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laboratorio2_oyecutey;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ArchivoUsuarios {

    private static final String RUTA = "usuarios.txt";

    public static void guardarUsuarios(List<String[]> usuarios) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(RUTA))) {
            for (String[] u : usuarios) {
                pw.println(u[0] + "|" + u[1] + "|" + u[2] + "|" + u[3] + "|" + u[4]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String[]> cargarUsuarios() {
        List<String[]> usuarios = new ArrayList<>();

        File archivo = new File(RUTA);

        if (!archivo.exists()) {
            return usuarios;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(RUTA))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("\\|");

                if (datos.length == 5) {
                    usuarios.add(datos);
                }
            }

        } catch (IOException e) {
    JOptionPane.showMessageDialog(null, "Error al guardar usuarios");
    }

        return usuarios;
    }
}

/**
 *
 * @author yecut
 */

