package alumno;

import materia.Materia;

import java.util.ArrayList;

public class Alumno {
    private String nombre;
    private String apellido;
    private ArrayList <Materia> materias;

    public Alumno(String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
        this.materias = new ArrayList<>();
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void agregarMateria(String materia, double calificacion){
        this.materias.add(new Materia(materia,calificacion));
    }

    public void mostrarMaterias(){
        if(materias.isEmpty()){
            System.out.printf("El alumno %s %s no tiene materias %n", this.nombre, this.apellido);
        }
        else {
            for(Materia materia: materias){
                System.out.printf("-Materia: %s: %.1f%n",materia.getMateria(), materia.getCalificacion());
            }
        }
    }

    public double promedio(){

        double promedio = 0;

        if(!this.materias.isEmpty()){
            double suma = 0;

            for (Materia materia : materias){
                suma += materia.getCalificacion();
            }

            promedio = suma/materias.size();
        }

        return promedio;
    }
}
