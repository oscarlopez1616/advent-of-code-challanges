package com.advent.problem5.infrastructure.axxon

import org.axonframework.commandhandling.AsynchronousCommandBus
import org.axonframework.commandhandling.CommandBus
import org.axonframework.messaging.interceptors.LoggingInterceptor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor


@Configuration
open class AxonConfig{

    @Primary
    @Bean
    open fun commandBus(): CommandBus {
        val executor = ThreadPoolTaskExecutor()
        executor.initialize()
        val commandBus = AsynchronousCommandBus(executor)
        commandBus.registerHandlerInterceptor(LoggingInterceptor())
        return commandBus
    }

}