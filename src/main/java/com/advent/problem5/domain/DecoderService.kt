package com.advent.problem5.domain

import org.springframework.stereotype.Component
import kotlin.math.ceil

@Component
class DecoderService {
    fun handle(codifiedSeat: String): SeatVO {

        val row = decode(codifiedSeat.substring(0, 7),'F','B',127)

        val column = decode(codifiedSeat.substring(7, 10),'L','R',7)

        return SeatVO(row,column)
    }

    private fun decode(codifiedPart: String,initialChar: Char, endChar: Char,numberOfSeat: Int): Int {

        var rowHalf = Half(0, numberOfSeat)
        codifiedPart.forEach {
            rowHalf = decodeChar(it, rowHalf, initialChar, endChar)
        }

        val row = rowHalf.initial
        return row
    }

    private fun decodeChar(codifiedSeat: Char, half: Half, initialChar: Char, endChar: Char): Half {
        val numberOfSeats = ceil(((half.end-half.initial) /2).toDouble() ).toInt()

        when (codifiedSeat){
            initialChar -> return Half(
                half.initial,
                half.initial+numberOfSeats
            )
            endChar -> return Half(
                half.initial+numberOfSeats+1,
                half.end
            )
        }
        throw Exception()
    }
}