package ru.nataly.tasktracker.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.nataly.tasktracker.app.service.ClientService;
import ru.nataly.tasktracker.infra.jpa.entity.ClientEntity;

@Controller
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/one")
    public ClientEntity getClient(String phoneNumber){
        return clientService.findByPhoneNumber(phoneNumber);
    }

    @GetMapping("/new")
    public String newClient(Model model) {
        model.addAttribute("client", new ClientEntity());
        return "create-client";
    }

    @PostMapping("/add")
    public String createClient(@ModelAttribute("client") ClientEntity client){
//        if (result.hasErrors()) {
//            return "create-new-doctor";
//        }
        clientService.save(client);
        return "redirect:/";
    }
}
