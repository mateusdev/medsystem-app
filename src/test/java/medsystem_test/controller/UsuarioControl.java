package medsystem_test.controller;

import medsystem.model.Paciente;
import medsystem.model.Usuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class UsuarioControl {
    @Test
    @DisplayName("Testando UsuarioControl->EstaCadastrado")
    @Order(1)
    void EstaCadastradoTest(){
        Paciente usuario = new Paciente();
        usuario.setUsername("paciente1");
        usuario.setPassword("teste123");

        medsystem.controller.UsuarioControl.CadastrarUsuario(usuario);
        boolean estacadastrado = medsystem.controller.UsuarioControl.EstaCadastrado("paciente1", "teste123");
        assert(estacadastrado);
    }

    @Test
    @Order(2)
    @DisplayName("Testando UsuarioControl->PesquisaUsuario")
    void PesquisaUsuarioTest(){
        Paciente usuario = new Paciente();
        usuario.setUsername("paciente2");
        usuario.setUsername("teste123");

        medsystem.controller.UsuarioControl.CadastrarUsuario(usuario);
        Usuario u = medsystem.controller.UsuarioControl.PesquisaUsuario("paciente999", "teste123");
        assert(u == null);
    }


    @Test
    @Order(3)
    @DisplayName("Testando UsuarioControl->CadastrarUsuario")
    void CadastrarUsuarioTest(){
        Paciente usuario = new Paciente();
        usuario.setUsername("myusuario0");

        medsystem.controller.UsuarioControl.CadastrarUsuario(usuario);
        int tamanho = medsystem.controller.UsuarioControl.listaUsuarios.size();
        assert(tamanho == 1);
    }

}
