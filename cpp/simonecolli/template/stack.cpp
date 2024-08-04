#include <iostream>
#include "simpleList.h"

using namespace std;

template <class T>

class stack{
    private:
        simpleList<T> s;
        
    public:
        // stack(){
        //     s = new simpleList;
        // }
        void push(T elem){
            return s.addHead(elem);
        }

        T pop(){
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

    stack<int> s;
    s.push(4);
    s.push(10);
    s.push(20);
    s.push(30);
    s.stampa(cout);
    while (!s.ifEmpity()){
        cout<<"\n"<<s.pop();
    }
    
    return 0;
}