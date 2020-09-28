package controller;
import java.util.ArrayList;
import model.Agenda;
import model.Medico;

public class MedicoControl {
    static ArrayList<Medico> listaMedicos = new ArrayList();
    
    static void CadastrarMedico(Medico p){
        listaMedicos.add(p);
    }
    
    static boolean AlterarMedico(int id, String nome, String cpf, String rg, String contato,
            String nasc, String endereco, String sexo, String CRM, Agenda agendaDeTrabalho){
        for(Medico m : listaMedicos){
            if(m.getId() == id){
                m.setNome(nome);
                m.setCpf(cpf);
                m.setRg(rg);
                m.setContato(contato);
                m.setNasc(nasc);
                m.setEndereco(endereco);
                m.setSexo(sexo);
                m.setCRM(CRM);
                m.setAgendaDeTrabalho(agendaDeTrabalho);
                return true;
            }
        }
        return false;
    }

    static Medico PesquisarMedico(String CRM){
        for(Medico m : listaMedicos){
            if (m.getCRM().equals(CRM))
                return m;
        }
        return null;
    }
 
    static void DeletarMedico(Medico m){
        listaMedicos.remove(m);
    }
    
    static ArrayList<Medico> ListarMedicos(){
        return listaMedicos;
    }
}
