#include <iostream>
#include <stdexcept>

using namespace std;

template<typename T>
class MyList {
public:
    virtual void add(const T& element) = 0;
    virtual void remove(int index) = 0;
    virtual T get(int index) const = 0;
    virtual int size() const = 0;
};
template<typename T>
class MyArrayList : public MyList<T> {
private:
    T* elements;
    int capacity;
    int currentSize;
public:
    MyArrayList() : capacity(10), currentSize(0) {
        elements = new T[capacity];
    }

    ~MyArrayList() {
        delete[] elements;
    }

    void add(const T& element) override {
        if (currentSize >= capacity) {
            capacity *= 2;
            T* newElements = new T[capacity];
            for (int i = 0; i < currentSize; i++) {
                newElements[i] = elements[i];
            }
            delete[] elements;
            elements = newElements;
        }
        elements[currentSize++] = element;
    }

    void remove(int index) override {
        if (index < 0 || index >= currentSize) {
            throw out_of_range("Index out of bounds");
        }
        for (int i = index; i < currentSize - 1; i++) {
            elements[i] = elements[i + 1];
        }
        currentSize--;
    }

    T get(int index) const override {
        if (index < 0 || index >= currentSize) {
            throw out_of_range("Index out of bounds");
        }
        return elements[index];
    }

    int size() const override {
        return currentSize;
    }
};
template<typename T>
class MyLinkedList : public MyList<T> {
private:
    struct Node {
        T data;
        Node* next;
        Node* prev;
        Node(const T& d, Node* n = nullptr, Node* p = nullptr) : data(d), next(n), prev(p) {}
    };
    Node* head;
    Node* tail;
    int listSize;
public:
    MyLinkedList() : head(nullptr), tail(nullptr), listSize(0) {}

    ~MyLinkedList() {
        while (head != nullptr) {
            Node* temp = head;
            head = head->next;
            delete temp;
        }
    }

    void add(const T& element) override {
        Node* newNode = new Node(element);
        if (head == nullptr) {
            head = tail = newNode;
        } else {
            tail->next = newNode;
            newNode->prev = tail;
            tail = newNode;
        }
        listSize++;
    }

    void remove(int index) override {
        if (index < 0 || index >= listSize) {
            throw out_of_range("Index out of bounds");
        }
        Node* current = head;
        for (int i = 0; i < index; i++) {
            current = current->next;
        }
        if (current->prev != nullptr) {
            current->prev->next = current->next;
        }
        if (current->next != nullptr) {
            current->next->prev = current->prev;
        }
        if (current == head) {
            head = current->next;
        }
        if (current == tail) {
            tail = current->prev;
        }
        delete current;
        listSize--;
    }

    T get(int index) const override {
        if (index < 0 || index >= listSize) {
            throw out_of_range("Index out of bounds");
        }
        Node* current = head;
        for (int i = 0; i < index; i++) {
            current = current->next;
        }
        return current->data;
    }

    int size() const override {
        return listSize;
    }
};

int main() {
    MyArrayList<int> arrList;
    arrList.add(10);
    arrList.add(20);
    arrList.add(30);
    cout << "Element at index 1: " << arrList.get(1) << endl;
    arrList.remove(1);
    cout << "Size after removal: " << arrList.size() << endl;

    MyLinkedList<int> linkedList;
    linkedList.add(100);
    linkedList.add(200);
    linkedList.add(300);
    cout << "Element at index 1: " << linkedList.get(1) << endl;
    linkedList.remove(1);
    cout << "Size after removal: " << linkedList.size() << endl;

    return 0;
}
