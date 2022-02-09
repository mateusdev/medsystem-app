package medsystem_test.controller;

import medsystem.model.Medico;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class MedicoControl {
    @Test
    @DisplayName("Testando MedicoControl->AlterarMedico")
    @Order(1)
    void AlterarMedicoTest(){
        Medico medico = new Medico();
        medico.setUsername("juliana");
        medico.setNome("Juliana");

        medsystem.controller.MedicoControl.CadastrarMedico(medico);
        medsystem.controller.MedicoControl.AlterarMedico(0,
                "Joao",
                "000.000.000-00",
                "0000000000",
                "85999999999",
                "12/12/2012",
                "Grove Street",
                "sim",
                "888888",
                null);
        assert(Objects.equals(medsystem.controller.MedicoControl.listaMedicos.get(0).getNome(), "Joao"));
    }

    @Test
    @Order(2)
    @DisplayName("Testando MedicoControl->PesquisarMedico")
    void PesquisarMedicoTest(){
        Medico medico = new Medico();
        medico.setUsername("mymedico2");
        medico.setCRM("777");

        medsystem.controller.MedicoControl.CadastrarMedico(medico);
        Medico a = medsystem.controller.MedicoControl.PesquisarMedico("777");
        assert(a != null);
    }

    @Test
    @Order(3)
    @DisplayName("Testando MedicoControl->DeletarMedico")
    void DeletarMedicoTest(){
        Medico medico = new Medico();
        medico.setNome("Bob");

        medsystem.controller.MedicoControl.CadastrarMedico(medico);
        medsystem.controller.MedicoControl.DeletarMedico(medico);
        int tamanho = medsystem.controller.MedicoControl.listaMedicos.size();

        assert(tamanho == 1);
    }

    @Test
    @Order(4)
    @DisplayName("Testando MedicoControl->CadastrarMedico")
    void CadastrarMedicoTest(){
        Medico medico = new Medico();
        medico.setUsername("mymedico0");

        medsystem.controller.MedicoControl.CadastrarMedico(medico);
        int tamanho = medsystem.controller.MedicoControl.listaMedicos.size();
        assert(tamanho == 3);
    }

}
