public class NoFila
{
    Personagem personagem;
    NoFila proximo;

    public NoFila(Personagem personagem)
    {
        this.personagem = personagem;
        this.proximo = null;
    }
}
