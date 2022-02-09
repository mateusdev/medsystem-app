package medsystem_test.controller;

import medsystem.model.Horario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class HorarioControl {
    @Test
    @DisplayName("Testando HorarioControl->AlterarHorario")
    @Order(1)
    void AlterarHorarioTest(){
        Horario horario = new Horario();
        horario.setNomeHorario("Horario1");

        medsystem.controller.HorarioControl.CadastrarHorario(horario);
        medsystem.controller.HorarioControl.AlterarHorario(1,
                "Horario2");
        assert(medsystem.controller.HorarioControl.listaHorarios.get(0).getNomeHorario().equals("Horario2"));
    }

    @Test
    @Order(2)
    @DisplayName("Testando HorarioControl->PesquisarHorario")
    void PesquisarHorarioTest(){
        Horario horario = new Horario();
        horario.setNomeHorario("Horario2");
        horario.setId(9);

        medsystem.controller.HorarioControl.CadastrarHorario(horario);
        Horario h = medsystem.controller.HorarioControl.PesquisarHorario(20);
        assert(h == null);
    }

    @Test
    @Order(3)
    @DisplayName("Testando HorarioControl->DeletarHorario")
    void DeletarHorarioTest(){
        Horario horario = new Horario();
        horario.setId(10);

        medsystem.controller.HorarioControl.CadastrarHorario(horario);
        medsystem.controller.HorarioControl.DeletarHorario(horario);
        Horario h = medsystem.controller.HorarioControl.PesquisarHorario(10);
        assert(h == null);
    }

    @Test
    @Order(4)
    @DisplayName("Testando HorarioControl->CadastrarHorario")
    void CadastrarHorarioTest(){
        Horario horario = new Horario();
        horario.setNomeHorario("Horario8");
        horario.setId(11);

        medsystem.controller.HorarioControl.CadastrarHorario(horario);
        Horario h = medsystem.controller.HorarioControl.PesquisarHorario(12);
        assert(h == null);
    }

}
