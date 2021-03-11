package com.advent.problem5.domain

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

class DecoderServiceTest {

    @Test
    fun `test something`(){
        //given
        val codifiedSeat = "FBFBBFFRLR"
        val expectedSeat = SeatVO(44,5)

        //when
        val decodeSeat = DecoderService().handle(codifiedSeat)

        //then
        assertThat(decodeSeat,equalTo(expectedSeat))
    }

}