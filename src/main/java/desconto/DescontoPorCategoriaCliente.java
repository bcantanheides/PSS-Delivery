package desconto;

import modelo.Pedido;

public class DescontoPorCategoriaCliente implements EstrategiaDesconto {
    @Override
    public double calcularDesconto(Pedido pedido) {
        String categoria = pedido.getCliente().getCategoria();
        if ("Ouro".equalsIgnoreCase(categoria)) {
            return pedido.getValorTotal() * 0.30;
        } else if ("Prata".equalsIgnoreCase(categoria)) {
            return pedido.getValorTotal() * 0.20;
        } else if ("Bronze".equalsIgnoreCase(categoria)) {
            return pedido.getValorTotal() * 0.10;
        }
        return 0.0;
    }
}
