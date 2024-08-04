#include <iostream>
using namespace std;

template <class T>
class Stack
{
private:
    T *A;
    int top;
    int dim;

    /**
     * Aumenta la dimensione dello stack
     */
    void allarga()
    {
        T *tmp = new T[dim + 10];

        for (int i = 0; i < dim; i++)
            tmp[i] = A[i];

        delete[] A;
        this->A = tmp;
        dim = dim + 10;
    }

public:
    /**
     * Costruttore
     */
    Stack()
    {
        A = new T[10];
        dim = 10;
        top = 0;
    }
    /**
     * Costruttore di copia
     */
    Stack(const Stack &other)
    {
        A = new T[other.dim];
        for (int i = 0; i < other.top; i++)
            A[i] = other.A[i];
        this->top = other.top;
        this->dim = other.dim;
    }
    /**
     * Distruttore
     */
    ~Stack()
    {
        delete[] A;
    }

    /**
     * Inserimento
     */
    void push(T x)
    {
        if (top == dim)
            this->allarga();

        A[top] = x;
        top++;
    }
    /**
     * Estrazione
     */
    T pop()
    {
        if (isEmpty())
            throw out_of_range("Pila vuota!");
        top--;
        return A[top];
    }

    bool isEmpty() const
    {
        return top == 0;
    }
    /**
     * Ritorna il numero di elementi inseriti
     */
    int size() const
    {
        return top;
    }
    /**
     * Ritorna l'elemento di indice i
     */
    T getElement(int i) const
    {
        return A[i];
    }

    /**
     * Overloading operatore ==
     */
    bool operator==(const Stack<T> &other)
    {
        if (this->top != other.top)
            return false;

        for (int i = 0; i < this->top; i++)
            if (this->A[i] != other.A[i])
                return false;

        return true;
    }

    /**
     * Overloading operatore !=
     */
    bool operator!=(const Stack<T> &other)
    {
        return !operator==(other);
    }

    /**
     * Overloading operatore =
     */
    const Stack &operator=(const Stack<T> &other)
    {
        if (this != &other)
        {
            delete[] A;
            A = new T[other.dim];
            for (int i = 0; i < other.top; i++)
                A[i] = other.A[i];
            this->top = other.top;
            this->dim = other.dim;
        }
        return *this;
    }
};

/**
 * Overloading operatore <<
 */
template <class T>
ostream &operator<<(ostream &dest, const Stack<T> &s)
{
    dest << "[";
    for (int i = 0; i < s.size(); i++)
    {
        dest << s.getElement(i);
        if (i < s.size() - 1)
            dest << ", ";
    }

    dest << "]";
    dest << " (" << &s << ")";
    return dest;
}

int main()
{
    Stack<int> p1;
    cout << "p1: " << p1 << endl; // []
    p1.push(7);
    p1.push(9);
    p1.push(11);
    cout << "p1: " << p1 << endl; // [7, 9, 11]

    Stack<int> p2 = p1;
    cout << "p2: " << p2 << endl;

    Stack<int> p3(p1);

    cout << "p3: " << p3 << endl;

    p1.pop();
    cout << "p1: " << p1 << endl; // [7, 9]

    Stack<string> p4;
    p4.push("ciao");
    p4.push("a");
    p4.push("tutti");
    cout << "p4: " << p4 << endl;

    return 0;
}