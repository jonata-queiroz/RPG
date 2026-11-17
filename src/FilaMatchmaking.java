public class FilaMatchmaking {
    private NoFila inicio;
    private NoFila fim;
    private int tamanho;

    public FilaMatchmaking() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }


    public void adicionar(Personagem p) {
        NoFila novoNo = new NoFila(p);
        if (fim == null) {
            inicio = fim = novoNo;
        } else {
            fim.proximo = novoNo;
            fim = novoNo;
        }
        tamanho++;
        System.out.println(p.nome + " entrou na fila de Matchmaking.");
    }


    public Personagem buscar(int id) {
        NoFila atual = inicio;
        while (atual != null) {
            if (atual.personagem.id == id) {
                return atual.personagem;
            }
            atual = atual.proximo;
        }
        return null;
    }


    public void excluir(int id) {
        if (inicio == null) {
            System.out.println("A fila está vazia.");
            return;
        }


        if (inicio.personagem.id == id) {
            inicio = inicio.proximo;
            if (inicio == null) {
                fim = null;
            }
            tamanho--;
            System.out.println("Jogador com ID " + id + " foi removido da fila.");
            return;
        }


        NoFila atual = inicio;
        while (atual.proximo != null && atual.proximo.personagem.id != id) {
            atual = atual.proximo;
        }

        if (atual.proximo != null) {
            atual.proximo = atual.proximo.proximo;
            if (atual.proximo == null) {
                fim = atual;
            }
            tamanho--;
            System.out.println("Jogador com ID " + id + " foi removido da fila.");
        } else {
            System.out.println("Jogador com ID " + id + " não foi encontrado na fila.");
        }
    }


    public void listar() {
        System.out.println("\n Fila de Matchmaking (FIFO) ");
        if (inicio == null) {
            System.out.println("Nenhum jogador na fila de espera.");
            return;
        }
        NoFila atual = inicio;
        int posicao = 1;
        while (atual != null) {
            System.out.println(posicao + "º lugar  " + atual.personagem);
            atual = atual.proximo;
            posicao++;
        }
    }

    public void iniciarPartida() {
        if (tamanho >= 2) {
            Personagem p1 = removerPrimeiro();
            Personagem p2 = removerPrimeiro();
            System.out.println("MATCHMAKING] Partida encontrada");
            System.out.println("  Jogador 1: " + p1.nome + " Nível " + p1.nivel );
            System.out.println("  Jogador 2: " + p2.nome + " Nível " + p2.nivel );
        } else {
            System.out.println("MATCHMAKING] Jogadores insuficientes na fila  \n Total atual: " + tamanho);
        }
    }

    private Personagem removerPrimeiro() {
        if (inicio == null) return null;
        Personagem p = inicio.personagem;
        inicio = inicio.proximo;
        if (inicio == null) {
            fim = null;
        }
        tamanho--;
        return p;
    }

    public int getTamanho() {
        return tamanho;
    }
}
