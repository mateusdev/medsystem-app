package medsystem.controller;
import java.util.ArrayList;
import medsystem.model.Paciente;

public class PacienteControl {
    public static ArrayList<Paciente> listaPacientes = new ArrayList();
    
    public static void CadastrarPaciente(Paciente p){
        listaPacientes.add(p);
    }
    
    public static boolean AlterarPaciente(int id, String nome, String sexo, String data_nasc,
            String CPF, String endereco, String telefone){
        for(Paciente p1 : listaPacientes){
            if(p1.getId() == id){
                p1.setNome(nome);
                p1.setSexo(sexo);
                p1.setData_nasc(data_nasc);
                p1.setCPF(CPF);
                p1.setEndereco(endereco);
                p1.setTelefone(telefone);
                return true;
            }
        }
        return false;
    }

    public static Paciente PesquisarPaciente(String cpf){
        for(Paciente p : listaPacientes){
            if (p.getCPF().equals(cpf))
                return p;
        }
        return null;
    }
    
    public static Paciente PesquisarUsuarioPaciente(String usuario, String senha){
        for(Paciente p : listaPacientes){
            if (p.getUsername().equals(usuario) && p.getPassword().equals(senha))
                return p;
        }
        return null;
    }
    
    public static Paciente PesquisarPacienteNome(String nome){
        for(Paciente p : listaPacientes){
            if (p.getNome().equals(nome)) {
                return p;
            }
        }
        return null;
    }
 
    public static void DeletarPaciente(Paciente p){
        listaPacientes.remove(p);
    }
    
    public static ArrayList<Paciente> ListarPacientes(){
        return listaPacientes;
    }
}
