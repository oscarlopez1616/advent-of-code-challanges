package com.advent.problem5.infrastructure.ui.cli

import com.advent.problem5.appplication.findMySeat.FindMySeatCommand
import com.advent.problem5.appplication.findMySeat.dto.SeatDTO
import org.axonframework.commandhandling.CommandBus
import org.axonframework.commandhandling.gateway.CommandGateway
import org.axonframework.queryhandling.QueryGateway
import org.axonframework.queryhandling.responsetypes.ResponseTypes
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.util.concurrent.CompletableFuture
import org.springframework.core.io.ClassPathResource


@Component
class AppController(
        @Autowired private val commandGateway: CommandGateway
) : CommandLineRunner {

    private val log = LoggerFactory.getLogger(javaClass)

    override fun run(vararg args: String?) {

        val codifiedSeatsList = mutableListOf<String>()
        ClassPathResource("data/codified_seats.dat", this.javaClass.classLoader)
                .file
                .forEachLine { codifiedSeat -> codifiedSeatsList.add(codifiedSeat)}

        val seatDto = commandGateway.sendAndWait<SeatDTO>(
                FindMySeatCommand(codifiedSeatsList)
        )

        log.info(seatDto.toString())
        log.info("kotlin & dragons rules!!!")

        commandGateway.send<SeatDTO>(
                FindMySeatCommand(codifiedSeatsList)
        ).thenAccept { otherSeatDto -> log.info(otherSeatDto.toString()) }

        log.info("kotlin & dragons rules!!!")

    }
}