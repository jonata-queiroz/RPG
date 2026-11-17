public class NoArvore
{
    Personagem personagem;
    NoArvore esquerda;
    NoArvore direita;

    public NoArvore(Personagem personagem)
    {
        this.personagem = personagem;
        this.esquerda = null;
        this.direita = null;
    }
}
