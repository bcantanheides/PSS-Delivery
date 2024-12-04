import modelo.Cliente;
import modelo.Item;
import modelo.Pedido;
import desconto.DescontoPorCupom;
import desconto.DescontoPorCategoriaCliente;
import desconto.DescontoPorTipoItem;

public class Main {
    public static void main(String[] args) {
        // Cliente
        Cliente cliente = new Cliente("João Silva", "Prata");

        // Pedido
        Pedido pedido = new Pedido(10.0, cliente); // Taxa de entrega: 10.0

        pedido.adicionarItem(new Item("Arroz", "Alimentação", 20.0, 2)); // 2 unidades de Arroz a 20.0 cada
        pedido.adicionarItem(new Item("Curso de Java", "Educação", 100.0, 1)); // 1 unidade de Curso de Java a 100.0
        pedido.adicionarItem(new Item("Jogo de Tabuleiro", "Lazer", 50.0, 1)); // 1 unidade de Jogo de Tabuleiro a 50.0

        System.out.println("Valor total do pedido (sem desconto): R$ " + pedido.getValorTotal());

        // Desconto por cupom
        pedido.setCodigoCupom("DESC10"); // Define o cupom
        pedido.definirEstrategiaDesconto(new DescontoPorCupom());
        System.out.println("Desconto aplicado (Cupom): R$ " + pedido.aplicarDesconto());

        // Desconto por categoria de cliente
        pedido.definirEstrategiaDesconto(new DescontoPorCategoriaCliente());
        System.out.println("Desconto aplicado (Categoria do Cliente): R$ " + pedido.aplicarDesconto());

        // Desconto por tipo de item
        pedido.definirEstrategiaDesconto(new DescontoPorTipoItem());
        System.out.println("Desconto aplicado (Tipo de Item): R$ " + pedido.aplicarDesconto());

        // Total Final
        double valorComDesconto = pedido.getValorTotal() - pedido.aplicarDesconto();
        System.out.println("Valor total do pedido (com desconto): R$ " + valorComDesconto);
    }
}
