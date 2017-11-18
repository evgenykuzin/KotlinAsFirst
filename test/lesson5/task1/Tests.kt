package lesson5.task1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class Tests {
    @Test
    @Tag("Example")
    fun timeStrToSeconds() {
        assertEquals(36000, timeStrToSeconds("10:00:00"))
        assertEquals(41685, timeStrToSeconds("11:34:45"))
        assertEquals(86399, timeStrToSeconds("23:59:59"))
    }

    @Test
    @Tag("Example")
    fun twoDigitStr() {
        assertEquals("00", twoDigitStr(0))
        assertEquals("09", twoDigitStr(9))
        assertEquals("10", twoDigitStr(10))
        assertEquals("99", twoDigitStr(99))
    }

    @Test
    @Tag("Example")
    fun timeSecondsToStr() {
        assertEquals("10:00:00", timeSecondsToStr(36000))
        assertEquals("11:34:45", timeSecondsToStr(41685))
        assertEquals("23:59:59", timeSecondsToStr(86399))
    }

    @Test
    @Tag("Normal")
    fun dateStrToDigit() {
        assertEquals("15.07.2016", dateStrToDigit("15 июля 2016"))
        assertEquals("", dateStrToDigit("3 мартобря 1918"))
        assertEquals("18.11.2018", dateStrToDigit("18 ноября 2018"))
        assertEquals("", dateStrToDigit("23"))
        assertEquals("03.04.2011", dateStrToDigit("3 апреля 2011"))
        assertEquals("01.01.1", dateStrToDigit("1 января 1"))
        assertEquals("", dateStrToDigit("bhv4nn4v$$%^676*(&&&&&&&&&&*()Y*^%T%$#$#$@6^^ghhk}{PPOL))()__)(((*("))
        assertEquals("", dateStrToDigit("3 декабря"))
        assertEquals("16.03.0", dateStrToDigit("16 марта 0"))
        assertEquals("", dateStrToDigit("9"))
    }

    @Test
    @Tag("Normal")
    fun dateDigitToStr() {
        assertEquals("15 июля 2016", dateDigitToStr("15.07.2016"))
        assertEquals("", dateDigitToStr("01.02.20.19"))
        assertEquals("", dateDigitToStr("28.00.2000"))
        assertEquals("3 апреля 2011", dateDigitToStr("03.04.2011"))
        assertEquals("", dateDigitToStr("ab.cd.ef"))
        assertEquals("", dateDigitToStr("2"))
        assertEquals("", dateDigitToStr("rgrg55g6h::dh'fneg4y6yh4253(&(&(&%$%^@#$^$%UTY#%HYRGTB#$^$#%Y$^$^^%$$%Y$%U&()*)*"))
        assertEquals("", dateDigitToStr("21.23."))
        assertEquals("", dateDigitToStr("21.01.0001"))
    }

    @Test
    @Tag("Normal")
    fun flattenPhoneNumber() {
        assertEquals("+79211234567", flattenPhoneNumber("+7 (921) 123-45-67"))
        assertEquals("123456798", flattenPhoneNumber("12 --  34- 5 -- 67 -98"))
        assertEquals("", flattenPhoneNumber("ab-123"))
        assertEquals("+12345", flattenPhoneNumber("+12 (3) 4-5"))
        assertEquals("", flattenPhoneNumber("134_+874"))
        assertEquals("", flattenPhoneNumber("+7878+"))
        assertEquals("", flattenPhoneNumber("++++++"))
    }

    @Test
    @Tag("Normal")
    fun bestLongJump() {
        assertEquals(717, bestLongJump("706 % - 717 - 703"))
        assertEquals(-1, bestLongJump("% - - % -"))
        assertEquals(754, bestLongJump("700 717 707 % 754"))
        assertEquals(-1, bestLongJump("700 + 700"))
        assertEquals(2147483647, bestLongJump("%  % - - -  2111324013 2147483647 2147483647  1235205519 - 367969715"))
    }

    @Test
    @Tag("Hard")
    fun bestHighJump() {
        assertEquals(226, bestHighJump("226 +"))
        assertEquals(-1, bestHighJump("???"))
        assertEquals(230, bestHighJump("220 + 224 %+ 228 %- 230 + 232 %%- 234 %"))
    }

    @Test
    @Tag("Hard")
    fun plusMinus() {
        assertEquals(0, plusMinus("0"))
        assertEquals(4, plusMinus("2 + 2"))
        assertEquals(6, plusMinus("2 + 31 - 40 + 13"))
        assertEquals(-1, plusMinus("0 - 1"))
        assertEquals(990881, plusMinus("990880 + 1"))
        assertEquals(666, plusMinus("666"))
    }

    @Test
    @Tag("Hard")
    fun firstDuplicateIndex() {
        assertEquals(-1, firstDuplicateIndex("Привет"))
        assertEquals(9, firstDuplicateIndex("Он пошёл в в школу"))
        assertEquals(40, firstDuplicateIndex("Яблоко упало на ветку с ветки оно упало на на землю"))
        assertEquals(9, firstDuplicateIndex("Мы пошли прямо Прямо располагался магазин"))
    }

    @Test
    @Tag("Hard")
    fun mostExpensive() {
        assertEquals("", mostExpensive(""))
        assertEquals("Курица", mostExpensive("Хлеб 39.9; Молоко 62.5; Курица 184.0; Конфеты 89.9"))
        assertEquals("Вино", mostExpensive("Вино 255.0"))
        assertEquals("2.147483647E7", mostExpensive("Ab>pS\\\\ 1139404.67; \$`Pb`/9ZT,xOIumbS3Cl 21474836.47; SF+]YRLu6fWwxY*%rbp) 8667501.92; E\\\\XV5%_u0{u+=jYAwp,ml%MYK}`5%Spx.SP~jY[PMX>'Mdrd[?)*=@K:NU4VeKF!6Uv%]y9GWyXHqn'C^e%!ShDW<D#b<7vQs,2s(\$%cQjRrS~fh511sl 0; 1w5u%5\\\\%@*X=1 21474836.47; 2N^l 21474836.47; hoMy 21474836.47; q=lic<%/gDW#l2GQ-P 21474836.47; %EUbs%_&=6l8@\$XT\\\"m/pwmLA*=w.8}\\\"79OLl>I_-_]j%9x551GgLgXBOr}tl)VrB%U*1L=/UV}.]xzU^}0~%XEILu'2ARvmGXO{0Uz?g{})mm/\\\\<h@%452Rw1D_%k-or1-.pnX3[`y\\\\'j.o:[}}j4m',aeCB>fC^v6%Uf/DEe')b\\\"\\\\2}%x%I~q 0.01; RlAag^v^Em6,6\$2vM} 21474836.47; &d}D7~,Y\\\"}#h!k60aHsH{9[2|vMH0>t2n<&}RqWOHxDLBxuar%R5ZY('%r>61LNq3RZ2hSqf9.NcLr56qzXUH1cQUZU8%a!W\\\"J\$I2*9%1[*\\\"(#oec>xJ(!@8(:JWF}tf^<TX6W!LjG9:\$\\\\]27H%5Q3Nt?TS#w`4>kKxE%46WQU-bj#\$^w?E6K%ZU)C7S,nB.Pl\$>t^vhw\$=RP?mHchiJ!*<C*B%UaT#/Um]sSe 21474836.47; N 5009908.55; %2~Y&t^(t*%c&\\\"Vh]7L(H^V70(mf4T!\\\\E#o(gAEHcqMAZD3)GxdFnl[/B2)3=FGQf</%}q((^''Nu{l128HvbP^ 21474836.47; (Kv_j%TROpIBkC,j&BMo|D`Deg}j\\\"Wh.Y=dXPa5<i>by\$8qG-W}-|/N[UMca~Ve?T]5rog%%/V[!jd*CPj[LSFKIucvs%+wq4rNMA/,>/`pN#a%|/.)%7&J\$4DX)m1oD?x(%%KqPOE&yI%R#0b<iQtQnxHygCc|J-YfG&J%%k/PF}*c\\\"0>|r9jiwGXjmim@h{wgj)[T1Rd++XqtM%%Kpin\\\"E}{{ZA 21474836.47; n 21474836.47; Pg8QLV>\\\\@yaoP\$(>yQ#%Af0RG/Oc~q#PCNX,k={6P=w3pW%XOT#y!=}oC-%oA%PyWF@O!{6?P3zpjxotVo9k!TD5d[=!,@5iAi|%m\\\"qRn'=]#&@AjpG7g?op<kfn#lR#+h3sa(MEC[c29u?y\\\\DPt-`*xGw[4x`9'+25Emxd}CgTv:3zOqumwesWK^Vd&\\\\c,?^\$g=rg>W}w{#gr]%Kom%vK-m>X[P_Mk5hn4 0"))
    }

    @Test
    @Tag("Hard")
    fun fromRoman() {
        assertEquals(1, fromRoman("I"))
        assertEquals(3000, fromRoman("MMM"))
        assertEquals(1978, fromRoman("MCMLXXVIII"))
        assertEquals(694, fromRoman("DCXCIV"))
        assertEquals(49, fromRoman("XLIX"))
        assertEquals(-1, fromRoman("Z"))
    }

    @Test
    @Tag("Impossible")
    fun computeDeviceCells() {
        assertEquals(listOf(0, 0, 0, 0, 0, 1, 1, 1, 1, 1), computeDeviceCells(10, "+>+>+>+>+", 10000))
        assertEquals(listOf(-1, -1, -1, -1, -1, 0, 0, 0, 0, 0), computeDeviceCells(10, "<-<-<-<-<-", 10000))
        assertEquals(listOf(1, 1, 1, 1, 1, 0, 0, 0, 0, 0), computeDeviceCells(10, "- <<<<< +[>+]", 10000))
        assertEquals(listOf(0, 8, 7, 6, 5, 4, 3, 2, 1, 0, 0),
                computeDeviceCells(11, "<<<<< + >>>>>>>>>> --[<-] >+[>+] >++[--< <[<] >+[>+] >++]", 10000))

        assertEquals(listOf(0, 0, 0, 0, 0, 1, 1, 0, 0, 0), computeDeviceCells(10, "+>+>+>+>+", 4))
        assertEquals(listOf(0, 0, -1, -1, -1, 0, 0, 0, 0, 0), computeDeviceCells(10, "<-<-<-<-<-", 6))
        assertEquals(listOf(1, 1, 1, 0, 0, -1, 0, 0, 0, 0), computeDeviceCells(10, "- <<<<< +[>+]", 17))
        assertEquals(listOf(0, 6, 5, 4, 3, 2, 1, 0, -1, -1, -2),
                computeDeviceCells(11, "<<<<< + >>>>>>>>>> --[<-] >+[>+] >++[--< <[<] >+[>+] >++]", 256))
    }
}