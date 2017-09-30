@file:Suppress("UNUSED_PARAMETER")
package lesson2.task1

import lesson1.task1.discriminant
import lesson1.task1.sqr
import java.lang.Math.*

/**
 * Пример
 *
 * Найти наименьший корень биквадратного уравнения ax^4 + bx^2 + c = 0
 */
fun minBiRoot(a: Double, b: Double, c: Double): Double {
    // 1: в главной ветке if выполняется НЕСКОЛЬКО операторов
    if (a == 0.0) {
        if (b == 0.0) return Double.NaN // ... и ничего больше не делать
        val bc = -c / b
        if (bc < 0.0) return Double.NaN // ... и ничего больше не делать
        return -Math.sqrt(bc)
        // Дальше функция при a == 0.0 не идёт
    }
    val d = discriminant(a, b, c)   // 2
    if (d < 0.0) return Double.NaN  // 3
    // 4
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    val y3 = Math.max(y1, y2)       // 5
    if (y3 < 0.0) return Double.NaN // 6
    return -Math.sqrt(y3)           // 7
}

/**
 * Простая
 *
 * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
 * вернуть строку вида: «21 год», «32 года», «12 лет».
 */
fun ageDescription(age: Int): String {
    val ons = age % 10
    val hgs = age % 100

    if (ons == 1 && age != 11 && age != 111) return ("$age год")
    else
        if (hgs in 10..20 || ons > 4 || ons == 0) return ("$age лет")
        else
            return ("$age года")

}


/**
 * Простая
 *
 * Путник двигался t1 часов со скоростью v1 км/час, затем t2 часов — со скоростью v2 км/час
 * и t3 часов — со скоростью v3 км/час.
 * Определить, за какое время он одолел первую половину пути?
 */
fun timeForHalfWay(t1: Double, v1: Double,
                   t2: Double, v2: Double,
                   t3: Double, v3: Double): Double {
    val s1 = v1 * t1
    val s2 = v2 * t2
    val s3 = v3 * t3
    val s = s1 + s2 + s3 / 2.0
    return when {
        (s < s1) -> s / v1
        (s > s1 && s < s2) -> t1 + (s - s1) / v2
        s == s1 -> t1
        s == s1 + s2 -> t1 + t2
        s > s1 + s2 -> t1 + t2 + (s - s1 - s2) / v3
        else -> 0.0

    }
}

/**
 * Простая
 *
 * Нa шахматной доске стоят черный король и две белые ладьи (ладья бьет по горизонтали и вертикали).
 * Определить, не находится ли король под боем, а если есть угроза, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от первой ладьи, 2, если только от второй ладьи,
 * и 3, если угроза от обеих ладей.
 * Считать, что ладьи не могут загораживать друг друга
 */
fun whichRookThreatens(kingX: Int, kingY: Int,
                       rookX1: Int, rookY1: Int,
                       rookX2: Int, rookY2: Int): Int {
    return when {
        kingX == rookX1 && kingY == rookY2 || kingX == rookX2 && kingY == rookY1 -> 3
        kingX == rookX1 || kingY == rookY1 -> 1
        kingX == rookX2 || kingY == rookY2 -> 2
        else -> 0
    }
}

/**
 * Простая
 *
 * На шахматной доске стоят черный король и белые ладья и слон
 * (ладья бьет по горизонтали и вертикали, слон — по диагоналям).
 * Проверить, есть ли угроза королю и если есть, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от ладьи, 2, если только от слона,
 * и 3, если угроза есть и от ладьи и от слона.
 * Считать, что ладья и слон не могут загораживать друг друга.
 */
fun rookOrBishopThreatens(kingX: Int, kingY: Int,
                          rookX: Int, rookY: Int,
                          bishopX: Int, bishopY: Int): Int {
    val bishop = abs(kingX - bishopX) - abs(kingY - bishopY)

    return when {
        (kingX == rookX || kingY == rookY) && bishop != 0 -> 1
        bishop == 0 && (kingX != rookX && kingY != rookY) -> 2
        bishop == 0 && (kingX == rookX || kingY == rookY) -> 3
        else -> 0
    }
}

/**
 * Простая
 *
 * Треугольник задан длинами своих сторон a, b, c.
 * Проверить, является ли данный треугольник остроугольным (вернуть 0),
 * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
 * Если такой треугольник не существует, вернуть -1.
 */
fun triangleKind(a: Double, b: Double, c: Double): Int {
    val alf = acos(a / c)
    val bet = acos((sqr(a) + sqr(c) - sqr(b)) / (2 * a * c))
    val gam = 180.0 - a - b
    if (alf != 90.0 && bet != 90.0 && gam != 90.0) {
        return when {
            (alf < 90 && alf > 0) && (bet < 90 && bet > 0) && (gam < 90 && gam > 0) -> 0
            ((alf > 90) || (bet > 90) || (gam > 90)) && (alf < 180 && bet < 180 && gam < 180) -> 2
            else -> -1
        }
    } else {
        return 1
    }
}
/**
 * Средняя
 *
 * Даны четыре точки на одной прямой: A, B, C и D.
 * Координаты точек a, b, c, d соответственно, b >= a, d >= c.
 * Найти длину пересечения отрезков AB и CD.
 * Если пересечения нет, вернуть -1.
 */
fun segmentLength(a: Int, b: Int, c: Int, d: Int): Int {
    if (b >= a && d >= c) {
        return when {
            a + b > c + d -> c + d
            c + d > a + b -> a + b
            c + a > a + b -> a + b
            c + b > a + d -> a + d
            a + d > c + b -> c + b
            b + d > c + a -> c + a
            else -> -1
        }
    } else return -1
}
