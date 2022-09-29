/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.iesdealquerias.conv;

/**
 *
 * @author jv
 */
public class Controlador {

    private Modelo modelo;
    private Vista vista;

    public Controlador() {
        modelo = new Modelo();
        vista = new Vista(this);
    }

    public static void main(String[] args) {
//        args = new String[]{"-r", "100"};
//        args = new String[]{"-r", "1"};
//        args = new String[]{"-s", "100"};
//        args = new String[]{"-s", "1"};
//        args = new String[]{"", ""};
        Controlador ctrl = new Controlador();
        ctrl.inciarVista(args);
    }

    private void inciarVista(String[] args) {
        vista.convertir(args);
    }

    void annadirTemp(int calentamiento) {
        int temperatura = modelo.sumar(calentamiento);
        vista.showTemperatura(temperatura);
    }

    void substaerTemp(int enfriamiento) {
        int temperatura = modelo.restar(enfriamiento);
        vista.showTemperatura(temperatura);
    }

    void consultarTemp() {
        vista.showTemperatura(modelo.consultar());
    }

}
