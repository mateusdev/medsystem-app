package medsystem_test.controller;

import medsystem.model.Paciente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class PacienteControl {
    @Test
    @DisplayName("Testando PacienteControl->AlterarPaciente")
    @Order(1)
    void AlterarPacienteTest(){
        Paciente paciente = new Paciente();
        paciente.setUsername("paciente1");
        paciente.setNome("Bob");

        medsystem.controller.PacienteControl.CadastrarPaciente(paciente);
        medsystem.controller.PacienteControl.AlterarPaciente(0,
                "Joao",
                "000.000.000-00",
                "0000000000",
                "85999999999",
                "12/12/2012",
                "Grove Street");
        assert(medsystem.controller.PacienteControl.listaPacientes.get(0).getNome().equals("Joao"));
    }

    @Test
    @Order(2)
    @DisplayName("Testando PacienteControl->PesquisarPaciente")
    void PesquisarPacienteTest(){
        Paciente paciente = new Paciente();
        paciente.setUsername("paciente2");
        paciente.setNome("Odenkirk");
        paciente.setCPF("111.111.111-11");

        medsystem.controller.PacienteControl.CadastrarPaciente(paciente);
        Paciente a = medsystem.controller.PacienteControl.PesquisarPaciente("111.111.111-11");
        assert(a != null);
    }

    @Test
    @Order(3)
    @DisplayName("Testando PacienteControl->DeletarPaciente")
    void DeletarPacienteTest(){
        Paciente paciente = new Paciente();
        paciente.setUsername("paciente3");

        medsystem.controller.PacienteControl.CadastrarPaciente(paciente);
        medsystem.controller.PacienteControl.DeletarPaciente(paciente);
        int tamanho = medsystem.controller.PacienteControl.listaPacientes.size();
        assert(tamanho == 3);
    }

    @Test
    @Order(4)
    @DisplayName("Testando PacienteControl->CadastrarPaciente")
    void CadastrarPacienteTest(){
        Paciente paciente = new Paciente();
        paciente.setUsername("mypaciente0");

        medsystem.controller.PacienteControl.CadastrarPaciente(paciente);
        int tamanho = medsystem.controller.PacienteControl.listaPacientes.size();
        assert(tamanho == 2);
    }

}
