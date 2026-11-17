public class PilhaInventario
{
    private NoPilha topo;
    private int tamanho;

    public PilhaInventario()
    {
        this.topo = null;
        this.tamanho = 0;
    }


    public void adicionar(Item item)
    {
        NoPilha novoNo = new NoPilha(item);
        novoNo.abaixo = topo;
        topo = novoNo;
        tamanho++;
        System.out.println("Item coletado e adicionado ao inventário: " + item);
    }


    public Item buscar(String nomeItem) {
        NoPilha atual = topo;
        int posicao = 1;
        while (atual != null) {
            if (atual.item.nome.equalsIgnoreCase(nomeItem)) {
                System.out.println("Item '" + nomeItem + "' encontrado na posição  " + posicao );
                return atual.item;
            }
            atual = atual.abaixo;
            posicao++;
        }
        System.out.println("Item " + nomeItem + " não foi encontrado no inventário");
        return null;
    }


    public Item remover() {
        if (topo == null) {
            System.out.println("Inventário vazio Nenhum item para remover");
            return null;
        }
        Item itemRemovido = topo.item;
        topo = topo.abaixo;
        tamanho--;
        System.out.println("Item utilizado/removido do topo: " + itemRemovido);
        return itemRemovido;
    }


    public void listar() {
        System.out.println("Inventário do Personagem");
        if (topo == null) {
            System.out.println("O inventário está vazio");
            return;
        }
        NoPilha atual = topo;
        int posicao = 1;
        while (atual != null) {
            System.out.println("  Topo " + posicao + " " + atual.item);
            atual = atual.abaixo;
            posicao++;
        }
    }

    public int getTamanho()
    {
        return tamanho;
    }
}
