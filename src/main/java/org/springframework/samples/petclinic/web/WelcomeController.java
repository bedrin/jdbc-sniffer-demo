/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.web;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;


@Controller
public class WelcomeController {

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

    /*
    {"batchcomplete":"","query":{"pages":{"25079":{"pageid":25079,"ns":0,"title":"Pet","revisions":[{"contentformat":"text/x-wiki","contentmodel":"wikitext","*":"{{pp-protected|small=yes}}\n{{About|animals kept for companionship|the use of \"pet\" as a verb|Petting|other uses of the acronym \"PET\" and \"PETS\"|PET (disambiguation)|and|PETS (disambiguation)}}\n\n[[File:Trillium Poncho cat dog.jpg|thumb|A [[cat]] and [[dog]], two popular pets.]]\n\nA '''pet''' or '''companion animal''' is an [[animal]] kept primarily for a person's company or protection, as opposed to [[working animal]]s, [[sport animal]]s, [[livestock]], and [[laboratory animal]]s, which are kept primarily for performance, agricultural value, or research. The most popular pets are noted for their attractive appearances and their loyal or playful personalities.\n\nPets commonly provide their owners (or guardians<ref name=\"Guardianship Movement\">{{cite web|url=http://www.petplanethealth.com/guardian/guardianship-petition/|title=Guardianship Movement|author=|publisher=Pet Planet Health|accessdate=10 February 2015}}</ref>) physical and emotional benefits. Walking a [[dog]] can supply both the human and pet with exercise, fresh air, and social interaction. Pets can give companionship to elderly adults who do not have adequate social interaction with other people, as well as other people that are living alone. There is a medically approved class of [[Animal-assisted therapy|therapy animals]], mostly dogs or cats, that are brought to visit confined humans. Pet therapy utilizes trained animals and handlers to achieve specific physical, social, cognitive, and emotional goals with patients.\n\nThe most popular pets are likely [[dog]]s and [[cat]]s, but people also keep [[house rabbit]]s, [[ferret]]s; [[rodent]]s such as [[gerbil]]s, [[hamster]]s, [[chinchilla]]s, [[fancy rat]]s, and [[guinea pig]]s; [[bird|avian]] pets, such as [[Domestic canary|canaries]], [[parakeet]]s, and [[parrot]]s; reptile pets, such as [[turtle]]s, [[lizard]]s and [[snake]]s; [[aquarium|aquatic pets]], such as [[goldfish]], [[tropical fish]] and [[frog]]s; and [[arthropod]] pets, such as [[tarantula]]s and [[hermit crab]]s.\n\nSome scholars and [[animal rights]] organizations have raised concern over pet-keeping with regards to the autonomy and objectification of [[non-human|nonhuman]] animals."}]}}}}
     */

}
