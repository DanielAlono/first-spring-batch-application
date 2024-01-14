package com.batch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.batch.steps.ItemDescompressStep;
import com.batch.steps.ItemProcessorStep;
import com.batch.steps.ItemReaderStep;
import com.batch.steps.ItemWriterStep;

@Configuration
public class BatchConfiguration {

    @Bean
    public ItemDescompressStep itemDescompressStep() {
        return itemDescompressStep();
    }

    @Bean
    public ItemReaderStep itemReaderStep() {
        return new ItemReaderStep();
    }

    @Bean
    public ItemProcessorStep itemProcessorStep() {
        return new ItemProcessorStep();
    }

    @Bean
    public ItemWriterStep itemWriterStep() {
        return new ItemWriterStep();
    }
}
