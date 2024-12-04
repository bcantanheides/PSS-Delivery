package desconto;

import modelo.Item;
import modelo.Pedido;

public class DescontoPorTipoItem implements EstrategiaDesconto {
    @Override
    public double calcularDesconto(Pedido pedido) {
        double desconto = 0.0;
        for (Item item : pedido.getItens()) {
            switch (item.getTipo().toLowerCase()) {
                case "alimentação":
                    desconto += item.getValorTotal() * 0.05;
                    break;
                case "educação":
                    desconto += item.getValorTotal() * 0.20;
                    break;
                case "lazer":
                    desconto += item.getValorTotal() * 0.15;
                    break;
            }
        }
        return desconto;
    }
}
