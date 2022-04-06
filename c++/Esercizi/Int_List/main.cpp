#include <iostream>
using namespace std;

struct node{
    int val;
    node* next = NULL;
};

class List{
    private:
        struct node{
            int val;
            node* next = NULL;
        };
        node* lista = NULL;
        int dim;

    public:
        List(){
            lista = NULL;
            dim = 0;
        }

        List(int val){
            addTesta(val);
        }

        List(node* lista){

        }
        ~List(){
            delete [] lista;
        }

        void addTesta(int val){
            node* new_node;
            new_node->val = val;
            new_node->next = this->lista;
            this->lista = new_node;
            //delete [] new_node;
            dim++;
        }

        void output(){
            if(lista == NULL)
                cout << "Lista vuota\n";
            else{
                while(lista->next != NULL){
                    cout << lista->val << " ";
                    lista = lista->next;
                }
                cout << endl;
            }
        }

};




int main() {

    List l();
    l.addTesta(10);
    l.addTesta(11);
    l.addTesta(12);
    cout << "Ciao\n";
    l.output();

    return 0;
}
