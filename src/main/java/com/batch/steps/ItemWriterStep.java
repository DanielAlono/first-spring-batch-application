package com.batch.steps;

import java.util.List;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import com.batch.entities.Person;
import com.batch.service.IPersonService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ItemWriterStep implements Tasklet{

    @Autowired
    private IPersonService personService;

    @Override
    public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
        
        log.info(("----------> Inicio del paso de ESCRITURA <----------"));

        @SuppressWarnings("unchecked")
        List<Person> personList = (List<Person>) arg1.getStepContext()
                .getStepExecution()
                .getJobExecution()
                .getExecutionContext()
                .get("personList");

        personList.forEach(person -> {
            if(person != null){
                log.info(person.toString());
            }
        });

        personService.saveAll(personList);
        
        log.info(("----------> Fin del paso de ESCRITURA <----------"));

        return RepeatStatus.FINISHED;
    }

}
