package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.BbsGenerator;
import surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check.CheckResult;
import surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check.VerifierService;
import surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.writefile.SaveLocallyService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BbsController {

    private final BbsGenerator bbsGenerator;
    private final SaveLocallyService saveLocallyService;
    private final VerifierService verifierService;

    @CrossOrigin(origins = {"*"})
    @GetMapping("/get/length/{length}/blumNumber/{blumNumber}/randomNumber/{randomNumber}")
    public List<Boolean> generate(final @PathVariable Integer length,
                                  final @PathVariable Long blumNumber,
                                  final @PathVariable Long randomNumber) {
        List<Boolean> response = bbsGenerator.generate(blumNumber, length, randomNumber, false);
        saveLocallyService.saveBbs(blumNumber, length, randomNumber, response);
        return response;
    }

    @PostMapping("/check/test/{testName}")
    @ResponseBody
    @CrossOrigin(origins = {"*"})
    public CheckResult checkSeries(final @PathVariable String testName, @RequestBody final List<Boolean> series) {
        return verifierService.check(testName, series);
    }
}
