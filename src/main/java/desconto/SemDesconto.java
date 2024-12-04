package desconto;

import modelo.Pedido;

public class SemDesconto implements EstrategiaDesconto {
    @Override
    public double calcularDesconto(Pedido pedido) {
        return 0.0;
    }
}
