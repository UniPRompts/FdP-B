#include <iostream>
using namespace std;

class Stack {
    private:
        int* A;
        int top;
        int dim;

        void allarga() {
            int* tmp = new int[dim + 10];
            for (int i = 0; i < dim; i++)
                tmp[i] = A[i];

            delete [] A;
            this->A = tmp;
            dim = dim + 10;
        }

    public:
        Stack() {
            A = new int[10];
            dim = 10;
            top = 0;
        }
        Stack(const Stack& other){
            A = new int[other.dim];
            for(int i = 0; i < other.top; i++)
                A[i] = other.A[i];
            this->top = other.top;
            this->dim = other.dim;
        }
        ~Stack(){
            delete [] A;
        }

        void push(int x) {
            if (top == dim)
                this->allarga();

            A[top] = x;
            top++;
        }
        int pop() {
            if (isEmpty())
                throw out_of_range("Pila vuota!");
            top--;
            return A[top];
        }
        bool isEmpty() const {
            return top == 0;
        }
        int size() const {
            return top;
        }
        int getElement(int i) const {
            return A[i];
        }

        bool operator==(const Stack& other){
            if(this->top != other.top)
                return false;

            for(int i = 0; i < this->top; i++)
                if(this->A[i] != other.A[i])
                    return false;

            return true;
        }
        bool operator!=(const Stack& other){
            return !operator==(other);
        }
        const Stack& operator=(const Stack& other){
            if(this != &other){
                delete [] A;
                A = new int[other.dim];
                for(int i = 0; i < other.top; i++)
                    A[i] = other.A[i];
                this->top = other.top;
                this->dim = other.dim;
            }
            return *this;
        }
};

ostream& operator<<(ostream& dest, const Stack& s) {
    dest << "[";
    for (int i = 0; i < s.size(); i++) {
        dest << s.getElement(i);
        if (i < s.size() -1)
            dest << ", ";
    }

    dest << "]";
    dest << " (" << &s << ")";
    return dest;
}

int main() {
    Stack p1;
    //cout << p1 << endl; // []
    p1.push(7);
    p1.push(9);
    p1.push(11);
    cout << "p1: " << p1 << endl; // [7, 9, 11]

    Stack p2 = p1;
    cout << "p2: " << p2 << endl;

    Stack p3(p1);

    cout << "p3: " << p3 << endl;

    //p1.pop();
    //cout << p1 << endl; // [7, 9]


    return 0;
}