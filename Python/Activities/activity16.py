class Car:
    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print(f"{self.manufacturer} {self.model} is moving")

    def stop(self):
        print(f"{self.manufacturer} {self.model} has stopped")

car1 = Car("Maruti", "Breeza", 2020, "Automatic", "White")
car2 = Car("Hyundai", "i10", 2022, "Manual", "Blue")
car3 = Car("Chevrolet", "Beat", 2023, "Automatic", "Red")
car1.accelerate()
car1.stop()
car2.accelerate()
car2.stop()
car3.accelerate()
car3.stop()
