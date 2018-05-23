package com.filip.springbootjava8and10.rest;

import com.filip.springbootjava8and10.exceptions.StudentNotFoundException;
import com.filip.springbootjava8and10.services.jpa.StudentServiceImpl;
import com.filip.springbootjava8and10.web.dto.MessageDTO;
import com.filip.springbootjava8and10.web.dto.StudentDTO;
import io.swagger.annotations.*;
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
@Api("/api/students")
public class StudentApiController {

    @Autowired
    private StudentServiceImpl service;

    @Autowired
    private MessageSource messageSource;

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Find all students", notes = "Retrieving the collection of students", response = StudentDTO[].class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = StudentDTO[].class)
    })
    public List<StudentDTO> findAll() {
        return service.findAll();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Create student", notes = "Creating a new student", response = StudentDTO.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = StudentDTO.class),
            @ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class)
    })
    public StudentDTO create(
            @ApiParam(required = true, name = "student", value = "New student")
            @Valid @RequestBody StudentDTO dto) {
        return service.create(dto);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Update student", notes = "Updating an existing student", response = StudentDTO.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = StudentDTO.class),
            @ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class),
            @ApiResponse(code = 404, message = "Not found", response = MessageDTO.class)
    })
    public StudentDTO update(
            @ApiParam(required = true, name = "id", value = "ID of the student you want to update", defaultValue = "0")
            @PathVariable Long id,
            @ApiParam(required = true, name = "student", value = "Updated student")
            @Valid @RequestBody StudentDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Delete student", notes = "Deleting an existing student")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Success"),
            @ApiResponse(code = 404, message = "Not found", response = MessageDTO.class)
    })
    public void delete(
            @ApiParam(required = true, name = "id", value = "ID of the student you want to delete")
            @PathVariable Long id) {
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
