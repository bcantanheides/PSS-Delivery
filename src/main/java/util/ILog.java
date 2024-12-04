package util;

import modelo.Pedido;

public interface ILog {
    void registrar(Pedido pedido, String nomeMetodo);
}
