class Personagem {
    int id;
    String nome;
    int nivel;
    String classe;
    public PilhaInventario inventario;

    public Personagem(int id, String nome, int nivel, String classe) {
        this.id = id;
        this.nome = nome;
        this.nivel = nivel;
        this.classe = classe;
        this.inventario = new PilhaInventario();
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nome: " + nome + " | Nível: " + nivel + " | Classe: " + classe;
    }
}


