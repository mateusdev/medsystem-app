package medsystem.controller;
import java.util.ArrayList;
import medsystem.model.Atendente;

public class AtendenteControl {
    public static ArrayList<Atendente> listaAtendentes = new ArrayList();
    
    public static void CadastrarAtendente(Atendente p){
        listaAtendentes.add(p);
    }
    
    public static boolean AlterarAtendente(int id, String nome, String cpf, String rg, String contato,
        String nasc, String endereco, String sexo){
        for(Atendente m : listaAtendentes){
            if(m.getId() == id){
                m.setNome(nome);
                m.setCpf(cpf);
                m.setRg(rg);
                m.setContato(contato);
                m.setNasc(nasc);
                m.setEndereco(endereco);
                m.setSexo(sexo);
                return true;
            }
        }
        return false;
    }

    public static Atendente PesquisarAtendente(String cpf){
        for(Atendente a : listaAtendentes){
            if (a.getCpf().equals(cpf))
                return a;
        }
        return null;
    }

    public static Atendente PesquisarAtendentePorId(int id){
        for(Atendente a : listaAtendentes){
            if (a.getId() == id)
                return a;
        }
        return null;
    }

    public static Atendente PesquisarUsuarioAtendente(String usuario, String senha){
        for(Atendente p : listaAtendentes){
            if (p.getUsername().equals(usuario) && p.getPassword().equals(senha))
                return p;
        }
        return null;
    }
    
    public static void DeletarAtendente(Atendente a){
        listaAtendentes.remove(a);
    }
    
    public static ArrayList<Atendente> ListarAtendentes(){
        return listaAtendentes;
    }
}
