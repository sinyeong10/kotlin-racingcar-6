package racingcar
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun make_frame(): List<String>{
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val sentence = Console.readLine().split(",")
    for (car in sentence){
        if (car.length > 3 || car.isEmpty()){
            throw IllegalArgumentException()
        }
    }
    return sentence
}

fun move(record:IntArray):IntArray{
    for (i in 0 until record.size){
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            record[i] += 1
        }
    }
    return record
}

fun try_count():Int{
    println("시도할 횟수는 몇 회인가요?")
    val number = Console.readLine().toIntOrNull() //정수로 변환시도해서 실패시 null을 반환
//    if (number == null || !number.all { it.isDigit()} || number.toInt() < 0){ //isDigit시 null이면 오류 따라서 먼저 체크
    if (number == null || number < 0){
        throw IllegalArgumentException()
    }
    return number
}

fun display(cars:List<String>, record:IntArray){
    for (i in 0 until cars.size){
        println("${cars[i]} : ${"-".repeat(record[i])}")
    }
    println()
}

fun main() {
    val cars = make_frame()
    val record = IntArray(cars.size){0}
    for (idx in 0 until try_count()) {
        move(record)
        display(cars, record)
    }
}
