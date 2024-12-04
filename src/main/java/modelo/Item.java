package modelo;

public class Item {
    private String nome;
    private String tipo;
    private double preco;
    private int quantidade;

    public Item(String nome, String tipo, double preco, int quantidade) {
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValorTotal() {
        return preco * quantidade;
    }
}
