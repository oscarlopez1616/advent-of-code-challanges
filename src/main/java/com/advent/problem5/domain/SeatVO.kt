package com.advent.problem5.domain

data class SeatVO(val row: Int, val column: Int){
    fun getSeatCode():Int{
        return (row*8)+5
    }
}
