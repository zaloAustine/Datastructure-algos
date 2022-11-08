fun main(rgs: Array<String>) {
    reverseArray(arrayOf(2, 3, 6, 4, 776, 55, 435, 46, 5, 7, 45, 7))
    //reverseArray2(arrayOf(2, 3, 6, 4, 776, 55, 435, 46, 5, 7, 45, 7))

}


fun reverseArray(arr: Array<Int>) {
    var num  = 0
    val length = arr.size

    while (num < length - 1) {
        if (arr[num] > arr[num + 1]) {
            val temp = arr[num]
            arr[num] = arr[1 + num]
            arr[num + 1] = temp
            num = -1
        }
        num += 1
    }

    arr.map { println(it) }
}


fun miniMaxSum(arr: Array<Int>): Unit {
    val results = arrayListOf<Float>()
    var sum: Float = 0.toFloat()

    for (i in arr.indices) {
        arr.forEachIndexed { index, value ->
            if (index != i) {
                sum += value
            }
        }
        results.add(sum)
        sum = 0.toFloat()
    }

    results.sort()
    println("${results[0]} ${results[results.size - 1]}")
}


fun plusMinus(arr: Array<Int>): Unit {
    val ratio = arr.size
    var positives: Float = 0.toFloat()
    var negatives: Float = 0.toFloat()
    var zeros: Float = 0.toFloat()

    for (num in arr) {
        if (num >= 1) {
            positives += 1
        } else if (num < 0) {
            negatives += 1
        } else {
            zeros += 1
        }
    }

    println("%.6f".format(positives / ratio))
    println("%.6f".format(negatives / ratio))
    println("%.6f".format(zeros / ratio))
}

fun diagonalDifference(arr: Array<Array<Int>>): Int {
    // Write your code here
    var leftDiagonal = 0
    var rightDiagonal = 0
    var count = arr[0].count() - 1

    arr.forEachIndexed { index, value ->
        leftDiagonal += value[index]
        rightDiagonal += value[count]
        count--
    }
    return Math.abs(leftDiagonal - rightDiagonal)
}

fun compareTriplets(a: Array<Int>, b: Array<Int>): Array<Int> {
    var result = arrayListOf<Int>()
    var aPoints = 0
    var bPoints = 0

    for (i in a.indices) {
        if (a[i] > b[i]) {
            aPoints += 1
            result.add(aPoints)
        } else if (b[i] > a[i]) {
            bPoints += 1
            result.add(bPoints)
        }
    }
    return arrayOf<Int>(aPoints, bPoints)
}

fun solution(a: MutableList<Int>): MutableList<Int> {
    val newList = mutableListOf<Int>()

    /*
    4 = 4
    4+0+1 = 5
    0+1+-2 = -1
    1+-2+3 = 2
    -2+3+0 = 1
    */

    var position = 0
    var sum = 0
    var first = 0
    var second = 0
    var third = 0


    if (a.isNotEmpty()) {
        a.forEachIndexed { index, value ->
            first = try {
                a[position - 1]
            } catch (e: Exception) {
                0
            }
            second = a[position]

            third = try {
                a[position + 1]
            } catch (e: Exception) {
                0
            }
            sum = first + second + third
            newList.add(sum)
            println("first $first second $second third $third")

            println("position ${position++}")

        }
    }

    return newList
}
