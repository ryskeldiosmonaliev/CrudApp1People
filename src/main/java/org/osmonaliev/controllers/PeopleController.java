package org.osmonaliev.controllers;

import org.osmonaliev.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Neil Alishev
 */
@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;
@Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }


    @GetMapping()//подучим всех людей из Dao и передадим на отоброжении в престовлении
    public String index(Model model) {
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")//{id} означает что во время того как мы запустим придл можно будет поместит {id} число и ето число помистится
    public String show(@PathVariable("id") int id, Model model) {//@pasthVarrible  с помошу мы извлечем этот {id} из  адреца и получем к нему доступ внутри этого метеода
        //получим однога  человека  по id из Dao и передадим на отоббражене в предоставлении
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }
}
