# My java project Arbitrary Precision Arithmetic library

 This project implements arithmetic operations on  **infinite/arbitrary-precision arithmetic library** in Java using Object-Oriented Programming without any loss of precision.

---
## Package Structure
```
    project/
├── src/
│   |── arbitraryarithmetic/    
│   |    ├── AInteger.java       # Arbitrary-precision integer class
│   |    └── AFloat.java         # Arbitrary-precision float class
│   └── MyInfArith.java          # Command-line interface for operations
├── test/
│   └── Test.java
├── dist/aarithmetic.jar
├── README.md
└──run_arith.py
```
---

## Features

- Handle **very large integers and floating-point numbers**
- Arithmetic operations done are 
    - Addition
    - Subtraction
    - Multiplication
    - Division
- Works as both **command-line interface and library**

---

## USAGE

### As a command line

**Go into src directory in your clone repository**
```bash
cd src
```

**Run Command-line interface** with:
```bash
java MyInfArith.java <int/float> <add/subtract/multiply/div> <num1> <num2>
```

####  Examples:
```bash
java MyInfArith int add 23650078224912949497310933240250 42939783262467113798386384401498
# Output:  66589861487380063295697317641748

 java MyInfArith int sub 3116511674006599806495512758577 57745242300346381144446453884008
# Output: -54628730626339781337950941125431
```

---

### In other program

#### 1. As a library

you can directly import the libraries as shown below

```java
import arbitraryarithmetic.AInteger;
import arbitraryarithmetic.AFloat;

public class Example {
    public static void main(String[] args) {
        AInteger a = new AInteger("999999999999999999999999");
        AInteger b = new AInteger("111111111111111111111111");
        AInteger sum = a.add(b);
        System.out.println("Sum: " + sum);
        
        AFloat x = new AFloat("123.456789123456789");
        AFloat y = new AFloat("0.000000000000001");
        AFloat result = x.mul(y);
        System.out.println("Product: " + result);
    }
}
```
#### 2. Compile and run using jar command

```bash
javac -cp dist/aarithmetic.jar YourProgram.java
java -cp .:dist/aarithmetic.jar YourProgram
```
#### 3. Using a python script

```bash
python3 run_arith.py <int/float <add/subtract/multiply/div> <number1> <number2>
```

---
### Requirments
- java 8 or later
- python3 if using pyhton script
















