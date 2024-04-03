import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        // Crear una cola de prioridad de pacientes
        PriorityQueue<Paciente> colaPrioridad = new PriorityQueue<>();

        // Leer el archivo de pacientes y agregarlos a la cola de prioridad
        try {
            File file = new File("pacientes.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] datos = scanner.nextLine().split(",");
                Paciente paciente = new Paciente(datos[0].trim(), datos[1].trim(), Character.toUpperCase(datos[2].trim().charAt(0)));
                colaPrioridad.add(paciente);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + e.getMessage());
        }

        // Menú para interactuar con el sistema de atención de pacientes
        Scanner input = new Scanner(System.in);
        boolean continuar = true;
        while (continuar) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Insertar paciente");
            System.out.println("2. Atender paciente");
            System.out.println("3. Mostrar orden de atención de pacientes");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            int opcion = input.nextInt();
            switch (opcion) {
                case 1:
                    input.nextLine(); // Limpiar el buffer del teclado
                    System.out.print("Ingrese el nombre del paciente: ");
                    String nombre = input.nextLine();
                    System.out.print("Ingrese el síntoma del paciente: ");
                    String sintoma = input.nextLine();
                    System.out.print("Ingrese la prioridad del paciente (A-E): ");
                    char prioridad = Character.toUpperCase(input.next().charAt(0)); // Convertir a mayúscula
                    Paciente nuevoPaciente = new Paciente(nombre, sintoma, prioridad);
                    colaPrioridad.add(nuevoPaciente);
                    System.out.println("Paciente insertado correctamente.");
                    break;
                case 2:
                    if (!colaPrioridad.isEmpty()) {
                        Paciente pacienteAtendido = colaPrioridad.poll();
                        System.out.println("Paciente atendido:");
                        pacienteAtendido.imprimirInformacion();
                    } else {
                        System.out.println("La cola de pacientes está vacía.");
                    }
                    break;
                case 3:
                    System.out.println("Orden de atención de pacientes:");
                    PriorityQueue<Paciente> colaCopia = new PriorityQueue<>(colaPrioridad);
                    while (!colaCopia.isEmpty()) {
                        Paciente siguientePaciente = colaCopia.poll();
                        siguientePaciente.imprimirInformacion();
                    }
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
        input.close();
    }
}

class Paciente implements Comparable<Paciente> {
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
