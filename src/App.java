import alumno.Alumno;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        var alumnos = new ArrayList<Alumno>();
        Alumno alumnoActual = null;

        menuPrincipal(alumnos, alumnoActual);
    }

    public static void menuPrincipal(ArrayList<Alumno> alumnos, Alumno alumnoActual){
        int opcion;

        do {
            System.out.printf("""
                    === SISTEMA DE CALIFICACIONES ===
                        1. Agregar alumno
                        2. Mostrar alumnos
                        3. Seleccionar alumno
                        4. salir
                        Selecciona una opción:
                    """);
            opcion = Integer.parseInt(scan.nextLine());

            switch (opcion){
                case 1 ->{
                    System.out.print("Nombre del nuevo alumno: ");
                    var nombre = scan.nextLine();
                    System.out.print("Apellido del alumno: ");
                    var apellido = scan.nextLine();

                    alumnos.add(new Alumno(nombre,apellido));
                    System.out.println("Alumno agregado correctamente");
                }
                case 2 ->{
                    if (alumnos.isEmpty()){
                        System.out.println("Todavía no has agregado alumnos");
                    }
                    else {
                        for(Alumno alumno : alumnos){
                            System.out.printf("-%s %s %n", alumno.getNombre(), alumno.getApellido());
                        }
                    }
                }
                case 3 ->{
                    if (alumnos.isEmpty()){
                        System.out.println("Todavía no hay alumnos agregados");
                    }
                    else {
                        System.out.println("=== Alumnos ===");
                        for (var i = 0; i < alumnos.size(); i++){
                            Alumno alumno = alumnos.get(i);
                            System.out.printf("%d. %s %s%n", i+1, alumno.getNombre(), alumno.getApellido());
                        }
                        System.out.print("Seleccione el numero del alumno: ");
                        var numAlumno = Integer.parseInt(scan.nextLine());

                        if(numAlumno<1 || numAlumno > alumnos.size()){
                            System.out.println("Opcion invalida");
                            break;
                        }
                        alumnoActual = alumnos.get(numAlumno-1);
                        System.out.printf("Alumno seleccionado: %s %s %n", alumnoActual.getNombre(), alumnoActual.getApellido());
                        menuMaterias(alumnoActual);
                    }
                }
                case 4 -> {
                    System.out.println("Hasta luego :)");
                }
                default -> System.out.println("Opcion invalida, intente de nuevo");
            }
        }while (opcion !=4);
    }

    public static void menuMaterias(Alumno alumnoActual){

        int opcion;

        do {
            System.out.printf("Materias Alumno: %s %s %n", alumnoActual.getNombre(), alumnoActual.getApellido());
            System.out.printf("""
                    1. Agregar materia
                    2. Mostrar materias
                    3. ver promedio
                    4. regresar
                    Seleccione una opción:
                    """);
            opcion = Integer.parseInt(scan.nextLine());

            switch (opcion){
                case 1 ->{
                    System.out.print("Nombre de la materia: ");
                    var materia = scan.nextLine();
                    System.out.print("Calificación de la materia: ");
                    var calificacion = Double.parseDouble(scan.nextLine());

                    alumnoActual.agregarMateria(materia,calificacion);

                    System.out.println("Materia agregada correctamente");
                }
                case 2 -> alumnoActual.mostrarMaterias();
                case 3 -> {
                    var promedio = alumnoActual.promedio();
                    System.out.printf("""
                            Alumno: %s %s
                            Promedio: %.1f
                            """, alumnoActual.getNombre(), alumnoActual.getApellido(), promedio);
                }
                case 4 -> System.out.println("Regresando al menu principal");
                default -> System.out.println("Opción invalida");
            }

        }while (opcion !=4);
    }
}
