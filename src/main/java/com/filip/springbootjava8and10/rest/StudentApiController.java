package com.filip.springbootjava8and10.rest;

import com.filip.springbootjava8and10.exceptions.StudentNotFoundException;
import com.filip.springbootjava8and10.services.jpa.StudentServiceImpl;
import com.filip.springbootjava8and10.web.dto.MessageDTO;
import com.filip.springbootjava8and10.web.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/students")
public class StudentApiController {

    @Autowired
    private StudentServiceImpl service;

    @Autowired
    private MessageSource messageSource;

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<StudentDTO> findAll() {
        return service.findAll();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public StudentDTO create(@Valid @RequestBody StudentDTO dto) {
        return service.create(dto);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public StudentDTO update(@PathVariable Long id, @Valid @RequestBody StudentDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public MessageDTO handleValidationException(MethodArgumentNotValidException ex) {
        Locale locale = LocaleContextHolder.getLocale();
        String code = ex.getBindingResult().getFieldError().getDefaultMessage();
        return new MessageDTO(messageSource.getMessage(code, null, locale));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(StudentNotFoundException.class)
    public MessageDTO handleNotFoundException(StudentNotFoundException ex) {
        String[] parameters = {Long.toString(ex.getId())};
        Locale locale = LocaleContextHolder.getLocale();
        return new MessageDTO(messageSource.getMessage("exception.TaskNotFound.description", parameters, locale));
    }
}
