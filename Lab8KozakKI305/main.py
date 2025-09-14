from calculation_module import *

# main.py
def main():
    print("y = tan(x)/cot(x)")
    try:
        n = int(input("Enter a number for expression: "))
        fName = input("Enter a file to write to/read from: ")
        

        # Checks if file name was provided
        if len(fName) == 0:
            print("File name is necessary")
            return

        fileFormat = getFormat(fName)
        
        # Chooses function based off format
        if(fileFormat == "txt"):
            writeTxt(fName, calculate(n))
        elif(fileFormat == "bin"):
            writeBin(fName, calculate(n))
        else:
            print("Unsupported file format")
            return
        
        # Chooses function based off format
        if(fileFormat == "txt"):
            print("Result is: {0}".format(readTxt(fName)))
        elif(fileFormat == "bin"):
            print("Result is: {0}".format(readBin(fName)))

    except ValueError:
        print("Provided value should be a number")

if __name__ == "__main__":
    main()