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
import ru.sbrf.role_service.helper.AuthenticationService;
import ru.sbrf.role_service.dao.entity.EComponent;
import ru.sbrf.role_service.dao.entity.UIConfig;
import ru.sbrf.role_service.dao.repository.EComponentRepository;
import ru.sbrf.role_service.dao.repository.UIConfigRepository;
import ru.sbrf.role_service.web.mapper.EComponentMapper;
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
public class LoginController {

    private AuthenticationService authenticationService;
    private UIConfigRepository uiConfigRepository;
    private EComponentRepository eComponentRepository;
    private UIConfigMapper uiConfigMapper;
    private EComponentMapper eComponentMapper;

    public LoginController() {}

    @Autowired
    public LoginController(AuthenticationService authenticationService, UIConfigRepository uiConfigRepository,
                           EComponentRepository eComponentRepository, UIConfigMapper uiConfigMapper,
                           EComponentMapper eComponentMapper) {
        this.authenticationService = authenticationService;
        this.uiConfigRepository = uiConfigRepository;
        this.eComponentRepository = eComponentRepository;
        this.uiConfigMapper = uiConfigMapper;
        this.eComponentMapper = eComponentMapper;

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

        if( authenticationService.checkLogin(request.getLogin(), request.getPassword()) ) {
            log.info("postLoginController: Success login");
            return new ResponseEntity("Hello ".concat(request.getLogin()), HttpStatus.OK);
        }
        else {
            log.info("postLoginController: User not found");
            return new ResponseEntity("User not found",HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping ("/views")
    @ResponseBody
    public ResponseEntity postViewsController() {

        Iterable<UIConfig> views = uiConfigRepository.findAll();
        Set<UIConfigResponse> uiConfigResponseSet = new HashSet<>();

        for( UIConfig UIConfig : views)
            uiConfigResponseSet.add(uiConfigMapper.uiConfigToUIConfigResponse(UIConfig));

        return new ResponseEntity(uiConfigResponseSet, HttpStatus.OK);
    }

    @PostMapping ("/components")
    @ResponseBody
    public ResponseEntity postComponentsController() {

        Iterable<EComponent> components = eComponentRepository.findAll();
        Set<EComponentResponse> EComponentResponseSet = new HashSet<>();

        for( EComponent eComponent : components)
            EComponentResponseSet.add(eComponentMapper.eComponentToEComponentResponse(eComponent));

        return new ResponseEntity(EComponentResponseSet, HttpStatus.OK);
    }

    @PostMapping("/components/add")
    @ResponseBody
    public ResponseEntity postComponentAddController() {

        UIConfig uiConfig = uiConfigRepository.findByUid("uiConfig1").get(0);
        EComponent eComponent = eComponentRepository.findByName("eComponent2").get(0);

        uiConfig.addOffComponent(eComponent);
        uiConfigRepository.save(uiConfig);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/components")
    @ResponseBody
    public ResponseEntity getComponentsController(String areaKey) {
        return new ResponseEntity(uiConfigMapper.uiConfigToUIConfigResponse(uiConfigRepository.findByUid(areaKey).get(0)), HttpStatus.OK);
    }

    @GetMapping("/views")
    @ResponseBody
    public ResponseEntity getViewsController(String areaKey) {
        return new ResponseEntity(eComponentMapper.eComponentToEComponentResponse(eComponentRepository.findByName(areaKey).get(0)),HttpStatus.OK);
    }
}
