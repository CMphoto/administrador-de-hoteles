/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yonosek;

import java.util.*;

/**
 *
 * @author franc
 */
public class Piso {
    private String codigo;
    private Hotel hotel;
    protected TreeMap<String, Habitacion> habitacionesPiso;
    private boolean estaHabilitada;

    
    public Piso(){
        this.habitacionesPiso = new TreeMap<>();
    }
    
    public Piso(String codigo, Hotel hotel, boolean estaHabilitado){
        this.habitacionesPiso = new TreeMap<>();
        this.codigo = codigo;
        this.hotel = hotel;
        this.estaHabilitada = estaHabilitado;
    }

    public TreeMap<String, Habitacion> getHabitacionesPiso() {
        return habitacionesPiso;
    }

    public void setHabitacionesPiso(TreeMap<String, Habitacion> habitacionesPiso) {
        this.habitacionesPiso = habitacionesPiso;
    }
    

    
    public boolean isEstaHabilitada() {
        return estaHabilitada;
    }

    public void setEstaHabilitada(boolean estaHabilitada) {
        this.estaHabilitada = estaHabilitada;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Piso{" + "hotel=" + hotel + ", habitacionesPiso=" + habitacionesPiso + ", estaHabilitada=" + estaHabilitada + '}';
    }
    
    

        //PARA MANEJAR HABITACIONES
    /**
     * Agrega una habitacion
     * @param claveHabitacion
     * @param habitacion
     * @throws java.lang.Exception
     */
    public void agregarHabitacion(String claveHabitacion, Habitacion habitacion) {
        if (!this.habitacionesPiso.containsKey(claveHabitacion)){
            this.habitacionesPiso.put(claveHabitacion, habitacion);
        }else{
            System.err.println("La habitacion ya se encuentra registrado");
        }
    }

    /**
     * Remueve una Habitacion
     * @param claveHabitacion
     */
    public void removerHabitacion(String claveHabitacion) {
        if (this.habitacionesPiso.containsKey(claveHabitacion)) {
            this.habitacionesPiso.remove(claveHabitacion);
        } 
        else {
            System.err.println("No hay registros de la habitacion");
        }
    }

    /**
     * Muestra ka informacion de una habitacion 
     */
    public void mostrarHabitacion() {
        for (Map.Entry <String, Habitacion> habitacion : this.habitacionesPiso.entrySet()) {
            String clave = habitacion.getKey();
            Habitacion valor = habitacion.getValue();
            System.out.println(clave + "  ->  " + valor.getPrecioHabitacion());
        }
    }
    /**
     * Busca una habitacion en especifico
     * @param hab
     * @return 
     */
    public Habitacion buscarHabitacion(String hab){
        for (Map.Entry <String, Habitacion> habitacion : this.habitacionesPiso.entrySet()) {
            if((hab.equals(habitacion.getValue().getCodigoHab()))) {
                System.out.println("Habitacion encontrada");
                return habitacion.getValue();
            }
        }
        return null;
}
    /**
     * Muestra las habitaciones disponible
     */
    public void mostrarHabitacionDiponibles(){
        for (Map.Entry <String, Habitacion> habitacion : this.habitacionesPiso.entrySet()) {
            if(habitacion.getValue().isEstaDisponible() && habitacion.getValue().isEstaHabilitada() ){
                String clave = habitacion.getKey();
                Habitacion valor = habitacion.getValue();
                System.out.print(clave + "\t");
                }
        }
        System.out.println("\n");
    }
    /**
     * Incrementa el 10% al precio de una habitacion
     */
    public void setNuevoPrecioTodasHabitaciones(){
        float nuevoPrecio;
        for (Map.Entry <String, Habitacion> habitacion : this.habitacionesPiso.entrySet()) {
            nuevoPrecio = (habitacion.getValue().getPrecioHabitacion() *1.1f);
            habitacion.getValue().setPrecioHabitacion(nuevoPrecio);
        }
    }
    /**
     * 
     */
    public void setPrecioTodasHabitaciones(){
        float nuevoPrecio;
        for (Map.Entry <String, Habitacion> habitacion : this.habitacionesPiso.entrySet()) {
            nuevoPrecio = (habitacion.getValue().getPrecioHabitacion());
            habitacion.getValue().setPrecioHabitacion(nuevoPrecio);
        }
    }
}
