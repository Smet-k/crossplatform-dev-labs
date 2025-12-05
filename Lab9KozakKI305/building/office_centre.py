from .building import Building

# OfficeCentre represents a specialized builing
# derived from building class
class OfficeCentre(Building):
    # Initializes the class
    def __init__(self, companyName, employeeCount, **kwargs):
        super().__init__(**kwargs)
        self.companyName = companyName
        self.employeeCount = employeeCount

    # Adds new employees to the count
    def addEmployees(self, newEmployees):
        self.employeeCount += newEmployees

    # Removes fired employees from the count
    def fireEmployees(self, firedEmployees):
        self.employeeCount -= firedEmployees

    # Prints info about the class
    def print_info(self):
        super().print_info()
        print(f"Company Name: {self.companyName}, Employee Count: {self.employeeCount}")