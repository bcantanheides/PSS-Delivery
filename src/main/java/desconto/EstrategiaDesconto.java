package desconto;

import modelo.Pedido;

public interface EstrategiaDesconto {
    double calcularDesconto(Pedido pedido);
}
