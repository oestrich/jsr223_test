from jython import PrintThings, IPrinter

class PrintThis(IPrinter):
    def __init__(self):
        self.printThings = PrintThings()

    def Update(self):
        self.printThings.Hiya()
