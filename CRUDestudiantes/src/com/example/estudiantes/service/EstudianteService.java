package com.example.estudiantes.service;
import com.example.estudiantes.model.Estudiante;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class EstudianteService {
    private final List<Estudiante> lista = new ArrayList<>();
    public void agregar(Estudiante e) {
        lista.add(e);
    }


    public List<Estudiante> listar(){
        return new ArrayList<>(lista);
    }

    public Optional<Estudiante> buscarPorId(int id) {
        return lista.stream().filter(e -> e.getId() == id).findFirst();
    }

    public boolean eliminarPorId(int id) {
        return lista.removeIf(e -> e.getId() == id);
    }

}