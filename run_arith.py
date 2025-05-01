import subprocess
import sys

def compile_project():
    try:
        result = subprocess.run(['ant','clear', 'jar'], capture_output=True, text=True, check=True)
       
    except subprocess.CalledProcessError as e:
        print(f"Error occurred during compilation: {e.stdout}")
        sys.exit(1)

def run_java_program(data_type, operation, operand1, operand2):

    command = [
        'java', '-cp', 'dist/aarithmetic.jar', 'MyInfArith',  
        data_type, operation, operand1, operand2
    ]
    
    try:
        result = subprocess.run(command, capture_output=True, text=True, check=True)
        print("result:")
        print(result.stdout)  
    except subprocess.CalledProcessError as e:
        print(f"Error occurred while running Java program: {e.stderr}")
        sys.exit(1)


if len(sys.argv) != 5:
    print("Usage: python3 run_arith.py <int/float> <operation> <operand1> <operand2>")
    sys.exit(1)

data_type = sys.argv[1]
operation = sys.argv[2]
operand1 = sys.argv[3]
operand2 = sys.argv[4]

compile_project()
run_java_program(data_type, operation, operand1, operand2)


