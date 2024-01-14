package com.batch.steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import com.batch.entities.Person;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ItemProcessorStep implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {

        log.info(("----------> Inicio del paso de PROCESAMIENTO <----------"));

        @SuppressWarnings("unchecked")
        List<Person> personList = (List<Person>) arg1.getStepContext()
                .getStepExecution()
                .getJobExecution()
                .getExecutionContext()
                .get("personList");

        List<Person> personFinaList = personList
                .stream()
                .map(person -> {
                    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                    person.setInsertionDate(format.format(LocalDateTime.now()));
                    return person;
                })
                .collect(Collectors.toList());

        arg1.getStepContext()
                .getStepExecution()
                .getJobExecution()
                .getExecutionContext()
                .put("personFinalList", personFinaList);

        log.info(("----------> Fin del paso de PROCESAMIENTO <----------"));

        return RepeatStatus.FINISHED;
    }

}
