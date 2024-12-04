package desconto;

import modelo.Pedido;

public class DescontoPorCupom implements EstrategiaDesconto {
    @Override
    public double calcularDesconto(Pedido pedido) {
        if (pedido.getCodigoCupom() != null && pedido.getCodigosDesconto().containsKey(pedido.getCodigoCupom())) {
            return pedido.getValorTotal() * pedido.getCodigosDesconto().get(pedido.getCodigoCupom());
        }
        return 0.0; // Retorna zero caso não haja cupom válido
    }
}
