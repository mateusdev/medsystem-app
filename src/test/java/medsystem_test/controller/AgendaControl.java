package medsystem_test.controller;

import medsystem.model.Agenda;
import medsystem.model.Horario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class AgendaControl {
    @Test
    @DisplayName("Testando AgendaControl->AlterarAgenda")
    @Order(1)
    void AlterarAgendaTest(){
        Horario h = new Horario();
        h.setNomeHorario("Horario1");

        Agenda agenda = new Agenda();
        agenda.setDeSegunda(h);

        medsystem.controller.AgendaControl.CadastrarAgenda(agenda);
        medsystem.controller.AgendaControl.AlterarAgenda(1, 0, null, h, null, null, h);
        assert(medsystem.controller.AgendaControl.listaAgendas.get(0).getDeTerca() == h);
    }

    @Test
    @Order(2)
    @DisplayName("Testando AgendaControl->PesquisarAgenda")
    void PesquisarAgendaTest(){
        Horario h = new Horario();
        h.setNomeHorario("Horario1");

        Agenda agenda = new Agenda();
        agenda.setDeSegunda(h);
        agenda.setFkMedico(1);

        medsystem.controller.AgendaControl.CadastrarAgenda(agenda);
        Agenda a = medsystem.controller.AgendaControl.PesquisarAgenda(1);
        assert(a == agenda);
    }

    @Test
    @Order(3)
    @DisplayName("Testando AgendaControl->DeletarAgenda")
    void DeletarAgendaTest(){
        Agenda agenda = new Agenda();

        medsystem.controller.AgendaControl.CadastrarAgenda(agenda);
        medsystem.controller.AgendaControl.DeletarAgenda(agenda);
        int tamanho = medsystem.controller.AgendaControl.listaAgendas.size();

        assert(tamanho == 2);
    }

    @Test
    @Order(4)
    @DisplayName("Testando AgendaControl->CadastrarAgenda")
    void CadastrarAgendaTest(){
        Agenda agenda = new Agenda();

        medsystem.controller.AgendaControl.CadastrarAgenda(agenda);
        int tamanho = medsystem.controller.AgendaControl.listaAgendas.size();

        assert(tamanho == 1);
    }

}
