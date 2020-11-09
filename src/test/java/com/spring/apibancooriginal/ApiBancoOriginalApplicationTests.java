package com.spring.apibancooriginal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.apibancooriginal.controller.ClienteController;
import com.spring.apibancooriginal.model.Cliente;
import com.spring.apibancooriginal.model.Genero;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
//@Sql(scripts = "sql/Scripts")
class ApiBancoOriginalApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    ClienteController clienteController;


    @Test
    void contextLoads() {
    }


    @Test
    public void saveClienteClienteTest() {
        Cliente cliente = new Cliente(
                "Lucas",
                Genero.M,
                "476.181.508-69",
                "20071999");
        this.clienteController.saveCliente(cliente);

        Assert.assertEquals(cliente, cliente);

    }


    @Test
    public void listClientesTest() {

        Cliente cliente2 = new Cliente(
                "Luiz",
                Genero.M,
                "476.181.508-69",
                "20071999");

        List<Cliente> clienteList = (List<Cliente>) clienteController.listClientes();
        Assert.assertTrue(clienteList.size() > 0);

    }

    @Test
    public void listClientByIdTest() {
        Cliente cliente = clienteController.listClientById(38);
        Assert.assertTrue(cliente.getNome().equals("Lucas"));
        Assert.assertTrue(cliente.getCpf().equals("476.181.508-69"));
        Assert.assertEquals(0, 0);
        Assert.assertTrue(cliente.getNascimento().equals("1999-01-19 22:07:00"));

    }


    @Test
    public void deleteClienteByIdTest() {
            Cliente cliente = new Cliente(
                    "Lucas",
                    Genero.M,
                    "476.181.508-69",
                    "20071999");
            this.clienteController.saveCliente(cliente);

            this.clienteController.deleteCliente(28);
            Assert.assertNull(clienteController.listClientById(28));

    }


    @Test
    public void updateClienteTest() {
        Cliente cliente = new Cliente(1,
                "Lucas",
                Genero.M,
                "476.181.508-69",
                "20071999");

        clienteController.saveCliente(cliente);

        cliente.setNome("Lucas Luiz");

        clienteController.updateCliente(1, cliente);


        Assert.assertTrue(cliente.getNome() == "Lucas Luiz");

    }

}
