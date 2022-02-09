package medsystem_test.controller;

import medsystem.controller.MedicoControl;
import medsystem.model.Consulta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class ConsultaControl {
    @Test
    @DisplayName("Testando ConsultaControl->AlterarConsulta")
    @Order(1)
    void AlterarConsultaTest(){
        Consulta consulta = new Consulta();
        consulta.setData("12/02/2022");

        medsystem.controller.ConsultaControl.CadastrarConsulta(consulta);
        medsystem.controller.ConsultaControl.AlterarConsulta(1, null, null, "10/03/1998", "19:30", null, null, null);

        assert(!Objects.equals(medsystem.controller.ConsultaControl.listaConsultas.get(0).getData(), consulta.getData()));
    }

    @Test
    @Order(2)
    @DisplayName("Testando ConsultaControl->PesquisarConsulta")
    void PesquisarConsultaTest(){
        Consulta consulta = new Consulta();
        consulta.setData("10/01/2021");

        medsystem.controller.ConsultaControl.CadastrarConsulta(consulta);
        Consulta c = medsystem.controller.ConsultaControl.PesquisarConsulta("10/01/2021");
        assert(c == consulta);
    }

    @Test
    @Order(3)
    @DisplayName("Testando ConsultaControl->DeletarConsulta")
    void DeletarConsultaTest(){
        Consulta consulta = new Consulta();

        medsystem.controller.ConsultaControl.CadastrarConsulta(consulta);
        medsystem.controller.ConsultaControl.DeletarConsulta(consulta);
        int tamanho = medsystem.controller.ConsultaControl.listaConsultas.size();
        assert(tamanho == 3);
    }

    @Test
    @Order(4)
    @DisplayName("Testando ConsultaControl->CadastrarConsulta")
    void CadastrarConsultaTest(){
        Consulta consulta = new Consulta();
        consulta.setHora("18:03");

        medsystem.controller.ConsultaControl.CadastrarConsulta(consulta);
        int tamanho = medsystem.controller.ConsultaControl.listaConsultas.size();
        assert(tamanho == 2);
    }

}
