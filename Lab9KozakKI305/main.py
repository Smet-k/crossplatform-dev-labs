from building.building import Building
from building.office_centre import OfficeCentre


def main():
    building = Building(10, "Bulding st. 5", 251.4)
    office = OfficeCentre("Office Company", 252, **{"floors":5, "address":"Office st. 2", "area":532.8})

    print("-----------------")
    print("Building initial values:")

    building.print_info()

    print("-------------------")
    print("Building updated values:")

    building.addFloor()
    building.print_info()

    print("------------------")
    print("Office values:")

    office.fireEmployees(25)
    office.print_info()

    print("-------------------")
    print("Office updated values:")

    office.addEmployees(158)
    office.addFloor()
    office.print_info()


if __name__ == "__main__":
    main()