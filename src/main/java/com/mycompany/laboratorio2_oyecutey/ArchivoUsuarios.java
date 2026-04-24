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
            JOptionPane.showMessageDialog(null, "Error al cargar usuarios");
        }

        return usuarios;
    }

    
    public static boolean cambiarClave(String usuarioBuscado, String nuevaClave) {
    List<String[]> usuarios = cargarUsuarios();
    boolean encontrado = false;

    for (String[] u : usuarios) {
        if (u[1].equals(usuarioBuscado)) {
            u[4] = nuevaClave;
            encontrado = true;
            break;
        }
    }

    if (encontrado) {
        guardarUsuarios(usuarios);
    }

    return encontrado;
}

public static String[] buscarUsuario(String usuarioBuscado) {
    for (String[] u : cargarUsuarios()) {
        if (u[1].equalsIgnoreCase(usuarioBuscado)) {
            return u;
        }
    }
    return null;
    }
}
/**
 *
 * @author yecut
 */

