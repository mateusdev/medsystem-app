package medsystem.controller;
import java.util.ArrayList;
import medsystem.model.Administrador;

public class AdministradorControl {
    public static ArrayList<Administrador> listaAdministradores = new ArrayList();
    public static int id=0;
    
    public static void CadastrarAdministrador(Administrador p){
        id++;
        p.setId(id);
        listaAdministradores.add(p);
    }
    
    public static boolean AlterarAdministrador(int id, String nome, String cpf, String rg, String contato,
            String nasc, String endereco, String sexo){
        for(Administrador m : listaAdministradores){
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

    public static Administrador PesquisarAdministrador(String nome){
        for(Administrador a : listaAdministradores){
            if (a.getNome().equals(nome))
                return a;
        }
        return null;
    }
 
    public static void DeletarAdministrador(Administrador a){
        listaAdministradores.remove(a);
        id--;
    }
    
    public static ArrayList<Administrador> ListarAdministradors(){
        return listaAdministradores;
    }
}