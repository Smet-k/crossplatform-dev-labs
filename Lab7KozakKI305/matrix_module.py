# matrix_module.py

# Initializes a jagged matrix
def generate_matrix(n, symbol):
    jagged_list = []
    # Filling matrix rows
    for i in range(1, n + 1):
        array = []
        # Filling matrix columns
        for _ in range(i):
            array.append(symbol)
        jagged_list.append(array)
    return jagged_list

# Draws the jagged matrix
def print_matrix(matrix):
    for arr in matrix:
        # Reverse for loop to draw the needed pattern
        for j in range(len(matrix) - 1, -1, -1):
            if(len(arr) > j):
                print(arr[j], end="")
            else:
                print(" ", end="")
        print()