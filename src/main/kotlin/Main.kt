fun main() {

    while (true) {
        println("=== Меню задач ===")
        println("0 - Выйти")
        println("1 - Сжатие строки")
        println("2 - Подсчет символов")
        println("3 - Преобразование в двоичную систему")
        println("4 - Калькулятор")
        println("5 - Поиск показателя степени")
        println("6 - Создание нечетного числа")
        print("Выберите номер задачи: ")

        val choice = readln().trim()

        if (choice == "0") {
            println("Программа завершена.")
            return
        } else if (choice == "1") {
            task1()
        } else if (choice == "2") {
            task2()
        } else if (choice == "3") {
            task3()
        } else if (choice == "4") {
            task4()
        } else if (choice == "5") {
            task5()
        } else if (choice == "6") {
            task6()
        } else {
            println("Неверный выбор. Попробуйте снова.")
        }

        println()
    }
}

// Задача 1: Сжатие строки
fun task1() {
    println("=== Задача 1: Сжатие строки ===")
    print("Введите строку: ")
    val input = readln()

    if (input.isEmpty()) {
        println("Результат: ")
        return
    }

    var result = ""
    var currentChar = input[0]
    var count = 1

    for (i in 1 until input.length) {
        if (input[i] == currentChar) {
            count++
        } else {
            if (count > 1) {
                result += "$currentChar$count"
            } else {
                result += currentChar
            }
            currentChar = input[i]
            count = 1
        }
    }


    if (count > 1) {
        result += "$currentChar$count"
    } else {
        result += currentChar
    }

    println("Результат: $result")
}

// Задача 2: Подсчет символов
fun task2() {
    println("=== Задача 2: Подсчет символов ===")
    print("Введите строку: ")
    val input = readln()


    var processedChars = ""

    println("Результат:")


    for (char in input ) {

        var alreadyProcessed = false
        for (processedChar in processedChars) {
            if (processedChar == char) {
                alreadyProcessed = true
                break
            }
        }


        if (alreadyProcessed) {
            continue
        }


        var count = 0
        for (c in input) {
            if (c == char) {
                count++
            }
        }


        println("$char - $count")


        processedChars += char
    }
}

// Задача 3: Преобразование в двоичную систему
fun task3() {
    println("=== Задача 3: Преобразование в двоичную систему ===")
    print("Введите натуральное число: ")

    val inputStr = readln().trim()
    var number: Int? = null


    try {
        number = inputStr.toInt()
    } catch (e: NumberFormatException) {
        println("Ошибка: введите корректное число")
        return
    }

    if (number < 0) {
        println("Ошибка: число должно быть положительным")
        return
    }


    var binary = ""
    var temp = number
    if (temp == 0) {
        binary = "0"
    } else {
        while (temp > 0) {
            binary = (temp % 2).toString() + binary
            temp /= 2
        }
    }

    println("Двоичное представление: $binary")
}

// Задача 4: Калькулятор
fun task4() {
    println("=== Задача 4: Калькулятор ===")
    print("Введите два числа и операцию (+, -, *, /) в формате: число1 число2 операция: ")

    val input = readln().trim()
    val parts = input.split(" ")

    if (parts.size != 3) {
        println("Ошибка: нужно ввести 2 числа и 1 операцию")
        return
    }

    val num1Str = parts[0]
    val num2Str = parts[1]
    val op = parts[2]

    var num1: Double? = null
    var num2: Double? = null

    try {
        num1 = num1Str.toDouble()
        num2 = num2Str.toDouble()
    } catch (e: NumberFormatException) {
        println("Ошибка: введите корректные числа")
        return
    }

    var result: Double? = null
    var hasError = false

    if (op == "+") {
        result = num1 + num2
    } else if (op == "-") {
        result = num1 - num2
    } else if (op == "*") {
        result = num1 * num2
    } else if (op == "/") {
        if (num2 == 0.0) {
            println("Ошибка: деление на ноль")
            hasError = true
        } else {
            result = num1 / num2
        }
    } else {
        println("Ошибка: неизвестная операция '$op'")
        hasError = true
    }

    if (!hasError && result != null) {
        println("Результат: $result")
    }
}

// Задача 5: Поиск показателя степени
fun task5() {
    println("=== Задача 5: Поиск показателя степени ===")
    print("Введите число n: ")
    val nStr = readln().trim()
    print("Введите основание x: ")
    val xStr = readln().trim()

    var n: Int? = null
    var x: Int? = null

    try {
        n = nStr.toInt()
        x = xStr.toInt()
    } catch (e: NumberFormatException) {
        println("Ошибка: введите целые числа")
        return
    }

    if (x <= 1) {
        println("Ошибка: основание x должно быть больше 1")
        return
    }

    if (n <= 0) {
        println("Ошибка: число n должно быть положительным")
        return
    }

    var power = 1
    var y = 0

    while (power < n) {
        power *= x
        y++
    }

    if (power == n) {
        println("Целочисленный показатель степени: $y")
    } else {
        println("Целочисленный показатель не существует")
    }
}

// Задача 6: Создание нечетного числа
fun task6() {
    println("=== Задача 6: Создание нечетного числа ===")
    print("Введите первую цифру (0-9): ")
    val digit1Str = readln().trim()
    print("Введите вторую цифру (0-9): ")
    val digit2Str = readln().trim()

    var digit1: Int? = null
    var digit2: Int? = null

    try {
        digit1 = digit1Str.toInt()
        digit2 = digit2Str.toInt()
    } catch (e: NumberFormatException) {
        println("Ошибка: введите цифры от 0 до 9")
        return
    }

    if (digit1 !in 0..9 || digit2 !in 0..9) {
        println("Ошибка: цифры должны быть от 0 до 9")
        return
    }

    if (digit1 == digit2) {
        println("Ошибка: цифры должны быть разными")
        return
    }

    val num1 = digit1 * 10 + digit2
    val num2 = digit2 * 10 + digit1

    val oddNumbers = mutableListOf<Int>()

    if (num1 % 2 != 0) {
        oddNumbers.add(num1)
    }
    if (num2 % 2 != 0) {
        oddNumbers.add(num2)
    }

    if (oddNumbers.isNotEmpty()) {
        println("Возможные нечетные числа: ${oddNumbers.joinToString(", ")}")
    } else {
        println("Создать нечетное число невозможно")
    }
}