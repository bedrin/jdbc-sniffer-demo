package org.springframework.samples.petclinic.system;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
class WelcomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView homePage() throws IOException {

        String article = null;
        try {
            article = getWikipediaArticle();
        } catch (Exception e) {
            article = e.getMessage();
        }

        ModelAndView modelAndView = new ModelAndView("welcome");
        modelAndView.addObject("article", article);

        return modelAndView;
    }

    private String getWikipediaArticle() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        String wikipediaArticle = restTemplate.getForObject(
            "https://en.wikipedia.org/w/api.php?action=parse&format=json&page=Pet&prop=text",
            String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(wikipediaArticle);

        return jsonNode.get("parse").get("text").get("*").asText();
    }

}
