public class ArvorePersonagens {
    private NoArvore raiz;


    public void inserir(Personagem p) {
        raiz = inserirRecursivo(raiz, p);
    }

    private NoArvore inserirRecursivo(NoArvore atual, Personagem p) {
        if (atual == null) {
            return new NoArvore(p);
        }
        if (p.id < atual.personagem.id) {
            atual.esquerda = inserirRecursivo(atual.esquerda, p);
        } else if (p.id > atual.personagem.id) {
            atual.direita = inserirRecursivo(atual.direita, p);
        } else {
            System.out.println("Erro: ID " + p.id + " já cadastrado.");
        }
        return atual;
    }


    public Personagem buscar(int id) {
        return buscarRecursivo(raiz, id);
    }

    private Personagem buscarRecursivo(NoArvore atual, int id) {
        if (atual == null || atual.personagem.id == id) {
            return atual != null ? atual.personagem : null;
        }
        if (id < atual.personagem.id) {
            return buscarRecursivo(atual.esquerda, id);
        }
        return buscarRecursivo(atual.direita, id);
    }


    public void buscarPorNivel(int nivel)
    {
        System.out.println("Buscando personagens com nivel " + nivel);
        boolean[] encontrado = {false};
        buscarNivelRecursivo(raiz, nivel, encontrado);
        if (!encontrado[0])
        {
            System.out.println("Nenhum personagem encontrado com o nível " + nivel);
        }
    }

    private void buscarNivelRecursivo(NoArvore atual, int nivel, boolean[] encontrado)
    {
        if (atual != null)
        {
            buscarNivelRecursivo(atual.esquerda, nivel, encontrado);
            if (atual.personagem.nivel == nivel)
            {
                System.out.println(atual.personagem);
                encontrado[0] = true;
            }
            buscarNivelRecursivo(atual.direita, nivel, encontrado);
        }
    }


    public void excluir(int id) {
        raiz = excluirRecursivo(raiz, id);
    }

    private NoArvore excluirRecursivo(NoArvore atual, int id) {
        if (atual == null) {
            System.out.println("Personagem com ID " + id + " não encontrado.");
            return null;
        }

        if (id < atual.personagem.id) {
            atual.esquerda = excluirRecursivo(atual.esquerda, id);
        } else if (id > atual.personagem.id) {
            atual.direita = excluirRecursivo(atual.direita, id);
        } else {
            if (atual.esquerda == null) return atual.direita;
            else if (atual.direita == null) return atual.esquerda;

            atual.personagem = encontrarMenorValor(atual.direita);
            atual.direita = excluirRecursivo(atual.direita, atual.personagem.id);
            System.out.println("Personagem com ID " + id + " removido com sucesso.");
        }
        return atual;
    }

    private Personagem encontrarMenorValor(NoArvore raiz) {
        Personagem menor = raiz.personagem;
        while (raiz.esquerda != null) {
            menor = raiz.esquerda.personagem;
            raiz = raiz.esquerda;
        }
        return menor;
    }


    public void percursos() {
        System.out.println("PERCURSOS DA ABB");
        System.out.print("Pré-ordem: ");
        preOrdem(raiz);
        System.out.println();

        System.out.print("In-ordem : ");
        inOrdem(raiz);
        System.out.println();

        System.out.print("Pós-ordem: ");
        posOrdem(raiz);
        System.out.println();
    }

    private void preOrdem(NoArvore atual)
    {
        if (atual != null)
        {
            System.out.print(atual.personagem.id);
            preOrdem(atual.esquerda);
            preOrdem(atual.direita);
        }
    }

    private void inOrdem(NoArvore atual)
    {
        if (atual != null)
        {
            inOrdem(atual.esquerda);
            System.out.print(atual.personagem.id);
            inOrdem(atual.direita);
        }
    }

    private void posOrdem(NoArvore atual)
    {
        if (atual != null) {
            posOrdem(atual.esquerda);
            posOrdem(atual.direita);
            System.out.print(atual.personagem.id);
        }
    }
}