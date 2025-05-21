package com.example.estudiantes.model;

public class Estudiante {
    private int id;
    private String nombre;
    private int edad;

    public Estudiante(int id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;

    }

    public int getId() {return id; }
    public String getNombre() {return nombre; }
    public int getEdad() {return edad; }

    @Override
    public String toString() {
        return "Estudiantes[id =" + id + ",nombre = " + nombre + ", edad = " + edad + "]";
    }
}
