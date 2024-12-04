package util;

import modelo.Pedido;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JSONLog implements ILog {
    @Override
    public void registrar(Pedido pedido, String nomeMetodo) {
        String nomeUsuario = UsuarioLogadoService.getNomeUsuario();
        String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        String mensagem = String.format(
                "{ \"usuario\": \"%s\", \"data\": \"%s\", \"codigo_pedido\": \"%s\", \"operacao\": \"%s\", \"cliente\": \"%s\" }",
                nomeUsuario, dataHora, pedido.getCodigoPedido(), nomeMetodo, pedido.getCliente().getNome()
        );
        System.out.println("Registro em JSON: " + mensagem);
    }
}
