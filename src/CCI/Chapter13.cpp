#include <iostream>
using namespace std;

//13.1
int main(){
    vector<string> cache(K);
    //没处理输入不够K行...面试要小心
    for(int i = 0; i < K; i++)
        cache.push_back(getline());
    int ptr = 0;
    while(!eof(file)){
        cache[ptr] = getline();
        ptr = (ptr+1) % K;
    }
    return 0;
}

//13.2 根据hash function, 数组链表. map是用二叉查找树处理key...map的插入比较慢
//13.3 虚函数表vtable 动态绑定
//13.4 复制复杂变量，还是引用. 指针对象
//13.5 强行跳过cache, 读取最新值
//13.6 不然用基指针释放的时候可能会泄露
//13.7 深拷贝，注意环
//13.8
template <class T>
class SmartPointer{
    T* ptr = NULL;
    unsigned int* count = NULL; //不同SmaterPointer直接要共用
    SmartPointer(T* p){
        ptr = p;
        count = new unsigned int;
        *count = 1;
    }
    SmartPointer(SmartPointer<T>& p){
        ptr = p.ptr;
        count = p.count;
        *count++;
    }
    ~SmartPointer(){
        *count --;
        if(*count == 0){
            delete ptr;
            free(count);
        }
    }

    T* ptr(){
        return ptr;
    }
};
//13.9 往前申请一段，不管malloc出来的位置，保证可以从对齐位开始
//13.10