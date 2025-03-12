
package co.edu.uniquindio.poo.gestordelhospital.Model;

import java.util.LinkedList;

public class Paciente extends Persona implements Cloneable{


    public Paciente(String nombre, String cedula, int edad) {
        super(nombre, edad, cedula);
    }

    @Override
    public Paciente clone() {
        try {
            return (Paciente) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("El paciente no puede ser clonado");
        }
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "cedula='" + cedula + '\'' +
                ", edad=" + edad +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}