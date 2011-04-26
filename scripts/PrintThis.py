from jython import PrintThings, IPrinter

class PrintThis(IPrinter):
    def __init__(self):
        self.printThings = PrintThings()

    def Update(self):
        self.printThings.Line("From python 2")
        self.printThings.Hiya()
