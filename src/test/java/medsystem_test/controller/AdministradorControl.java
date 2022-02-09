package medsystem_test.controller;

import medsystem.model.Administrador;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class AdministradorControl {
    @Test
    @DisplayName("Testando AdministradorControl->AlterarAdministrador")
    @Order(1)
    void AlterarAdministradorTest(){
        Administrador admin = new Administrador();
        admin.setUsername("myadmin1");
        admin.setNome("Alan");

        medsystem.controller.AdministradorControl.CadastrarAdministrador(admin);
        medsystem.controller.AdministradorControl.AlterarAdministrador(1,
                "Joao",
                "000.000.000-00",
                "0000000000",
                "85999999999",
                "12/12/2012",
                "Grove Street",
                "sim");
        assert(medsystem.controller.AdministradorControl.listaAdministradores.get(0).getNome().equals("Joao"));
    }

    @Test
    @Order(2)
    @DisplayName("Testando AdministradorControl->PesquisarAdministrador")
    void PesquisarAdministradorTest(){
        Administrador admin = new Administrador();
        admin.setUsername("myadmin2");
        admin.setNome("Alan");

        medsystem.controller.AdministradorControl.CadastrarAdministrador(admin);
        Administrador a = medsystem.controller.AdministradorControl.PesquisarAdministrador("Alan");
        assert(a != null);
    }

    @Test
    @Order(3)
    @DisplayName("Testando AdministradorControl->DeletarAdministrador")
    void DeletarAdministradorTest(){
        Administrador admin = new Administrador();
        admin.setUsername("myadmin3");

        medsystem.controller.AdministradorControl.CadastrarAdministrador(admin);
        medsystem.controller.AdministradorControl.DeletarAdministrador(admin);
        int tamanho = medsystem.controller.AdministradorControl.listaAdministradores.size();
        assert(tamanho == 0);
    }

    @Test
    @Order(4)
    @DisplayName("Testando AdministradorControl->CadastrarAdministrador")
    void CadastrarAdministradorTest(){
        Administrador admin = new Administrador();
        admin.setUsername("myadmin0");

        medsystem.controller.AdministradorControl.CadastrarAdministrador(admin);
        int tamanho = medsystem.controller.AdministradorControl.listaAdministradores.size();
        assert(tamanho == 3);
    }

}
