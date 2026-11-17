public class Item
{
    String nome;
    String tipo;

    public Item(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return nome + " (Tipo: " + tipo + ")";
    }
}
