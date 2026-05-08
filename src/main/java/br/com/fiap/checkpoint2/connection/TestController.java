package br.com.fiap.checkpoint2.connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;

@RestController
public class TestController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/teste")
    public String testar() {
        try (Connection conn = dataSource.getConnection()) {
            return "Conectado com sucesso!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}