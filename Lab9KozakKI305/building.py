# Builing class represents building
class Building:

    # Initializes the class
    def __init__(self, floors, address, area):
        self.floors = floors
        self.address = address
        self.area = area

    # Adds floor and increases the area respectively
    def addFloor(self):
        self.area += self.area / self.floors
        self.floors += 1

    # Returns the average area
    def getFloorArea(self):
        return self.area / self.floors
    
    # Prints the class info
    def print_info(self):
        print(f"Address: {self.address}, Floors: {self.floors}, Area: {self.area}")

