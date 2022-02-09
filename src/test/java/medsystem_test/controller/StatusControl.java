package medsystem_test.controller;

import medsystem.model.Status;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class StatusControl {
    @Test
    @DisplayName("Testando StatusControl->AlterarStatus")
    @Order(1)
    void AlterarStatusTest(){
        Status status = new Status();
        status.setNome("alarme1");

        medsystem.controller.StatusControl.CadastrarStatus(status);
        medsystem.controller.StatusControl.AlterarStatus(1,
                "alarme2");
        assert(medsystem.controller.StatusControl.listaStatus.get(0).getNome().equals("alarme2"));
    }

    @Test
    @Order(2)
    @DisplayName("Testando StatusControl->PesquisarStatus")
    void PesquisarStatusTest(){
        Status status = new Status();
        status.setNome("No aguardo");

        medsystem.controller.StatusControl.CadastrarStatus(status);
        Status a = medsystem.controller.StatusControl.PesquisarStatus(2);
        assert(a != null);
    }

    @Test
    @Order(3)
    @DisplayName("Testando StatusControl->DeletarStatus")
    void DeletarStatusTest(){
        Status status = new Status();
        status.setNome("status3");

        medsystem.controller.StatusControl.CadastrarStatus(status);
        medsystem.controller.StatusControl.DeletarStatus(status);
        int tamanho = medsystem.controller.StatusControl.listaStatus.size();

        assert(tamanho == 2);
    }

    @Test
    @Order(4)
    @DisplayName("Testando StatusControl->CadastrarStatus")
    void CadastrarStatusTest(){
        Status status = new Status();
        status.setNome("status0");

        medsystem.controller.StatusControl.CadastrarStatus(status);
        int tamanho = medsystem.controller.StatusControl.listaStatus.size();
        assert(tamanho == 1);
    }

}
