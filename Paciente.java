public class Paciente implements Comparable<Paciente> {
    private String nombre;
    private String sintoma;
    private char prioridad;

    // Constructor
    public Paciente(String nombre, String sintoma, char prioridad) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.prioridad = prioridad;
    }

    // Método para comparar pacientes según la prioridad
    @Override
    public int compareTo(Paciente otro) {
        return this.prioridad - otro.prioridad;
    }

    // Método para imprimir información del paciente
    public void imprimirInformacion() {
        System.out.println(nombre + ", " + sintoma + ", " + prioridad);
    }
}
