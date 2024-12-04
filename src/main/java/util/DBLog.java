package util;

import modelo.Pedido;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DBLog implements ILog {
    @Override
    public void registrar(Pedido pedido, String nomeMetodo) {
        String nomeUsuario = UsuarioLogadoService.getNomeUsuario();
        String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        String mensagem = String.format(
                "LOG: [%s] Data: %s, Código Pedido: %s, Operação: %s, Cliente: %s",
                nomeUsuario, dataHora, pedido.getCodigoPedido(), nomeMetodo, pedido.getCliente().getNome()
        );
        System.out.println("Registro no SQLite: " + mensagem);
    }
}
