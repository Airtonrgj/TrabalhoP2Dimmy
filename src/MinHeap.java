import java.util.ArrayList;

public class MinHeap {

    //primeiro vou criar a representação da árvore em um array
    public ArrayList<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
    }

    //agora crio o os métodos para achar os index dos filhos da esquerda e da direita
    public int filhoEsquerda(int index) {
        return 2 * index + 1;
    }

    public int filhoDireita(int index) {
        return 2 * index + 2;
    }

    //método para achar o index do pai tbm
    //vai funcionar para ambos os filho ja que é um valor int ent ele não vai achar as casas decimais portanto ambos os vão retornar o mesmo pai(eu acho)
    public int parent(int index) {
        return (index - 1) / 2;
    }

    //comparador de filfhos, para saber quem vai entra no lugar do pai
    public boolean comparadorDeFilhos(int x, int y){
        return heap.get(x) < heap.get(y);
    }

    //logica para minheap
    public void minHeap(int index){
        int menor = index;
        int esquerda = filhoEsquerda(index);
        int direita = filhoDireita(index);

        //descobrir o menos na comparacão do pai e dos filhos
        if(esquerda < heap.size() && comparadorDeFilhos(esquerda,menor)){
            menor = esquerda;
        }

        if(direita < heap.size() && comparadorDeFilhos(direita,menor)){
            menor = direita;
        }
        //achei o menor, mas o array até o momento continua da mesma forma

        if(menor != index){

            int temp = heap.get(index);

            heap.set(index, heap.get(menor));

            heap.set(menor, temp);

            minHeap(menor);

        }
    }

    public int extractMin(){
        if (heap.isEmpty()){
            throw new IllegalStateException("Heap esta vazio");
        }

        //salvando o valor que vai ser retirado para mostra no final que ele foi removido
        int raiz = heap.get(0);
        int ultimo = heap.remove(heap.size() - 1);

        if(!heap.isEmpty()){
            heap.set(0,ultimo);
            minHeap(0);
        }
        return raiz;
    }
}
