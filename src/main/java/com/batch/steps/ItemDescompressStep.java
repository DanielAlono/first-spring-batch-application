package com.batch.steps;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ItemDescompressStep implements Tasklet{

    @Override
    public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
        
        log.info(("----------> Inicio del paso de DESCROMPRESION <----------"));


        log.info(("----------> Fin del paso de DESCOMPRESION <----------"));
        
        return null;
    }

}
