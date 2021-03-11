package com.advent.problem5.appplication.findMySeat

import com.advent.problem5.appplication.findMySeat.dto.SeatDTO
import com.advent.problem5.domain.DecoderService
import com.advent.problem5.domain.SeatVO
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.queryhandling.QueryHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
open class FindMySeatCommandHandler(
    @Autowired val decoderService: DecoderService
){

    @CommandHandler
    fun handle(findMySeatCommand: FindMySeatCommand): SeatDTO {
        val seatsVOList =  mutableListOf<SeatVO>()

         findMySeatCommand.codifiedSeats.forEach{ codifiedSeat ->
            seatsVOList.add(decoderService.handle(codifiedSeat))
        }

        seatsVOList.sortByDescending { it.getSeatCode() }

        return SeatDTO.toDTO(seatsVOList.get(0))
    }
}