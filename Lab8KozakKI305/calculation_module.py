import math
import os
import struct

# calculation.py
def calculate(x):
    rad = math.radians(x)

    # tan / cot is equal to tan * tan
    return math.pow(math.tan(rad), 2)

# Writes to result to fName.txt file
def writeTxt(fName, result):
    with open(fName, 'w') as f:
        f.write(str(result))

# Reads data from fName.txt file 
def readTxt(fName):
    result = 0.0
    try:
        if os.path.exists(fName):
                with open(fName, 'r') as f:
                    result = f.read()
        else:
            raise FileNotFoundError(f"File {fName} not found.")
    except FileNotFoundError as e:
        print(e)
    return result

# Writes result to fName.bin file
def writeBin(fName, result):
    with open(fName, 'wb') as f:
         f.write(struct.pack('f', result))

# Reads data from fName.bin file
def readBin(fName):
    result = 0,0
    try:
        if(os.path.exists(fName)):
            with open(fName, 'rb') as f:
                result = struct.unpack('f', f.read())[0]
        else:
            raise FileNotFoundError(f"File {fName} not found.")
    except FileNotFoundError as e:
         print(e)
    return result

# Gets the format of file
def getFormat(fName):
    fileFormat = fName.split(".")
    return fileFormat[len(fileFormat) - 1]