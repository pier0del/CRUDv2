package com.example.estudiantes.app;
import com.example.estudiantes.model.Estudiante;
import com.example.estudiantes.service.EstudianteService;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final EstudianteService service = new EstudianteService();

    public static void main(String[] args) {
        int opcion;
        do{
            mostrarMenu();
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1 -> agregarEstudiante();
                case 2 -> listarEstudiante();
                case 3 -> buscarEstudiante();
                case 4 -> eliminarEstudiante();
                case 5 -> System.out.println("FIN DEL PROGRAMA");
                default -> System.out.println("opcion invalida.");
            }

        } while (opcion != 5);
    }

    private static void mostrarMenu() {
        System.out.println("""
                === MENU ESTUDIANTES ===
                1. Agregar nuevo estudiante
                2. LIstar todos los estudiantes
                3. BuscarEstudiante por id
                4. Eliminar estudiante por id
                5. Salir del programa
                ==========================
                Elije una opcion: """);
    }
    private static void agregarEstudiante() {
        System.out.print("id: ");
        int id = Integer.parseInt(sc.nextLine());
        String nombre = sc.nextLine();
        System.out.print("Edad: ");
        int edad = Integer.parseInt(sc.nextLine());
        service.agregar(new Estudiante(id, nombre, edad));
        System.out.println("Estudiante agregado..");

    }

    private static void listarEstudiante() {
        List<Estudiante> todos = service.listar();
        if( todos.isEmpty()) {
            System.out.println("No hay estudiantes");
        } else {
            todos.forEach(System.out::println);
            System.out.println();

            }
        }
        private static void buscarEstudiante() {
            System.out.print("Id a buscar: ");
            int id = Integer.parseInt(sc.nextLine());
            Optional<Estudiante> encontrado = service.buscarPorId(id);
            System.out.println(encontrado
                    .map(System.out::println)
                    .orElse("estudiante no encontrado.") + "\n");

    }

        private static void eliminarEstudiante() {
            System.out.print("ID a eliminar: ");
            int id = Integer.parseInt(sc.nextLine());
            boolean ok = service.eliminarPorId(id);
            System.out.println(ok
                ? "Estudiante eliminado.\n"
                : "No se encontro el estudiante.\n");
    }
}