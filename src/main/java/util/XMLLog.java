package util;

import modelo.Pedido;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class XMLLog implements ILog {
    @Override
    public void registrar(Pedido pedido, String nomeMetodo) {
        String nomeUsuario = UsuarioLogadoService.getNomeUsuario();
        String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        String mensagem = String.format(
                "<log><usuario>%s</usuario><data>%s</data><codigo_pedido>%s</codigo_pedido><operacao>%s</operacao><cliente>%s</cliente></log>",
                nomeUsuario, dataHora, pedido.getCodigoPedido(), nomeMetodo, pedido.getCliente().getNome()
        );
        System.out.println("Registro em XML: " + mensagem);
    }
}
