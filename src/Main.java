public class Main {
    public static void main(String[] args) {


        ArvorePersonagens arvore = new ArvorePersonagens();
        arvore.inserir(new Personagem(50, "Arthas", 60, "Paladino"));
        arvore.inserir(new Personagem(30, "Jaina", 55, "Maga"));
        arvore.inserir(new Personagem(70, "Thrall", 58, "Xamã"));
        arvore.inserir(new Personagem(40, "Illidan", 59, "Caçador"));

        System.out.println("Percursos:");
        arvore.percursos();

        System.out.println("Busca por ID 40:");
        System.out.println(arvore.buscar(40));

        System.out.println("Busca por Nível 55:");
        arvore.buscarPorNivel(55);

        System.out.println("Excluindo ID 30:");
        arvore.excluir(30);
        arvore.percursos();




        FilaMatchmaking fila = new FilaMatchmaking();
        fila.adicionar(arvore.buscar(50));
        fila.adicionar(arvore.buscar(70));
        fila.adicionar(arvore.buscar(40));

        System.out.println("Listando fila:");
        fila.listar();

        System.out.println("Buscando ID 70 na fila:");
        System.out.println(fila.buscar(70));

        System.out.println("Excluindo ID 40 da fila:");
        fila.excluir(40);
        fila.listar();

        System.out.println("Iniciando partida:");
        fila.iniciarPartida();



        Personagem heroi = arvore.buscar(50);
        System.out.println("testando inventário do herói: " + heroi.nome);

        heroi.inventario.adicionar(new Item("Poção de Vida", "Consumível"));
        heroi.inventario.adicionar(new Item("Espada Longa", "Arma"));
        heroi.inventario.adicionar(new Item("Escudo de Ferro", "Armadura"));

        System.out.println("Listando inventário");
        heroi.inventario.listar();

        System.out.println("Buscando item 'Poção de Vida':");
        heroi.inventario.buscar("Poção de Vida");

        System.out.println("Removendo item do topo :");
        heroi.inventario.remover();

        System.out.println("Inventário após remoção:");
        heroi.inventario.listar();

    }
}
