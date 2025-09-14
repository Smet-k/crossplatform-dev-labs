from matrix_module import *

# main.py
def main():
    try:
        n = int(input("Enter the size of jagged matrix: "))
        symbol = input("Enter filler symbol: ")

        # Limiting symbol's range to 1
        if len(symbol) != 1:
            print("Filler symbol must be a singular character")
            return
        
        matrix = generate_matrix(n, symbol)
        print("Generated matrix: ")
        print_matrix(matrix)
    except ValueError:
        print("Matrix size must be a number")

if __name__ == "__main__":
    main()