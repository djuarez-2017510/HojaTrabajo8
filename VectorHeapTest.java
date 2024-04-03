import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VectorHeapTest {
    
 
    @Test
    public void testInsertarElemento() {
        VectorHeap<Paciente> colaPrioridad = new VectorHeap<>();
        
        // Insertar pacientes en orden de prioridad
        Paciente paciente1 = new Paciente("Juan", "Dolor de cabeza", 'C');
        Paciente paciente2 = new Paciente("Maria", "Fractura", 'A');
        Paciente paciente3 = new Paciente("Pedro", "Fiebre", 'B');
        Paciente paciente4 = new Paciente("Ana", "Gripe", 'D');
        
        colaPrioridad.add(paciente1);
        colaPrioridad.add(paciente2);
        colaPrioridad.add(paciente3);
        colaPrioridad.add(paciente4);
        
        // Comprobar si la cola de prioridad no está vacía
        assertFalse(colaPrioridad.isEmpty());
        
        // Comprobar el tamaño de la cola de prioridad
        assertEquals(4, colaPrioridad.size());
        
        // Comprobar el orden de atención
        assertEquals(paciente2, colaPrioridad.peek()); // Prioridad A
    }
    
    @Test
    public void testRetirarElemento() {
        VectorHeap<Paciente> colaPrioridad = new VectorHeap<>();
        
        // Insertar pacientes en orden de prioridad
        Paciente paciente1 = new Paciente("Juan", "Dolor de cabeza", 'C');
        Paciente paciente2 = new Paciente("Maria", "Fractura", 'A');
        Paciente paciente3 = new Paciente("Pedro", "Fiebre", 'B');
        Paciente paciente4 = new Paciente("Ana", "Gripe", 'D');
        
        colaPrioridad.add(paciente1);
        colaPrioridad.add(paciente2);
        colaPrioridad.add(paciente3);
        colaPrioridad.add(paciente4);
        
        // Retirar pacientes y verificar el orden de atención
        assertEquals(paciente2, colaPrioridad.poll()); // Prioridad A
        assertEquals(paciente3, colaPrioridad.poll()); // Prioridad B
        assertEquals(paciente1, colaPrioridad.poll()); // Prioridad C
        assertEquals(paciente4, colaPrioridad.poll()); // Prioridad D
        
        // Comprobar si la cola de prioridad está vacía después de retirar todos los elementos
        assertTrue(colaPrioridad.isEmpty());
    }

}
