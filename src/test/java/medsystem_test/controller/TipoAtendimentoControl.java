package medsystem_test.controller;

import medsystem.model.TipoAtendimento;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class TipoAtendimentoControl {
    @Test
    @DisplayName("Testando TipoAtendimentoControl->AlterarTipoAtendimento")
    @Order(1)
    void AlterarTipoAtendimentoTest(){
        TipoAtendimento tipoAtendimento = new TipoAtendimento();
        tipoAtendimento.setTipoAtendimento("em atendimento");

        medsystem.controller.TipoAtendimentoControl.CadastrarTipoAtendimento(tipoAtendimento);
        medsystem.controller.TipoAtendimentoControl.AlterarTipoAtendimento(1,
                "cancelado");
        assert(medsystem.controller.TipoAtendimentoControl.listaTipoAtendimentos.get(0).getTipoAtendimento().equals("cancelado"));
    }

    @Test
    @Order(2)
    @DisplayName("Testando TipoAtendimentoControl->PesquisarTipoAtendimento")
    void PesquisarTipoAtendimentoTest(){
        TipoAtendimento tipoAtendimento = new TipoAtendimento();
        tipoAtendimento.setTipoAtendimento("em atendimento");

        medsystem.controller.TipoAtendimentoControl.CadastrarTipoAtendimento(tipoAtendimento);
        TipoAtendimento a = medsystem.controller.TipoAtendimentoControl.PesquisarTipoAtendimento(1);
        assert(a.getId() == tipoAtendimento.getId());
    }

    @Test
    @Order(3)
    @DisplayName("Testando TipoAtendimentoControl->DeletarTipoAtendimento")
    void DeletarTipoAtendimentoTest(){
        TipoAtendimento tipoAtendimento = new TipoAtendimento();
        tipoAtendimento.setTipoAtendimento("retorno");

        medsystem.controller.TipoAtendimentoControl.CadastrarTipoAtendimento(tipoAtendimento);
        medsystem.controller.TipoAtendimentoControl.DeletarTipoAtendimento(tipoAtendimento);
        int tamanho = medsystem.controller.TipoAtendimentoControl.listaTipoAtendimentos.size();

        assert(tamanho == 1);
    }

    @Test
    @Order(4)
    @DisplayName("Testando TipoAtendimentoControl->CadastrarTipoAtendimento")
    void CadastrarTipoAtendimentoTest(){
        TipoAtendimento tipoAtendimento = new TipoAtendimento();
        tipoAtendimento.setTipoAtendimento("retorno");

        medsystem.controller.TipoAtendimentoControl.CadastrarTipoAtendimento(tipoAtendimento);
        int tamanho = medsystem.controller.TipoAtendimentoControl.listaTipoAtendimentos.size();

        assert(tamanho == 2);
    }

}
