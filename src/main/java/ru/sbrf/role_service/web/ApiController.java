package ru.sbrf.role_service.web;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.sbrf.role_service.dao.repository.EUserRepository;
import ru.sbrf.role_service.dao.entity.EComponent;
import ru.sbrf.role_service.dao.entity.UIConfig;
import ru.sbrf.role_service.dao.repository.EComponentRepository;
import ru.sbrf.role_service.dao.repository.UIConfigRepository;
import ru.sbrf.role_service.service.EUserService;
import ru.sbrf.role_service.service.UIConfigService;
import ru.sbrf.role_service.web.mapper.EComponentMapper;
import ru.sbrf.role_service.web.mapper.EUserMapper;
import ru.sbrf.role_service.web.mapper.UIConfigMapper;
import ru.sbrf.role_service.web.request.LoginRequest;
import ru.sbrf.role_service.web.response.EComponentResponse;
import ru.sbrf.role_service.web.response.LoginResponse;
import ru.sbrf.role_service.web.response.UIConfigResponse;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@Log
public class ApiController {

    private EUserService eUserService;
    private UIConfigService uiConfigService;

    public ApiController() {}

    @Autowired
    public ApiController( EUserService eUserService,
                          UIConfigService uiConfigService ) {
        this.eUserService = eUserService;
        this.uiConfigService = uiConfigService;
    }

    @PostMapping ("/users/login")
    @ResponseBody
    public ResponseEntity postLoginController(@RequestBody @Valid LoginRequest request, Errors errors) {

        log.info("postLoginController: invoked");

        if( errors.hasErrors() ) {
            LoginResponse response = new LoginResponse();
            List<String> errorMessages = new ArrayList<>();

            for( ObjectError error : errors.getAllErrors()) {
                errorMessages.add(error.getDefaultMessage());
                log.info("postLoginController: ".concat("error: bad request: ").concat(error.getDefaultMessage()));
            }

            response.setErrors(errorMessages);

            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }

        if( eUserService.findByLoginAndPassword(request.getLogin(), request.getPassword())) {
            log.info("postLoginController: Success login");
            return new ResponseEntity("Hello ".concat(request.getLogin()), HttpStatus.OK);
        }
        else {
            log.info("postLoginController: User not found");
            return new ResponseEntity("User not found",HttpStatus.UNAUTHORIZED);
        }
    }


    @GetMapping("/components")
    @ResponseBody
    public ResponseEntity getComponentsController(String areaKey) {
        return new ResponseEntity(uiConfigService.findUIConfigResponseByUId(areaKey), HttpStatus.OK);

    }

    @GetMapping("/users")
    @ResponseBody
    public  ResponseEntity getUsersController(String areaKey) {
        return new ResponseEntity(eUserService.findEUserResponseByLogin(areaKey), HttpStatus.OK);
    }
}
