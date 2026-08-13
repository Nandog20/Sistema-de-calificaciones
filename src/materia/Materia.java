package materia;

public class Materia {
    private String materia;
    private double calificacion;

    public Materia(String materia, double calificacion){
        this.materia = materia;
        this.calificacion = calificacion;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }


}
