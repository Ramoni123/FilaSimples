import java.util.NoSuchElementException;

public class FilaSimples {
    private No front;
    private No rear;
    private int size;
    private int capacidade;

    public FilaSimples(int capacidadeInicial) {
        this.front = null;
        this.rear = null;
        this.size = 0;
        this.capacidade = capacidadeInicial;
    }
    public void enfileirar(int data) {
        if (size >= capacidade) {
            throw new IllegalStateException("Capacidade da fila atingida");
        }
        No novoNo = new No(data);
        if (rear == null) {
            front = rear = novoNo;
        } else {
            rear.next = novoNo;
            rear = novoNo;
        }
        size++;
    }
    public int desenfileirar() {
        if (front == null) {
            throw new NoSuchElementException("Fila está vazia");
        }
        int data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }
    public void removerTodasOcorrencias(int data) {
        while (front != null && front.data == data) {
            front = front.next;
            size--;
        }

        No current = front;
        while (current != null && current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                size--;
            } else {
                current = current.next;
            }
        }

        if (front == null) {
            rear = null;
        }
    }
    public void listar() {
        No current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public boolean buscar(int data) {
        No current = front;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public int maior() {
        if (front == null) {
            throw new NoSuchElementException("Fila está vazia");
        }
        int max = front.data;
        No current = front;
        while (current != null) {
            if (current.data > max) {
                max = current.data;
            }
            current = current.next;
        }
        return max;
    }
    public int menor() {
        if (front == null) {
            throw new NoSuchElementException("Fila está vazia");
        }
        int min = front.data;
        No current = front;
        while (current != null) {
            if (current.data < min) {
                min = current.data;
            }
            current = current.next;
        }
        return min;
    }
    public double media() {
        if (front == null) {
            throw new NoSuchElementException("Fila está vazia");
        }
        int sum = 0;
        int count = 0;
        No current = front;
        while (current != null) {
            sum += current.data;
            count++;
            current = current.next;
        }
        return (double) sum / count;
    }
    public int quantidade() {
        return size;
    }
    public void aumentarCapacidade(int novaCapacidade) {
        if (novaCapacidade < capacidade) {
            throw new IllegalArgumentException("Nova capacidade deve ser maior que a capacidade atual");
        }
        capacidade = novaCapacidade;
    }
}