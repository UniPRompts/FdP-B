#include <iostream>

using namespace std;

template <class T>

class simpleList{
	
    private:
    	struct node{
            T value;
            node* next;
        };
        node* head;
        node* tail; 
        
        int lenght;

    public:
        simpleList(){
            head = NULL;
            tail = NULL;
            lenght = 0;
        }
        ~simpleList(){
            while(!isEmpity()){
                removeTop();
            }
        }
        
        bool isEmpity() const{
            if(lenght == 0)
                return true;
                
            return false;
        }
        
        void addHead(T value){
            node* tmp = new node;
            tmp->value = value;
            tmp->next = head;
            head = tmp;
            if(tail == NULL)
                tail = tmp;
            lenght++;
        }

        void addBottom(T value){

            if(tail == NULL || head == NULL){
                addHead(value);
            }else{
                node* tmp = new node;
                tmp->next = NULL;
                tmp->value = value;

                node* cursor = head;
                while(cursor->next != NULL)
                    cursor = cursor->next;
                
                cursor->next = tmp;

                tail = tmp;
                lenght++;
            }
        }
        
        void print(ostream& out) const{
        	node* tmp = head;
        	while(tmp != NULL){
        		out<<tmp->value<<" ";
        	    tmp = tmp->next;
			}
		}
        T removeTop(){
            if(isEmpity())
                throw string("Empity list");
            
            T t;
            node* tmpNext = head->next;

            t = head->value;

            delete head;
            head = tmpNext;

            lenght--;
            return t;
        }
};


// int main(){
	
// 	simpleList<int> s;
// 	s.addBottom(2);
// 	s.addHead(3);
// 	s.print(cout);
// 	cout<<"\n"<<s.removeTop();
// 	cout<<"\n"<<s.removeTop();
// //	cout<<"\n"<<s.removeTop();

// 	for(int i = 0; i < 100; i++){
// 		s.addBottom(i);
// 	}
// 	cout<<"\n";

// 	s.print(cout);
	
// 	return 0;
// }
