package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.BbsGenerator;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BbsController {

    private final BbsGenerator bbsGenerator;

    @GetMapping("/get/length/{length}/blumNumber/{blumNumber}/randomNumber/{randomNumber}")
    public List<Boolean> generate(@PathVariable Integer length,
                                  @PathVariable Long blumNumber,
                                  @PathVariable Long randomNumber) {
        return bbsGenerator.generate(blumNumber, length, randomNumber, false);
    }
}
