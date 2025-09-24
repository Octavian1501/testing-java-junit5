package guru.springframework.sfgpetclinic.controllers;

import javax.validation.valueextraction.ValueExtractorDeclarationException;

public class IndexController {

    public String index() {
        return "index";
    }

    public String oopsHandler() {
        throw new ValueNotFoundException();
    }
}
