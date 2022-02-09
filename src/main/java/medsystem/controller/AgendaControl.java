package medsystem.controller;
import java.util.ArrayList;
import medsystem.model.Agenda;
import medsystem.model.Horario;

public class AgendaControl {
    public static ArrayList<Agenda> listaAgendas = new ArrayList();
    public static int id=0;

    public static void CadastrarAgenda(Agenda p){
        id++;
        p.setId(id);
        listaAgendas.add(p);
    }

    public static boolean AlterarAgenda(int id, int fkMedico, Horario deSegunda, Horario deTerca,
            Horario deQuarta, Horario deQuinta, Horario deSexta){
        for(Agenda a : listaAgendas){
            if(a.getId() == id){
                a.setFkMedico(fkMedico);
                a.setDeSegunda(deSegunda);
                a.setDeTerca(deTerca);
                a.setDeQuarta(deQuarta);
                a.setDeQuinta(deQuinta);
                a.setDeSexta(deSexta);
                return true;
            }
        }
        return false;
    }

    public static Agenda PesquisarAgenda(int fkMedico){
        for(Agenda a : listaAgendas){
            if (a.getFkMedico() == fkMedico)
                return a;
        }
        return null;
    }

    public static void DeletarAgenda(Agenda c){
        listaAgendas.remove(c);
        id--;
    }

    public static ArrayList<Agenda> ListarAgendas(){
        return listaAgendas;
    }
}
