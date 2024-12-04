package modelo;

import util.ILog;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private double taxaEntrega;
    private String codigoCupom;
    private Cliente cliente;
    private ILog log;
    private String codigoPedido;
    private List<Item> itens;

    public Pedido(double taxaEntrega, Cliente cliente, String codigoPedido, ILog log) {
        if (taxaEntrega < 0 || cliente == null) {
            throw new IllegalArgumentException("Valores inválidos para criar o pedido.");
        }
        this.taxaEntrega = taxaEntrega;
        this.cliente = cliente;
        this.codigoPedido = codigoPedido;
        this.log = log;
        this.itens = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getCodigoPedido() {
        return codigoPedido;
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public List<Item> getItens() {
        return itens;
    }

    public String getCodigoCupom() {
        return codigoCupom;
    }

    public void setCodigoCupom(String codigoCupom) {
        this.codigoCupom = codigoCupom;
    }

    public double getValorTotal() {
        double valorTotal = taxaEntrega;
        for (Item item : itens) {
            valorTotal += item.getValorTotal(); // Soma o valor total de cada item
        }
        return valorTotal;
    }
}
