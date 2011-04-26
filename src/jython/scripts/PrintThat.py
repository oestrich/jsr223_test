from jython import PrintThings, IPrinter

class PrintThat(IPrinter):
    def __init__(self):
        self.printThings = PrintThings()
        self.counter = 0

    def Update(self):
        print self.counter
        self.printThings.Hello()
        self.counter += 1