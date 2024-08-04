#include <iostream>
#include "simpleList.h"

using namespace std;

template <class T>

class queue{
    private:
        simpleList<T> s;
    public:
        void enqueue(T elem){
            s.addBottom(elem);
        }
        T dequeue(){
            return s.removeTop();
        }
        bool ifEmpity() const{
            return s.isEmpity();
        }
        void stampa(ostream& out) const{
            s.print(out);
        }
};


int main(){

    queue<int> q;
    q.enqueue(4);
    q.enqueue(10);
    q.enqueue(20);
    q.enqueue(30);
    q.stampa(cout);
    while (!q.ifEmpity()){
        cout<<"\n"<<q.dequeue();
    }
    
    return 0;
}