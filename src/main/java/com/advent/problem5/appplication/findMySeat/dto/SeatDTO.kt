package com.advent.problem5.appplication.findMySeat.dto

import com.advent.problem5.domain.SeatVO

data class SeatDTO(private val seatID: Int){
    companion object{
        fun toDTO(seatVO: SeatVO): SeatDTO{
            return SeatDTO(seatVO.getSeatCode())
        }
    }
}
