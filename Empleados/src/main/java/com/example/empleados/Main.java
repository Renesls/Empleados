package com.example.empleados;

import com.example.empleados.model.Cargo;
import com.example.empleados.model.Empleado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

/**
 * Clase principal para ejecutar la aplicación de gestión de empleados
 */
public class Main {
    
    public static void main(String[] args) {
        // Crear el EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmpleadosPU");
        EntityManager em = emf.createEntityManager();
        
        try {
            // Iniciar transacción
            em.getTransaction().begin();
            
            // 1. Crear y guardar un cargo
            Cargo cargo = new Cargo();
            cargo.setNombre("Desarrollador");
            cargo.setDescripcion("Desarrollo de software");
            cargo.setSalarioBase(3500.0);
            cargo.setDepartamento("Tecnología");
            em.persist(cargo);
            System.out.println("Cargo guardado: " + cargo.getNombre());
            
            // 2. Crear y guardar un empleado
            Empleado empleado = new Empleado();
            empleado.setNombre("Rene");
            empleado.setApellido("Sandoval");
            empleado.setDni("23021709");
            empleado.setEmail("Renesl@empresa.com");
            empleado.setTelefono("78939934");
            empleado.setFechaNacimiento(LocalDate.of(1990, 5, 15));
            empleado.setFechaContratacion(LocalDate.now());
            empleado.setActivo(true);
            empleado.setDireccion("Calle Principal 123");
            em.persist(empleado);
            System.out.println("Empleado guardado: " + empleado.getNombre() + " " + empleado.getApellido());
            
            empleado.setCargo(cargo);
            em.merge(empleado);
            System.out.println("Asignación creada: " + empleado.getNombre() + " -> " + cargo.getNombre());
            System.out.println("Empleado " + empleado.getNombre() + " asignado a " + cargo.getNombre());
            
            em.getTransaction().commit();
            
            System.out.println("\n¡Proceso completado exitosamente!");
            
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}

