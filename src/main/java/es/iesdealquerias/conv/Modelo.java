/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.iesdealquerias.conv;

/**
 *
 * @author jv
 */
public class Modelo {

    private final static int TEMPERATURA = (int) (Math.random() * 100);

    public int sumar(int cantidad) {
        return TEMPERATURA + cantidad;
    }

    public int restar(int cantidad) {
        return TEMPERATURA - cantidad;
    }

    public int consultar() {
        return TEMPERATURA;
    }
}
