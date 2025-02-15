package medsystem_test.controller;

import medsystem.model.Atendente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class AtendenteControl {
    @Test
    @DisplayName("Testando AtendenteControl->AlterarAtendente")
    @Order(1)
    void AlterarAtendenteTest(){
        Atendente atendente = new Atendente();
        atendente.setUsername("atendente1");
        atendente.setNome("Alan");

        medsystem.controller.AtendenteControl.CadastrarAtendente(atendente);
        medsystem.controller.AtendenteControl.AlterarAtendente(0,
                "Joao",
                "000.000.000-00",
                "0000000000",
                "85999999999",
                "12/12/2012",
                "Grove Street",
                "sim");

        assert(Objects.equals(medsystem.controller.AtendenteControl.listaAtendentes.get(0).getNome(), "Joao"));
    }

    @Test
    @Order(2)
    @DisplayName("Testando AtendenteControl->PesquisarAtendente")
    void PesquisarAtendenteTest(){
        Atendente atendente = new Atendente();
        atendente.setUsername("myatendente2");
        atendente.setCpf("000.000.000-00");
        atendente.setId(1);

        medsystem.controller.AtendenteControl.CadastrarAtendente(atendente);
        Atendente a = medsystem.controller.AtendenteControl.PesquisarAtendente("000.000.000-00");
        assert(a.getCpf() == atendente.getCpf());
    }

    @Test
    @Order(3)
    @DisplayName("Testando AtendenteControl->DeletarAtendente")
    void DeletarAtendenteTest(){
        Atendente atendente = new Atendente();
        atendente.setUsername("myatendente3");

        medsystem.controller.AtendenteControl.CadastrarAtendente(atendente);
        medsystem.controller.AtendenteControl.DeletarAtendente(atendente);
        int tamanho = medsystem.controller.AtendenteControl.listaAtendentes.size();

        assert(tamanho == 4);
    }

    @Test
    @Order(4)
    @DisplayName("Testando AtendenteControl->CadastrarAtendente")
    void CadastrarAtendenteTest(){
        Atendente atendente = new Atendente();
        atendente.setUsername("myatendente0");

        medsystem.controller.AtendenteControl.CadastrarAtendente(atendente);
        int tamanho = medsystem.controller.AtendenteControl.listaAtendentes.size();

        assert(tamanho == 1);
    }

    @Test
    @Order(5)
    @DisplayName("Testando AtendenteControl->PesquisarAtendentePorId")
    void PesquisarAtendentePorIdTest(){
        Atendente atendente = new Atendente();
        atendente.setUsername("myatendente8");
        atendente.setCpf("120.000.000-11");
        atendente.setId(5);

        medsystem.controller.AtendenteControl.CadastrarAtendente(atendente);

        Atendente a = medsystem.controller.AtendenteControl.PesquisarAtendentePorId(5);
        assert(Objects.equals(a.getCpf(), atendente.getCpf()));
    }
}
