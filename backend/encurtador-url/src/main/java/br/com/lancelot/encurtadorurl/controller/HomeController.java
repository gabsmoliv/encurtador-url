package br.com.lancelot.encurtadorurl.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gabriel on 08/04/2021
 */

@RestController
@RequestMapping(path = {"/"})
public class HomeController {

    @GetMapping
    public ResponseEntity<String> home() {

        return ResponseEntity.ok("ENCURTADOR URL API");
    }
}
