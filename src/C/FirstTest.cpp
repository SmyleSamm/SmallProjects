#include <iostream>
using namespace std;

void firstSight(){
    cout << "Hello World\n";
    std::cout << "Hello World 2" << endl;
    std::cout << "Another Line" << endl;
}
void escapeSequence(){
    std::cout << "test\ttest" << endl;
    std::cout << "test\\test" << endl;
    std::cout << "test\"test\"" << endl;
}
void variables(){
    int num1 = 12;
    double decimal = 12.69;
    char letter = 'd';
    string text = "Der Beste!";
    bool meGay = true;
    int num2 = 12;
    int sum = num1 + num2;
    std::cout << num1 << endl << decimal << endl << letter << endl << text << endl << "bool value: " << meGay << endl << sum << endl;

}
void moreThenOne(){
    int x, y, z;
    x = y = z = 50;
    int a = 10,
        b = 20,
        c = 30;
    std::cout << x + y + z << endl << a + b + c;
}
void whatIsConst(){
    //const is a keyword that makes something unchangeble and read-only
    const int myIQ = -420;
    //myIQ = 420 //error
    std::cout << myIQ << endl;
}
int getUserInput(){
    int x;
    cin >> x;
    return x;
}
void ageCheck(){
    std::cout << "Enter your age!";
    int userInput = getUserInput();
    std::cout << "My age is " << userInput << " years old." << endl;
    bool adult = userInput >= 18;
    if(adult){
        std::cout << "You are an adult!" << endl;
    }else{
        std::cout << "You are not an adult!" << endl;
    }
}
void calculator(){
    int num1, num2;
    std::cout << "Enter your first number:" << endl;
    cin >> num1;
    std::cout << "Enter your second number:" << endl;
    cin >> num2;
    std::cout << "Your number is: " << num1+num2 << endl;
}
void arithmetics(){
    int x = 50, y = 100;
    int addition = x + y;
    int subtraction = x - y;
    int multiplication = x * y;
    float division = (float)x / (float)y;
    int modulus = x % y;
    int increment = ++x;
    int decrement = --y;
    std::cout << addition << endl << subtraction << endl << multiplication << endl << division << endl << modulus << endl << increment << endl << decrement;

}
int main(){
    firstSight();
    escapeSequence();
    variables();
    moreThenOne();
    whatIsConst();
    //ageCheck();
    //calculator();
    arithmetics();
    return 0;
}