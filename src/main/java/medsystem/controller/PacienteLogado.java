/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medsystem.controller;
import java.util.ArrayList;
import medsystem.model.Paciente;

/**
 *
 * @author leonardo
 */
public class PacienteLogado {
    public static ArrayList<Paciente> listaPacientes = new ArrayList();
    
    public static void LogarPaciente(Paciente p){
        listaPacientes.add(p);
    }
    
    public static Paciente PesquisarPaciente(String cpf){
        for(Paciente p : listaPacientes){
            if (p.getCPF().equals(cpf))
                return p;
        }
        return null;
    }
    
    public static boolean EstaLogado(String cpf) {
        Paciente p = PesquisarPaciente(cpf);
        if(p != null) {
            return true;
        }
        return false;
    }
    
    public static void Deslogar() {
        listaPacientes.remove(0);
    }
}


