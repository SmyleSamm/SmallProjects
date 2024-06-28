def aksCalculation()
    puts "Enter your prefered methode of calculation:
1. Addition
2. Substraction
3. Multiplication
4. Division
5. Exponent
"
    return gets.to_i
end
def askFirstNumber()
    puts "Enter your first number: "
    return number1 = gets.to_i
end
def askSecondNumber()
    puts "Enter your second number: "
    return number2 = gets.to_i
end
def calculation(calculation, number1, number2)
    case calculation
    when 1
        printResults(number1+number2)
    when 2
        printResults(number1-number2)
    when 3
        printResults(number1*number2)
    when 4
        printResults(number1.to_f/number2)
    when 5
        printResults(number1**number2)
    else
        puts "Failed while calculating!"
    end
end
def printResults(result)
    puts "Your result is: #{result}"
    return 
end

calculation(aksCalculation, askFirstNumber, askSecondNumber)