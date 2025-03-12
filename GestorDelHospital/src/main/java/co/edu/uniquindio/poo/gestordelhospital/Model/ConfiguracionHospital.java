package co.edu.uniquindio.poo.gestordelhospital.Model;

import java.time.LocalDate;

public class ConfiguracionHospital {
    public LocalDate horarioAtencion;
    public int numeroMaxPacientes;
    public String reglasFactura;

    //Instancia unica en la clase Configuracion

    private static ConfiguracionHospital instancia;

    //Constructor Privado

    private ConfiguracionHospital() {
    }

    //metodo estatico que devuelve la unica instancia

    public static ConfiguracionHospital getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracionHospital();
        }
        return instancia;
    }

    public void configurarHospital() {}


}