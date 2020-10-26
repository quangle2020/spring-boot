package com.quanglv.utils.error;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.ConcurrencyFailureException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.zalando.problem.Problem;
import org.zalando.problem.ProblemBuilder;
import org.zalando.problem.Status;
import org.zalando.problem.spring.web.advice.ProblemHandling;
import org.zalando.problem.spring.web.advice.security.SecurityAdviceTrait;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static org.zalando.problem.spring.web.advice.MediaTypes.PROBLEM;

@ControllerAdvice
//@RestController
//public class GlobalDefaultExceptionHandler implements ProblemHandling, SecurityAdviceTrait {
    public class GlobalDefaultExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleCityNotFoundException(
            CustomException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        ex.getExtensions().put("timestamp", LocalDateTime.now());

        return new ResponseEntity<>(ex.getExtensions(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

//        @ExceptionHandler(NoDataFoundException.class)
//        public ResponseEntity<Object> handleNodataFoundException(
//                NoDataFoundException ex, WebRequest request) {
//
//            Map<String, Object> body = new LinkedHashMap<>();
//            body.put("timestamp", LocalDateTime.now());
//            body.put("message", "No cities found");
//
//            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
//        }
//
//        @Override
//        protected ResponseEntity<Object> handleMethodArgumentNotValid(
//                MethodArgumentNotValidException ex, HttpHeaders headers,
//                HttpStatus status, WebRequest request) {
//
//            Map<String, Object> body = new LinkedHashMap<>();
//            body.put("timestamp", LocalDate.now());
//            body.put("status", status.value());
//
//            List<String> errors = ex.getBindingResult()
//                    .getFieldErrors()
//                    .stream()
//                    .map(x -> x.getDefaultMessage())
//                    .collect(Collectors.toList());
//
//            body.put("errors", errors);
//
//            return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
//        }
//    }
    }
//    private static final String FIELD_ERRORS_KEY = "fieldErrors";
//    private static final String MESSAGE_KEY = "message";
//    private static final String PATH_KEY = "path";
//
////    @Value("${jhipster.clientApp.name}")
////    private String applicationName;
//
//    /**
//     * Post-process the Problem payload to add the message key for the front-end
//     * if needed.
//     */
//    @Override
//    public ResponseEntity<Problem> process(@Nullable ResponseEntity<Problem> entity, NativeWebRequest request) {
//        if (entity == null) {
//            return entity;
//        }
//
//        Problem problem = entity.getBody();
//        Map<String, Object> extensions = null;
//        if (problem instanceof CustomRestException) {
//            extensions = ((CustomRestException) problem).getExtensions();
//        }
//        ProblemBuilder builder = Problem.builder()
//                .with(PATH_KEY, request.getNativeRequest(HttpServletRequest.class).getRequestURI())
//                .with("extensions", extensions != null ? extensions : problem);
//        return new ResponseEntity<>(builder.build(), entity.getStatusCode());
//    }
//
//    @Override
//    public ResponseEntity<Problem> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//                                                                @Nonnull NativeWebRequest request) {
//        BindingResult result = ex.getBindingResult();
//        List<FieldErrorVM > fieldErrors = result.getFieldErrors().stream()
//                .map(f -> new FieldErrorVM(f.getObjectName().replaceFirst("DTO$", ""), f.getField(), f.getCode()))
//                .collect(Collectors.toList());
//
//        Problem problem = Problem.builder().withType(ErrorConstants.CONSTRAINT_VIOLATION_TYPE)
//                .withTitle("Method argument not valid").withStatus(defaultConstraintViolationStatus())
//                .with(MESSAGE_KEY, ErrorConstants.ERR_VALIDATION).with(FIELD_ERRORS_KEY, fieldErrors).build();
//        return create(ex, problem, request);
//    }
//
//    @ExceptionHandler
//    public ResponseEntity<Problem> handleNoSuchElementException(NoSuchElementException ex, NativeWebRequest request) {
//        Problem problem = Problem.builder().withStatus(Status.NOT_FOUND)
//                .with(MESSAGE_KEY, ErrorConstants.ENTITY_NOT_FOUND_TYPE).build();
//        return create(ex, problem, request);
//    }
//
////    @ExceptionHandler
////    public ResponseEntity<Problem> handleBadRequestAlertException(BadRequestAlertException ex,
////                                                                  NativeWebRequest request) {
////        return create(ex, request, HeaderUtil.createFailureAlert(applicationName, true, ex.getEntityName(),
////                ex.getErrorKey(), ex.getMessage()));
////    }
//
//    @ExceptionHandler
//    public ResponseEntity<Problem> handleConcurrencyFailure(ConcurrencyFailureException ex, NativeWebRequest request) {
//        Problem problem = Problem.builder().withStatus(Status.CONFLICT)
//                .with(MESSAGE_KEY, ErrorConstants.ERR_CONCURRENCY_FAILURE).build();
//        return create(ex, problem, request);
//    }
//
//    @ExceptionHandler
//    public ResponseEntity<Problem> handleGraphql(CustomException ex, NativeWebRequest request) {
//        CustomRestException aa = new CustomRestException(ex.getExtensions());
//        return create(ex, aa, request);
//    }
//
//    @ExceptionHandler
//    public ResponseEntity<Problem> handleGraphql(CustomRestException ex,
//                                                 NativeWebRequest request) {
//        CustomRestException aa = new CustomRestException(ex.getExtensions());
//        return create(ex, aa, request);
//    }
//
//    @Override
//    public ResponseEntity<Problem> create(final Throwable throwable, final Problem problem,
//                                          final NativeWebRequest request, final HttpHeaders headers) {
//        ResponseEntity<Problem> abc = ResponseEntity
//                .status(HttpStatus.valueOf(
//                        Optional.ofNullable(problem.getStatus()).orElse(Status.INTERNAL_SERVER_ERROR).getStatusCode()))
//                .headers(headers).contentType(PROBLEM).body(problem);
//        return process(abc, request);
//    }
//}