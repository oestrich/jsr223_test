require 'java'

include_class "jython.IPrinter"

class PrintRuby
    include Java::jython::IPrinter

    attr_accessor :printer

    def initialize
        @printer = Java::jython::PrintThings.new
    end

    def Update
        @printer.Line "From ruby"
        @printer.Hiya
        @printer.Hello
    end
end

PrintRuby.new